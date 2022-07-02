package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.*;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class CartScreenController {
	private Store store;
	private Cart cart;
	private boolean filterByID = true;
	private boolean sortByTitle = true;
	private FilteredList<Media> filteredCart;
	private JFrame stage;
	
	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	
	@FXML
	private TableColumn<Media, String> colMediaCost;
	
	@FXML
	private Button btnPlay;
	
	@FXML
	private Button btnRemove;
	
	@FXML
	private Button btnDetails;
	
	@FXML
	private TextField tfFilter;
	
	@FXML
	private Label costLabel;
	
	
	public CartScreenController(Store store, Cart cart, JFrame stage) {
		super();
		this.store = store;
		this.cart = cart;
		this.stage = stage;
	}
	
	@FXML
	public void initialize() {
		filteredCart = new FilteredList<Media>(this.cart.getItemsOrdered(), s -> true);
		
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, String>("cost"));
		tblMedia.setItems(filteredCart);
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		btnDetails.setVisible(false);
		
		costLabel.setText(String.valueOf(this.cart.totalCost()));
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {

					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						updateButtonBar(newValue);
					}	
		});
		
		tfFilter.textProperty().addListener(new ChangeListener<String> () {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}
		});
		
	}
	
	private void updateButtonBar(Media media) {
		if (media == null) {
			btnRemove.setVisible(false);
			btnDetails.setVisible(false);
			btnPlay.setVisible(false);
		} else {
			btnRemove.setVisible(true);
			btnDetails.setVisible(true);
			if (media instanceof Playable) {
				btnPlay.setVisible(true);
			} else {
				btnPlay.setVisible(false);
			}
		}
	}
	
	private void showFilteredMedia(String filter) {
		if (filter == null || filter.length() == 0) {
			filteredCart.setPredicate(s -> true);
		} else {
			if (filterByID) {
				try {
					filteredCart.setPredicate(s -> s.getID() == Integer.parseInt(filter));
				} catch (NumberFormatException e) {}
			} else {
				filteredCart.setPredicate(s -> s.getTitle().toLowerCase().contains(filter));
			}
		}
	}
	
	@FXML
	private void removeButtonPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		try {
			this.cart.removeMedia(media);
		} catch (NonExistingItemException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Notification");
			alert.setHeaderText("Failed to remove");
			alert.setContentText("Media not in cart");
			alert.showAndWait();
		}
		costLabel.setText(String.valueOf(this.cart.totalCost()));
	}
	
	@FXML
	private void playButtonPressed(ActionEvent event) {
		Media media = this.tblMedia.getSelectionModel().getSelectedItem();
		try {
			((Playable)media).play();
		} catch (PlayerException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Media Player");
			alert.setHeaderText("ERROR: Media length is non-positive.");
			alert.setContentText("Media cannot be played.");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void detailsButtonPressed(ActionEvent event) {
		Media media = this.tblMedia.getSelectionModel().getSelectedItem();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Detail infomation");
		alert.setHeaderText("Viewing " + media.getTitle() + " detail infomation.");
		alert.setContentText(media.getDetails());
		alert.showAndWait();
	}
	
	@FXML
	private void placeOrderPressed(ActionEvent event) {	
		if (this.cart.getSize() > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Notification");
			alert.setHeaderText("Success!");
			alert.setContentText("Your order has been placed.");
			alert.showAndWait();
			this.cart.empty();
			costLabel.setText(String.valueOf(this.cart.totalCost()));
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Notification");
			alert.setHeaderText("ERROR: Failed to place order.");
			alert.setContentText("Your cart is empty");
			alert.showAndWait();
		}
		
	}
	
	@FXML
	private void setFilterByID() {
		this.filterByID = true;
	}
	
	@FXML 
	private void setFilterByTitle() {
		this.filterByID = false;
	}
	
	@FXML
	private void sortBtnPressed() {
		if (sortByTitle) {
			this.cart.sortByTitle();
		} else {
			this.cart.sortByCost();
		}
	}
	
	@FXML
	private void setSortByTitle() {
		this.sortByTitle = true;
	}
	
	@FXML
	private void setSortByCost() {
		this.sortByTitle = false;
	}
	
	@FXML
	private void viewStore() {
		new StoreScreen(store,cart);
		stage.hide();
	}
	
	@FXML
	private void addDVDToStore() {
		new AddDVDToStoreScreen(store, cart);
		stage.hide();
	}
	
	@FXML
	private void addBookToStore() {
		new AddBookToStoreScreen(store, cart);
		stage.hide();
	}
	
	@FXML
	private void addCDToStore() {
		new AddCDToStoreScreen(store, cart);
		stage.hide();
	}
	
}

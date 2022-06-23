package hust.soict.dsai.aims.screen;

import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.*;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class AddBookToStoreScreenController extends AddItemToStoreScreenController {
	private Book book;
	private ArrayList<String> authors = new ArrayList<String>();
	private int numPages;
	
	@FXML
	private TextField tfAuthors;
	
	@FXML
	private TextField tfNumPages;
	
	public AddBookToStoreScreenController(Store store, Cart cart, JFrame stage) {
		super(store, cart, stage);
	}

	public void initialize() {
		
		tfNumPages.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					numPages = Integer.parseInt(newValue);
				} catch (NumberFormatException e) {
					numPages = 0;
				}
			}
			
		});
		
		super.initialize();
	}
	
	@FXML
	private void addAuthorBtnPressed() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("You can add new author");
		dialog.setContentText("Please enter author name:");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    authors.add(result.get());
		    if (tfAuthors.getText().length() == 0) {
		    	tfAuthors.setText(result.get());
		    } else {
		    	tfAuthors.setText(tfAuthors.getText() + ", " + result.get());
		    }
		}
	}
	
	@FXML
	@Override
	protected void addBtnPressed() {
		book = new Book(this.title, this.category, this.numPages, this.cost);
		for (String author: authors) {
			try {
				book.addAuthor(author);
			} catch (DupplicatedItemException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Notification");
				alert.setHeaderText("Failure");
				alert.setContentText("List of authors contains duplicated names.");
				alert.showAndWait();
				tfAuthors.setText("");
				return;
			}
		}
		try {
			store.addMedia(book);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Notification");
			alert.setHeaderText("Success");
			alert.setContentText(book.getTitle() + " has been added to the store");
			alert.showAndWait();
		} catch (DupplicatedItemException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Notification");
			alert.setHeaderText("Failure");
			alert.setContentText("Failed to add book. Please enter valid information.");
			alert.showAndWait();
		}
	}
}

package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	private boolean paintable = true;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (paintable) {
    		drawingAreaPane.getChildren().add(new Circle(event.getX(), event.getY(), 4, Color.BLACK));
    	} else {
    		drawingAreaPane.getChildren().add(new Circle(event.getX(), event.getY(), 10, Color.WHITE));
    	}
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
    
    @FXML
    void penSelected(ActionEvent event) {
    	paintable = true;
    }
    
    @FXML
    void eraserSelected(ActionEvent event) {
    	paintable = false;
    }
}

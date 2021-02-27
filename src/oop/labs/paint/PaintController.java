package oop.labs.paint;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import oop.labs.paint.factory.*;
import oop.labs.paint.shapes.ParentShape;

public class PaintController {

    @FXML
    private MenuBar menu;

    @FXML
    private HBox ControlPanel;

    @FXML
    private ColorPicker fullColorPicker;

    @FXML
    private ColorPicker outlineColorPicker;

    @FXML
    private ComboBox<?> thicknessOutlineBox;

    @FXML
    private Button lineButton;

    @FXML
    private Button rectButton;

    @FXML
    private Button ellipseButton;

    @FXML
    private Button polygonButton;

    @FXML
    private Button brocenLineButton1;

    @FXML
    private Label fullColorLabel;

    @FXML
    private Label outlineLabel;

    @FXML
    private Label thicknessLabel;

    @FXML
    private Canvas canvas;

    @FXML
    void OnClicked(MouseEvent event) {
        Button button = (Button)event.getSource();
        ParentShapeFactory parentShapeFactory = new LineFactory();
        switch (Integer.parseInt((button.getId()))){
            case 1:
                parentShapeFactory = new LineFactory();
                break;
            case 2:
                parentShapeFactory = new RectangleFactory();
                break;
            case 3:
                parentShapeFactory = new CircleFactory();
                break;
            case 4:
                parentShapeFactory = new PolygonFactory();
                break;
            case 5:
                parentShapeFactory = new PolylineFactory();
                break;
        }
        ParentShape shape = parentShapeFactory.createShape();
        shape.draw(canvas.getGraphicsContext2D());
    }

}



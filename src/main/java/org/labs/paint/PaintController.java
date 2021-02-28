package org.labs.paint;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import org.labs.paint.factory.*;
import org.labs.paint.shapes.ParentShape;

import java.util.Arrays;
import java.util.List;

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
    private Button brokenLineButton1;

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
        List<ParentShapeFactory> shapeFactoryList = Arrays.asList(new LineFactory(), new RectangleFactory(), new CircleFactory(), new PolygonFactory(), new PolylineFactory());
        ParentShapeFactory parentShapeFactory = shapeFactoryList.get(Integer.parseInt((button.getId()))-1);
        ParentShape shape = parentShapeFactory.createShape();
        shape.draw(canvas.getGraphicsContext2D());
    }

}

package org.labs.paint;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import org.labs.paint.factory.*;
import org.labs.paint.shapes.ParentShape;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class PaintController implements Initializable {

    GraphicsContext graphicsContext;
    List<ParentShapeFactory> shapeFactoryList = Arrays.asList(new LineFactory(), new RectangleFactory(), new CircleFactory(), new PolygonFactory(), new PolylineFactory());

    @FXML
    private MenuBar menu;

    @FXML
    private HBox ControlPanel;

    @FXML
    private ColorPicker fillColorPicker;

    @FXML
    private ColorPicker outlineColorPicker;

    @FXML
    private ComboBox<Integer> thicknessOutlineBox;

    @FXML
    private ComboBox<String> figureComboBox;

    @FXML
    private Label fullColorLabel;

    @FXML
    private Label outlineLabel;

    @FXML
    private Label thicknessLabel;

    @FXML
    private Label figureLabel;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> figureList = FXCollections.observableArrayList("Отрезок", "Прямоугольник", "Эллипс", "Многоугольник", "Ломаная");
        figureComboBox.getItems().setAll(figureList);
        figureComboBox.setValue("Отрезок");

        ObservableList<Integer> thicknessOutlineList = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);
        thicknessOutlineBox.getItems().setAll(thicknessOutlineList);
        thicknessOutlineBox.setValue(1);

        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(fillColorPicker.getValue());
        graphicsContext.setStroke(outlineColorPicker.getValue());
        graphicsContext.setLineWidth(thicknessOutlineBox.getSelectionModel().getSelectedItem());

    }

    public void onCanvasClicked(MouseEvent mouseEvent) {
        ParentShapeFactory parentShapeFactory = shapeFactoryList.get(figureComboBox.getSelectionModel().getSelectedIndex());
        ParentShape shape = parentShapeFactory.createShape(canvas.getGraphicsContext2D(),new Point2D(mouseEvent.getX(), mouseEvent.getY()));
        shape.draw(graphicsContext);
    }

    public void onFillColorChanged(ActionEvent actionEvent) {
        graphicsContext.setFill((Paint) fillColorPicker.getValue());
    }

    public void onOutlineColorChanged(ActionEvent actionEvent) {
        graphicsContext.setStroke((Paint)outlineColorPicker.getValue());
    }

    public void onOutlineBoxChanged(ActionEvent actionEvent) {
        graphicsContext.setLineWidth(thicknessOutlineBox.getSelectionModel().getSelectedItem());
    }
}

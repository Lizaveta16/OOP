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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import org.labs.paint.factory.*;
import org.labs.paint.shapes.ParentShape;
import org.labs.paint.shapes.Polygon;
import org.labs.paint.shapes.Polyline;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class PaintController implements Initializable {

    @FXML
    private MenuBar menu;

    @FXML
    private HBox controlPanel;

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
    private Canvas mainCanvas;

    @FXML
    private Canvas prevCanvas;

    private GraphicsContext mainGraphicsContext;
    private GraphicsContext previewGraphicsContext;
    private final List<ParentShapeFactory> shapeFactoryList = Arrays.asList(new LineFactory(), new RectangleFactory(), new CircleFactory(), new PolygonFactory(), new PolylineFactory());
    private final List<ParentShape> shapesList = new ArrayList<>();
    private ParentShape currShape;
    private boolean isDrawing = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> figureList = FXCollections.observableArrayList("Отрезок", "Прямоугольник", "Эллипс", "Многоугольник", "Ломаная");
        figureComboBox.getItems().setAll(figureList);
        figureComboBox.setValue("Отрезок");

        ObservableList<Integer> thicknessOutlineList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        thicknessOutlineBox.getItems().setAll(thicknessOutlineList);
        thicknessOutlineBox.setValue(1);

        mainGraphicsContext = mainCanvas.getGraphicsContext2D();
        mainGraphicsContext.setFill(fillColorPicker.getValue());
        mainGraphicsContext.setStroke(outlineColorPicker.getValue());
        mainGraphicsContext.setLineWidth(thicknessOutlineBox.getSelectionModel().getSelectedItem());

        previewGraphicsContext = prevCanvas.getGraphicsContext2D();
        prevCanvas.setVisible(false);

    }

    public void onCanvasClicked(MouseEvent mouseEvent) {
        if (!isDrawing){
            ParentShapeFactory parentShapeFactory = shapeFactoryList.get(figureComboBox.getSelectionModel().getSelectedIndex());
            currShape = parentShapeFactory.createShape(mainCanvas.getGraphicsContext2D(), new Point2D(mouseEvent.getX(), mouseEvent.getY()));
            isDrawing = true;
        } else{
            if (currShape.isMultipoint()) {
                currShape.addPoint(new Point2D(mouseEvent.getX(), mouseEvent.getY()));
                shapesList.add(currShape);
            } else {
                currShape.draw(mainGraphicsContext);
                prevCanvas.setVisible(false);
                shapesList.add(currShape);
                isDrawing = false;
            }
        }

    }

    public void onCanvasMouseMoved(MouseEvent mouseEvent) {
        if (isDrawing) {
            prevCanvas.setVisible(true);
            previewGraphicsContext.clearRect(0, 0, prevCanvas.getWidth(), prevCanvas.getHeight());
            currShape.update(new Point2D(mouseEvent.getX(), mouseEvent.getY()));
            currShape.draw(previewGraphicsContext);
        }
    }

    public void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER && currShape.isMultipoint()){
            currShape.delLastPoint();
            currShape.draw(mainGraphicsContext);
            prevCanvas.setVisible(false);
            isDrawing = false;
        }
    }

    public void onFillColorChanged(ActionEvent actionEvent) {
        mainGraphicsContext.setFill(fillColorPicker.getValue());
    }

    public void onOutlineColorChanged(ActionEvent actionEvent) {
        mainGraphicsContext.setStroke(outlineColorPicker.getValue());
    }

    public void onOutlineBoxChanged(ActionEvent actionEvent) {
        mainGraphicsContext.setLineWidth(thicknessOutlineBox.getSelectionModel().getSelectedItem());
    }

}

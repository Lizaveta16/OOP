package org.labs.paint;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.labs.paint.actions.DrawingHistory;
import org.labs.paint.actions.MyPoint2D;
import org.labs.paint.factory.*;
import org.labs.paint.shapes.ParentShape;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static org.labs.paint.actions.Serializer.*;

public class PaintController implements Initializable {

    @FXML
    private MenuBar menu;

    @FXML
    private ColorPicker fillColorPicker;

    @FXML
    private ColorPicker outlineColorPicker;

    @FXML
    private ComboBox<Integer> thicknessOutlineBox;

    @FXML
    private ComboBox<String> figureComboBox;

    @FXML
    private Canvas mainCanvas;

    @FXML
    private Canvas prevCanvas;

    private GraphicsContext mainGraphicsContext;
    private GraphicsContext previewGraphicsContext;
    private final List<ParentShapeFactory> shapeFactoryList = new ArrayList<>(Arrays.asList(new LineFactory(), new RectangleFactory(), new CircleFactory(), new PolygonFactory(), new PolylineFactory()));
    private ParentShape currShape;
    private boolean isDrawing = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> figureList = FXCollections.observableArrayList();
        List<ParentShapeFactory> factories = new PluginLoader().getAllFactories();

        for (ParentShapeFactory factory: factories) {
            shapeFactoryList.add(factory);
        }
        for (ParentShapeFactory factory: shapeFactoryList){
            figureList.add(factory.getName());
        }

        figureComboBox.getItems().setAll(figureList);
        figureComboBox.setValue(figureList.get(0));

        ObservableList<Integer> thicknessOutlineList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        thicknessOutlineBox.getItems().setAll(thicknessOutlineList);
        thicknessOutlineBox.setValue(1);

        mainGraphicsContext = mainCanvas.getGraphicsContext2D();
        updateGraphicsContext();

        previewGraphicsContext = prevCanvas.getGraphicsContext2D();
        prevCanvas.setVisible(false);
    }

    public void onCanvasClicked(MouseEvent mouseEvent) {
        if (!isDrawing) {
            ParentShapeFactory parentShapeFactory = shapeFactoryList.get(figureComboBox.getSelectionModel().getSelectedIndex());
            currShape = parentShapeFactory.createShape(mainCanvas.getGraphicsContext2D(), new MyPoint2D(mouseEvent.getX(), mouseEvent.getY()));
            isDrawing = true;
            DrawingHistory.addShape(currShape);
        } else {
            if (currShape.isMultipoint()) {
                currShape.addPoint(new MyPoint2D(mouseEvent.getX(), mouseEvent.getY()));
            } else {
                currShape.draw(mainGraphicsContext);
                prevCanvas.setVisible(false);
                isDrawing = false;
            }
        }

    }

    public void onCanvasMouseMoved(MouseEvent mouseEvent) {
        if (isDrawing) {
            prevCanvas.setVisible(true);
            previewGraphicsContext.clearRect(0, 0, prevCanvas.getWidth(), prevCanvas.getHeight());
            currShape.update(new MyPoint2D(mouseEvent.getX(), mouseEvent.getY()));
            currShape.draw(previewGraphicsContext);
        }
    }

    public void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER && currShape.isMultipoint()) {
            currShape.delLastPoint();
            currShape.draw(mainGraphicsContext);
            prevCanvas.setVisible(false);
            isDrawing = false;
        }
        if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.Z) {
            if (keyEvent.isShiftDown()) {
                DrawingHistory.redo(mainGraphicsContext);
            } else {
                DrawingHistory.undo(mainGraphicsContext, mainCanvas.getWidth(), mainCanvas.getHeight());
                updateGraphicsContext();
            }
        }
    }

    public void onFillColourChanged(ActionEvent actionEvent) {
        mainGraphicsContext.setFill(fillColorPicker.getValue());
    }

    public void onOutlineColourChanged(ActionEvent actionEvent) {
        mainGraphicsContext.setStroke(outlineColorPicker.getValue());
    }

    public void onOutlineBoxChanged(ActionEvent actionEvent) {
        mainGraphicsContext.setLineWidth(thicknessOutlineBox.getSelectionModel().getSelectedItem());
    }

    public void updateGraphicsContext() {
        mainGraphicsContext.setFill(fillColorPicker.getValue());
        mainGraphicsContext.setStroke(outlineColorPicker.getValue());
        mainGraphicsContext.setLineWidth(thicknessOutlineBox.getSelectionModel().getSelectedItem());
    }

    public void saveAsFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранить как...");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON", "*.json"));
        File file = fileChooser.showSaveDialog(Stage.getWindows().get(0));
        serialize(DrawingHistory.getShapesList(), file);
    }

    public void openFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открыть");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON", "*.json"));
        File file = fileChooser.showOpenDialog(Stage.getWindows().get(0));
        DrawingHistory.setShapesList(deserialize(file));
        mainGraphicsContext.clearRect(0, 0, prevCanvas.getWidth(), prevCanvas.getHeight());
        DrawingHistory.drawShapes(mainGraphicsContext);
        updateGraphicsContext();
    }
}

package org.labs.paint.actions;

import javafx.scene.canvas.GraphicsContext;
import org.labs.paint.shapes.ParentShape;

import java.util.ArrayList;

public class DrawingHistory {

    private static ArrayList<ParentShape> shapesList = new ArrayList<>();
    private static int drawnShapesCount = 0;
    private static int maxCount = 0;

    public static void addShape(ParentShape shape) {
        if (drawnShapesCount == maxCount) {
            shapesList.add(shape);
        } else {
            shapesList.set(drawnShapesCount, shape);
        }
        drawnShapesCount++;
        maxCount = drawnShapesCount;
    }

    public static void undo(GraphicsContext gc, double width, double height) {
        if (drawnShapesCount == 0) {
            return;
        }
        drawnShapesCount--;
        gc.clearRect(0, 0, width, height);
        for (int i = 0; i < drawnShapesCount; i++) {
            shapesList.get(i).draw(gc);
        }
    }

    public static void redo(GraphicsContext gc) {
        if (drawnShapesCount == maxCount) {
            return;
        }
        drawnShapesCount++;
        shapesList.get(drawnShapesCount - 1).draw(gc);

    }
}

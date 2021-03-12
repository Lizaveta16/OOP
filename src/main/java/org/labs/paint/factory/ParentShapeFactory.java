package org.labs.paint.factory;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import org.labs.paint.shapes.ParentShape;

public interface ParentShapeFactory {
    ParentShape createShape(GraphicsContext graphicsContext, Point2D firstPoint);
}

package org.labs.paint.factory;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import org.labs.paint.shapes.Line;

public class LineFactory implements ParentShapeFactory{
    @Override
    public Line createShape(GraphicsContext graphicsContext, Point2D firstPoint) {
        return new Line(graphicsContext, firstPoint);
    }
}

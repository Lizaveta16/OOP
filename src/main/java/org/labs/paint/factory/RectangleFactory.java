package org.labs.paint.factory;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import org.labs.paint.shapes.Rectangle;

public class RectangleFactory implements ParentShapeFactory{
    @Override
    public Rectangle createShape(GraphicsContext graphicsContext, Point2D firstPoint) {

        return new Rectangle(graphicsContext, firstPoint, 300,300);
    }
}

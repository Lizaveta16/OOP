package org.labs.paint.factory;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import org.labs.paint.shapes.Polygon;

public class PolygonFactory implements ParentShapeFactory {
    @Override
    public Polygon createShape(GraphicsContext graphicsContext, Point2D firstPoint) {
        return new Polygon(graphicsContext, firstPoint, firstPoint);
    }
}

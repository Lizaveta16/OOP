package org.labs.paint.factory;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import org.labs.paint.shapes.Polyline;

public class PolylineFactory implements ParentShapeFactory {
    @Override
    public Polyline createShape(GraphicsContext graphicsContext, Point2D firstPoint) {

        return new Polyline(graphicsContext, firstPoint, firstPoint);
    }
}

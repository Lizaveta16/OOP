package org.labs.paint.factory;

import javafx.scene.canvas.GraphicsContext;
import org.labs.paint.actions.MyPoint2D;
import org.labs.paint.shapes.Polygon;

public class PolygonFactory extends ParentShapeFactory {
    public PolygonFactory() {
    }
    @Override
    public Polygon createShape(GraphicsContext graphicsContext, MyPoint2D firstPoint) {
        return new Polygon(graphicsContext, firstPoint, firstPoint);
    }

    @Override
    public String getName() {
        return "Многоугольник";
    }
}

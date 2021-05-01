package org.labs.paint.factory;

import javafx.scene.canvas.GraphicsContext;
import org.labs.paint.actions.MyPoint2D;
import org.labs.paint.shapes.Polyline;

public class PolylineFactory implements ParentShapeFactory {
    @Override
    public Polyline createShape(GraphicsContext graphicsContext, MyPoint2D firstPoint) {

        return new Polyline(graphicsContext, firstPoint, firstPoint);
    }
}

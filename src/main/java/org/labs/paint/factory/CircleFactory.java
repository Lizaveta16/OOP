package org.labs.paint.factory;

import javafx.scene.canvas.GraphicsContext;
import org.labs.paint.actions.MyPoint2D;
import org.labs.paint.shapes.Circle;

public class CircleFactory implements ParentShapeFactory {
    @Override
    public Circle createShape(GraphicsContext graphicsContext, MyPoint2D firstPoint) {
        return new Circle(graphicsContext, firstPoint, 0, 0);
    }
}

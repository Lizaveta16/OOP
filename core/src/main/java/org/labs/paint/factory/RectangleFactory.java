package org.labs.paint.factory;

import javafx.scene.canvas.GraphicsContext;
import org.labs.paint.actions.MyPoint2D;
import org.labs.paint.shapes.Rectangle;

public class RectangleFactory extends ParentShapeFactory {

    public RectangleFactory() {
    }

    @Override
    public Rectangle createShape(GraphicsContext graphicsContext, MyPoint2D firstPoint) {

        return new Rectangle(graphicsContext, firstPoint, 0, 0);
    }

    @Override
    public String getName() {
        return "Прямоугольник";
    }
}

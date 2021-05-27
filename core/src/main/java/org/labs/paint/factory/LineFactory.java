package org.labs.paint.factory;

import javafx.scene.canvas.GraphicsContext;
import org.labs.paint.actions.MyPoint2D;
import org.labs.paint.shapes.Line;

public class LineFactory extends ParentShapeFactory{

    @Override
    public Line createShape(GraphicsContext graphicsContext, MyPoint2D firstPoint) {
        return new Line(graphicsContext, firstPoint);
    }

    @Override
    public String getName() {
        return "Отрезок";
    }
}

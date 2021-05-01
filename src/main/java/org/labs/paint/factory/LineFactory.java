package org.labs.paint.factory;

import javafx.scene.canvas.GraphicsContext;
import org.labs.paint.actions.MyPoint2D;
import org.labs.paint.shapes.Line;

public class LineFactory implements ParentShapeFactory{
    @Override
    public Line createShape(GraphicsContext graphicsContext, MyPoint2D firstPoint) {
        return new Line(graphicsContext, firstPoint);
    }
}

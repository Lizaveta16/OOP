package org.labs.paint.trapezoid;

import org.labs.paint.factory.ParentShapeFactory;
import org.labs.paint.actions.MyPoint2D;
import org.labs.paint.shapes.ParentShape;

import javafx.scene.canvas.GraphicsContext;

public class TrapezoidFactory extends ParentShapeFactory {

    @Override
    public ParentShape createShape(GraphicsContext graphicsContext, MyPoint2D startPoint) {
        return new Trapezoid(graphicsContext, startPoint, 0, 0);
    }

    @Override
    public String getName() {
        return "Трапеция";
    }

}

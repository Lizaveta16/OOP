package org.labs.paint.factory;

import javafx.scene.canvas.GraphicsContext;
import org.labs.paint.actions.MyPoint2D;
import org.labs.paint.shapes.ParentShape;

public interface ParentShapeFactory {
    ParentShape createShape(GraphicsContext graphicsContext, MyPoint2D firstPoint);
}

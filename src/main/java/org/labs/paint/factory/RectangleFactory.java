package org.labs.paint.factory;

import org.labs.paint.shapes.Rectangle;

public class RectangleFactory implements ParentShapeFactory{
    @Override
    public Rectangle createShape() {
        return new Rectangle();
    }
}

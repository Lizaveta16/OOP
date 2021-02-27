package oop.labs.paint.factory;

import oop.labs.paint.shapes.Rectangle;

public class RectangleFactory implements ParentShapeFactory{
    @Override
    public Rectangle createShape() {
        return new Rectangle();
    }
}

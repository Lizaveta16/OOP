package org.labs.paint.factory;

import org.labs.paint.shapes.Circle;

public class CircleFactory implements ParentShapeFactory{
    @Override
    public Circle createShape() {
        return new Circle();
    }
}

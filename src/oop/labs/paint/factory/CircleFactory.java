package oop.labs.paint.factory;

import oop.labs.paint.shapes.Circle;

public class CircleFactory implements ParentShapeFactory{
    @Override
    public Circle createShape() {
        return new Circle();
    }
}

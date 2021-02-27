package oop.labs.paint.factory;

import oop.labs.paint.shapes.Line;

public class LineFactory implements ParentShapeFactory{

    @Override
    public Line createShape() {
        return new Line();
    }
}

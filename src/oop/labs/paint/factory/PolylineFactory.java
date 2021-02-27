package oop.labs.paint.factory;

import oop.labs.paint.shapes.Polyline;

public class PolylineFactory implements ParentShapeFactory{
    @Override
    public Polyline createShape() {
        return new Polyline();
    }
}

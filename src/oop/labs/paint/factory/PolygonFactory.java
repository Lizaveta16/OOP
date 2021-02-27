package oop.labs.paint.factory;

import oop.labs.paint.shapes.Polygon;

public class PolygonFactory implements ParentShapeFactory{
    @Override
    public Polygon createShape() {
        return new Polygon();
    }
}

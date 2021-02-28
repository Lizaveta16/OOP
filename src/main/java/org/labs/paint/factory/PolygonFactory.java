package org.labs.paint.factory;

import org.labs.paint.shapes.Polygon;

public class PolygonFactory implements ParentShapeFactory{
    @Override
    public Polygon createShape() {
        return new Polygon();
    }
}

package org.labs.paint.factory;

import org.labs.paint.shapes.Polyline;

public class PolylineFactory implements ParentShapeFactory{
    @Override
    public Polyline createShape() {
        return new Polyline();
    }
}

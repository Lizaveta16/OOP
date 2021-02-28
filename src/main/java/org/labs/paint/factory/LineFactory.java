package org.labs.paint.factory;

import org.labs.paint.shapes.Line;

public class LineFactory implements ParentShapeFactory{
    @Override
    public Line createShape() {
        return new Line();
    }
}

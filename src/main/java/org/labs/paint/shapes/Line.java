package org.labs.paint.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Line extends ParentShape{

    private Point2D firstPoint;

    public Line(GraphicsContext graphicsContext, Point2D firstPoint) {

        super(graphicsContext);
        this.firstPoint = firstPoint;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        updateGraphics(graphicsContext);
        graphicsContext.strokeLine(firstPoint.getX(),firstPoint.getY(),350,180);
    }
}

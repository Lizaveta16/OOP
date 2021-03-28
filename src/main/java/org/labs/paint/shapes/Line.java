package org.labs.paint.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Line extends ParentShape{

    private Point2D firstPoint;
    private Point2D lastPoint ;

    public Line(GraphicsContext graphicsContext, Point2D firstPoint) {

        super(graphicsContext);
        this.firstPoint = firstPoint;
        this.lastPoint = firstPoint;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        updateGraphics(graphicsContext);
        graphicsContext.strokeLine(firstPoint.getX(),firstPoint.getY(),lastPoint.getX(),lastPoint.getY());
    }

    @Override
    public void update(Point2D newPoint) {
        this.lastPoint = newPoint;
    }
}

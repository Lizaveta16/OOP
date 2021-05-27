package org.labs.paint.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import org.labs.paint.actions.MyPoint2D;

public class Line extends ParentShape{

    private MyPoint2D firstPoint;
    private MyPoint2D lastPoint ;

    public Line(GraphicsContext graphicsContext, MyPoint2D firstPoint) {

        super(graphicsContext);
        this.firstPoint = firstPoint;
        this.lastPoint = firstPoint;
        multipoint = false;
    }

    public MyPoint2D getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(MyPoint2D firstPoint) {
        this.firstPoint = firstPoint;
    }

    public MyPoint2D getLastPoint() {
        return lastPoint;
    }

    public void setLastPoint(MyPoint2D lastPoint) {
        this.lastPoint = lastPoint;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        updateGraphics(graphicsContext);
        graphicsContext.strokeLine(firstPoint.getX(),firstPoint.getY(),lastPoint.getX(),lastPoint.getY());
    }

    @Override
    public void update(MyPoint2D newPoint) {
        this.lastPoint = newPoint;
    }
}

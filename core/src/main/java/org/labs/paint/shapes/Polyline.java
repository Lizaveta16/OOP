package org.labs.paint.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import org.labs.paint.actions.MyPoint2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polyline extends ParentShape {

    private List<MyPoint2D> points;

    public Polyline(GraphicsContext graphicsContext, MyPoint2D... points) {

        super(graphicsContext);
        this.points = new ArrayList<>();
        this.points.addAll(Arrays.asList(points));
        multipoint = true;
    }

    public List<MyPoint2D> getPoints() {
        return points;
    }

    public void setPoints(List<MyPoint2D> points) {
        this.points = points;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

        updateGraphics(graphicsContext);

        for (int i = 0; i < points.size() - 1; i++) {
            MyPoint2D firstPoint = points.get(i);
            MyPoint2D secondPoint = points.get(i + 1);
            graphicsContext.strokeLine(firstPoint.getX(), firstPoint.getY(), secondPoint.getX(), secondPoint.getY());
        }
    }


    @Override
    public void update(MyPoint2D newPoint) {
        points.set(points.size() - 1, newPoint);
    }

    @Override
    public void addPoint(MyPoint2D point) {
        points.add(point);
    }

    @Override
    public void delLastPoint() {
        points.remove(points.size()-1);
    }

}

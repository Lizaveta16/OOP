package org.labs.paint.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polyline extends ParentShape {

    private List<Point2D> points;

    public Polyline(GraphicsContext graphicsContext, Point2D... points) {

        super(graphicsContext);
        this.points = new ArrayList<>();
        this.points.addAll(Arrays.asList(points));
        multipoint = true;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

        updateGraphics(graphicsContext);

        for (int i = 0; i < points.size() - 1; i++) {
            Point2D firstPoint = points.get(i);
            Point2D secondPoint = points.get(i + 1);
            graphicsContext.strokeLine(firstPoint.getX(), firstPoint.getY(), secondPoint.getX(), secondPoint.getY());
        }
    }


    @Override
    public void update(Point2D newPoint) {
        points.set(points.size() - 1, newPoint);
    }

    @Override
    public void addPoint(Point2D point) {
        points.add(point);
    }

    @Override
    public void delLastPoint() {
        points.remove(points.size()-1);
    }

}

package org.labs.paint.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polygon extends ParentShape {

    private List<Point2D> points;

    public Polygon(GraphicsContext graphicsContext, Point2D... points) {
        super(graphicsContext);
        this.points = new ArrayList<>();
        this.points.addAll(Arrays.asList(points));
        multipoint = true;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

        updateGraphics(graphicsContext);

        double[] xPoints = new double[points.size()];
        double[] yPoints = new double[points.size()];

        for (int i = 0; i < points.size(); i++) {
            Point2D p = points.get(i);
            xPoints[i] = p.getX();
            yPoints[i] = p.getY();
        }

        graphicsContext.fillPolygon(xPoints, yPoints, points.size());
        graphicsContext.strokePolygon(xPoints, yPoints, points.size());
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

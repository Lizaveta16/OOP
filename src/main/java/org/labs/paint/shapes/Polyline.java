package org.labs.paint.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polyline extends ParentShape{

    private List<Point2D> points;

    public Polyline(GraphicsContext graphicsContext, Point2D... points) {

        super(graphicsContext);
        this.points = new ArrayList<>();
        this.points.addAll(Arrays.asList(points));
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

        updateGraphics(graphicsContext);

        double [] xPoints = new double[points.size()];
        double [] yPoints = new double[points.size()];

        for (int i = 0; i < points.size(); i++) {
            Point2D p = points.get(i);
            xPoints[i] = p.getX();
            yPoints[i] = p.getY();
        }

        graphicsContext.strokePolyline(xPoints,yPoints,points.size());
    }
}

package org.labs.paint.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Circle extends ParentShape{

    private double height;
    private double width;
    private Point2D leftUpperCorner;

    public Circle(GraphicsContext graphicsContext, Point2D leftUpperCorner, double height, double width) {

        super(graphicsContext);
        this.height = height;
        this.width = width;
        this.leftUpperCorner = leftUpperCorner;
        multipoint = false;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

        updateGraphics(graphicsContext);
        graphicsContext.fillOval(width > 0 ? leftUpperCorner.getX() : leftUpperCorner.getX() + width,
                height > 0 ? leftUpperCorner.getY() : leftUpperCorner.getY() + height,
                Math.abs(width), Math.abs(height));
        graphicsContext.strokeOval(width > 0 ? leftUpperCorner.getX() : leftUpperCorner.getX() + width,
                height > 0 ? leftUpperCorner.getY() : leftUpperCorner.getY() + height,
                Math.abs(width), Math.abs(height));
    }

    @Override
    public void update(Point2D newPoint) {
        height = newPoint.getY() - leftUpperCorner.getY();
        width = newPoint.getX() - leftUpperCorner.getX();
    }
}

package org.labs.paint.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import org.labs.paint.actions.MyPoint2D;

public class Rectangle extends ParentShape{

    private double height;
    private double width;
    private MyPoint2D leftUpperCorner;

    public Rectangle(GraphicsContext graphicsContext, MyPoint2D leftUpperCorner, double height, double width) {

        super(graphicsContext);
        this.height = height;
        this.width = width;
        this.leftUpperCorner = leftUpperCorner;
        multipoint = false;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public MyPoint2D getLeftUpperCorner() {
        return leftUpperCorner;
    }

    public void setLeftUpperCorner(MyPoint2D leftUpperCorner) {
        this.leftUpperCorner = leftUpperCorner;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

        updateGraphics(graphicsContext);
        graphicsContext.fillRect(width > 0 ? leftUpperCorner.getX() : leftUpperCorner.getX() + width,
                height > 0 ? leftUpperCorner.getY() : leftUpperCorner.getY() + height,
                Math.abs(width), Math.abs(height));
        graphicsContext.strokeRect(width > 0 ? leftUpperCorner.getX() : leftUpperCorner.getX() + width,
                height > 0 ? leftUpperCorner.getY() : leftUpperCorner.getY() + height,
                Math.abs(width), Math.abs(height));
    }

    @Override
    public void update(MyPoint2D newPoint) {
        height = newPoint.getY() - leftUpperCorner.getY();
        width = newPoint.getX() - leftUpperCorner.getX();
    }
}

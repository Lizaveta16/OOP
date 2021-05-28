package org.labs.paint.trapezoid;

import org.labs.paint.shapes.ParentShape;
import org.labs.paint.actions.MyPoint2D;
import javafx.scene.canvas.GraphicsContext;

public class Trapezoid extends ParentShape {

    private MyPoint2D leftUpperCorner;
    private double width;
    private double height;

    public Trapezoid(GraphicsContext graphicsContext, MyPoint2D leftUpperPoint, double width, double height) {
        super(graphicsContext);
        this.leftUpperCorner = leftUpperPoint;
        this.width = width;
        this.height = height;
        multipoint = false;
    }

    public Trapezoid() {
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        updateGraphics(graphicsContext);
        double x = leftUpperCorner.getX();
        double y = leftUpperCorner.getY();
        double[] xPoints = {x, x + width * 0.25, x + width * 0.75, x + width};
        double[] yPoints = {y, y + height, y + height, y};
        graphicsContext.fillPolygon(xPoints, yPoints, 4);
        graphicsContext.strokePolygon(xPoints, yPoints, 4);
    }

    @Override
    public void update(MyPoint2D newPoint) {
        width = newPoint.getX() - leftUpperCorner.getX();
        height = newPoint.getY() - leftUpperCorner.getY();
    }

    public MyPoint2D getLeftUpperCorner() {
        return leftUpperCorner;
    }

    public void setLeftUpperCorner(MyPoint2D leftUpperCorner) {
        this.leftUpperCorner = leftUpperCorner;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

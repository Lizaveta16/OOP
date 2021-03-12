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
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

        updateGraphics(graphicsContext);
        graphicsContext.fillOval(leftUpperCorner.getX(),leftUpperCorner.getY(),height,width);
        graphicsContext.strokeOval(leftUpperCorner.getX(),leftUpperCorner.getY(),height,width);
    }
}

package org.labs.paint.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends ParentShape{

    private double height;
    private double width;
    private Point2D leftUpperCorner;

    public Rectangle(GraphicsContext graphicsContext, Point2D leftUpperCorner, double height, double width) {

        super(graphicsContext);
        this.height = height;
        this.width = width;
        this.leftUpperCorner = leftUpperCorner;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

        updateGraphics(graphicsContext);
        graphicsContext.fillRect(leftUpperCorner.getX(),leftUpperCorner.getY(),height,width);
        graphicsContext.strokeRect(leftUpperCorner.getX(),leftUpperCorner.getY(),height,width);
    }
}

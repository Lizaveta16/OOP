package org.labs.paint.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public abstract class ParentShape {

    protected Paint strokeColor;
    protected Paint fillColor;
    protected double lineWidth;

    protected ParentShape(GraphicsContext graphicsContext) {
        strokeColor = graphicsContext.getStroke();
        fillColor = graphicsContext.getFill();
        lineWidth = graphicsContext.getLineWidth();
    }

    public abstract void draw(GraphicsContext graphicsContext);
    public abstract void update(Point2D newPoint);
    public void addPoint(Point2D point){};
    public void delLastPoint(){};

    protected void updateGraphics(GraphicsContext graphicsContext){
        graphicsContext.setStroke(strokeColor);
        graphicsContext.setFill(fillColor);
        graphicsContext.setLineWidth(lineWidth);
    }
}

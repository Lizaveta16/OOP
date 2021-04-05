package org.labs.paint.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public abstract class ParentShape {

    protected Paint strokeColour;
    protected Paint fillColour;
    protected double lineWidth;

    protected boolean multipoint;

    public boolean isMultipoint() {
        return multipoint;
    }

    protected ParentShape(GraphicsContext graphicsContext) {
        strokeColour = graphicsContext.getStroke();
        fillColour = graphicsContext.getFill();
        lineWidth = graphicsContext.getLineWidth();
    }

    public abstract void draw(GraphicsContext graphicsContext);
    public abstract void update(Point2D newPoint);
    public void addPoint(Point2D point){};
    public void delLastPoint(){};

    protected void updateGraphics(GraphicsContext graphicsContext){
        graphicsContext.setStroke(strokeColour);
        graphicsContext.setFill(fillColour);
        graphicsContext.setLineWidth(lineWidth);
    }
}

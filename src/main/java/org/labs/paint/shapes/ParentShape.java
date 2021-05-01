package org.labs.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.labs.paint.actions.MyPoint2D;

public abstract class ParentShape {

    protected Color strokeColour;
    protected Color fillColour;
    protected double lineWidth;

    protected boolean multipoint;

    public Color getStrokeColour() {
        return strokeColour;
    }

    public void setStrokeColour(Color strokeColour) {
        this.strokeColour = strokeColour;
    }

    public Color getFillColour() {
        return fillColour;
    }

    public void setFillColour(Color fillColour) {
        this.fillColour = fillColour;
    }

    public double getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(double lineWidth) {
        this.lineWidth = lineWidth;
    }

    public boolean isMultipoint() {
        return multipoint;
    }

    protected ParentShape(GraphicsContext graphicsContext) {
        strokeColour = (Color) graphicsContext.getStroke();
        fillColour = (Color) graphicsContext.getFill();
        lineWidth = graphicsContext.getLineWidth();
    }

    public abstract void draw(GraphicsContext graphicsContext);

    public abstract void update(MyPoint2D newPoint);

    public void addPoint(MyPoint2D point) {
    }

    public void delLastPoint() {
    }

    protected void updateGraphics(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(strokeColour);
        graphicsContext.setFill(fillColour);
        graphicsContext.setLineWidth(lineWidth);
    }

}

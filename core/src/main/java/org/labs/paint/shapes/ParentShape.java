package org.labs.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.labs.paint.actions.MyPoint2D;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public abstract class ParentShape {

    protected Color strokeColour;
    protected Color fillColour;
    protected double lineWidth;

    public static List<ParentShape> getServices(ModuleLayer layer) {
        return ServiceLoader
                .load(layer, ParentShape.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }

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

    public ParentShape() {}

    public ParentShape(GraphicsContext graphicsContext) {
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

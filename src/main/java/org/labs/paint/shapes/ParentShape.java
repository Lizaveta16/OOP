package org.labs.paint.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

import java.awt.*;

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

    protected void updateGraphics(GraphicsContext graphicsContext){
        graphicsContext.setStroke(strokeColor);
        graphicsContext.setFill(fillColor);
        graphicsContext.setLineWidth(lineWidth);
    }
}

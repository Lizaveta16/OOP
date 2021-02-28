package org.labs.paint.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Polyline extends ParentShape{
    @Override
    public void draw(GraphicsContext graphicsContext) {
        double [] xPoints = {200,300,300}, yPoints = {350,350,500};
        graphicsContext.strokePolyline(xPoints,yPoints,3);
    }
}

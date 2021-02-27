package oop.labs.paint.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Polygon extends ParentShape {
    @Override
    public void draw(GraphicsContext graphicsContext) {
        double [] xPoints = {200,350,500}, yPoints = {200,50,200};
        graphicsContext.strokePolygon(xPoints,yPoints,3);
    }
}

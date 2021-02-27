package oop.labs.paint.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Line extends ParentShape{
    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.strokeLine(350,100,350,180);
    }
}

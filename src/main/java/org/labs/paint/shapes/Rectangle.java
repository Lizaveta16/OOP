package org.labs.paint.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends ParentShape{
    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.strokeRect(200,200,300,300);
    }
}

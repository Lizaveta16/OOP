package org.labs.paint.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Circle extends ParentShape{
    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.strokeOval(310,100,80,80);
    }
}

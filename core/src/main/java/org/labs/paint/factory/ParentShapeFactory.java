package org.labs.paint.factory;

import javafx.scene.canvas.GraphicsContext;
import org.labs.paint.actions.MyPoint2D;
import org.labs.paint.shapes.ParentShape;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public abstract class ParentShapeFactory {

    public abstract ParentShape createShape(GraphicsContext graphicsContext, MyPoint2D firstPoint);

    public static List<ParentShapeFactory> getServices(ModuleLayer layer) {
        return ServiceLoader
                .load(layer, ParentShapeFactory.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }
    public abstract String  getName();
}

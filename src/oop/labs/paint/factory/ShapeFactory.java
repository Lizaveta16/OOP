package oop.labs.paint.factory;

import oop.labs.paint.shapes.*;

public class ShapeFactory {
    public ParentShape createShape(int buttonId){
        ParentShape shape = null;

        switch (buttonId){
                case 1:
                    shape = new Line();
                    break;
                case 2:
                    shape = new Rectangle();
                    break;
                case 3:
                    shape = new Circle();
                    break;
                case 4:
                    shape = new Polygon();
                    break;
                case 5:
                    shape = new Polyline();
                    break;
        }
        return shape;
    }
}


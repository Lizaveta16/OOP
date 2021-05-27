package org.labs.paint.actions;

import java.io.IOException;
import java.io.Serializable;

public class MyPoint2D implements Serializable {
    private double x;
    private double y;

    public MyPoint2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void writeObject(java.io.ObjectOutputStream out)
            throws IOException {
        out.writeDouble(x);
        out.writeDouble(y);
    }

    public void readObject(java.io.ObjectInputStream in) throws IOException {
        this.x = in.readDouble();
        this.y = in.readDouble();
    }
}

import org.labs.paint.shapes.ParentShape;
import org.labs.paint.factory.ParentShapeFactory;

module TrapezoidModule {

    requires core;
    requires javafx.graphics;
    requires javafx.controls;
    requires com.google.gson;

    opens org.labs.paint.trapezoid;

    exports org.labs.paint.trapezoid;

    provides ParentShapeFactory with org.labs.paint.trapezoid.TrapezoidFactory;
    provides ParentShape with org.labs.paint.trapezoid.Trapezoid;

}
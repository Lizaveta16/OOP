import org.labs.paint.factory.ParentShapeFactory;
import org.labs.paint.shapes.ParentShape;

module core {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires com.google.gson;

    uses ParentShape;
    uses ParentShapeFactory;

    opens org.labs.paint.actions;
    opens org.labs.paint.shapes;
    opens org.labs.paint;

    exports org.labs.paint.actions;
    exports org.labs.paint;
    exports org.labs.paint.shapes;
    exports org.labs.paint.factory;
}
module OOP {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires com.google.gson;

    opens org.labs.paint.actions;
    opens org.labs.paint.shapes;
    opens org.labs.paint;

    exports org.labs.paint.actions;
    exports org.labs.paint;
}
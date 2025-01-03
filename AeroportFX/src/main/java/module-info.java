module org.example.aeroportfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.media;
    requires java.desktop;
    opens org.example.aeroportfx.controller to javafx.fxml;
    exports org.example.aeroportfx;

}
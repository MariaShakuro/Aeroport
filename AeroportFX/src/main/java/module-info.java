module org.example.aeroportfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.aeroportfx to javafx.fxml;
    exports org.example.aeroportfx;
}
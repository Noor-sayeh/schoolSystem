module com.example.school_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires ojdbc6;
    requires java.sql;


    opens com.example.school_system to javafx.fxml;
    exports com.example.school_system;
}
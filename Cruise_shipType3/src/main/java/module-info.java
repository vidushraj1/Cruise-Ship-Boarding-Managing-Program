module com.example.cruise_shiptask3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cruise_shiptask3 to javafx.fxml;
    exports com.example.cruise_shiptask3;
}
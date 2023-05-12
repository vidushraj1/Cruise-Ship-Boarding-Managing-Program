module com.example.cruise_shiptask2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cruise_shiptask2 to javafx.fxml;
    exports com.example.cruise_shiptask2;
}
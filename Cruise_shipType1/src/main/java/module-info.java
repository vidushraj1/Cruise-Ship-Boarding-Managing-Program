module com.example.cruise_shiptask1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cruise_shiptask1 to javafx.fxml;
    exports com.example.cruise_shiptask1;
}
module com.example.musicrecommendation {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.musicrecommendation to javafx.fxml;
    exports com.example.musicrecommendation;
}
module com.example.musicrecommendation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.musicrecommendation to javafx.fxml;
    exports com.example.musicrecommendation;
}
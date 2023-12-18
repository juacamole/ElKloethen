module com.example.cd_testdinimueter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cd_testdinimueter to javafx.fxml;
    exports com.example.cd_testdinimueter;
}
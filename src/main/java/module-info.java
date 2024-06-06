module com.uaspbo.uas_pbo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uaspbo.uas_pbo to javafx.fxml;
    exports com.uaspbo.uas_pbo;
}
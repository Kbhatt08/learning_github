module com.mycompany.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    opens com.mycompany.calculator to javafx.fxml;
    exports com.mycompany.calculator;
}

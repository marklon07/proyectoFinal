module co.edu.uniquindio.poo.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;

    exports co.edu.uniquindio.poo.proyectofinal.test to junit;


    opens co.edu.uniquindio.poo.proyectofinal.viewController to javafx.fxml;
    opens co.edu.uniquindio.poo.proyectofinal to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectofinal;

}
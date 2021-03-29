package sample.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import sample.Main;

import java.io.IOException;

public class Login {
    @FXML
    AnchorPane anchorPane;
    @FXML
    StackPane stackPane;

    public void CambiarPantalla(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../principal/principal.fxml"));
        Scene scene=new Scene(root);
        Main.stage.setScene(scene);

    }
}

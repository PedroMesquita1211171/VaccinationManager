package app.ui.gui;

import app.ui.Main;
import app.ui.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

public class DevelopersUI implements Initializable {

    private MainGUI main;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setMainApp(MainGUI mainApp){
        this.main = mainApp;
    }

    @FXML
    public void whenExitClicked(ActionEvent actionEvent) {
        LoginUI loginUI = (LoginUI) this.main.changeStageContent("/fxml/LoginScreen.fxml");
        loginUI.setMainApp(this.main);
    }
}

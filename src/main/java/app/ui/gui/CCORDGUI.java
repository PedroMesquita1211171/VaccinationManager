package app.ui.gui;

import app.controller.App;
import app.ui.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class CCORDGUI implements Initializable {

    private MainGUI main;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void setMainApp(MainGUI mainApp) {
        this.main = mainApp;
    }

    @javafx.fxml.FXML
    public void whenExitClicked(ActionEvent actionEvent) {
        App.getInstance().doLogout();
        LoginUI loginUI = (LoginUI) this.main.changeStageContent("/fxml/LoginScreen.fxml");
        loginUI.setMainApp(this.main);
    }
}

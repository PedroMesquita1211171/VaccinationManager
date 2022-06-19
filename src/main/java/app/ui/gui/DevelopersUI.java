package app.ui.gui;

import app.ui.Main;
import app.ui.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Developers ui.
 */
public class DevelopersUI implements Initializable {

    private MainGUI main;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * Set main app.
     *
     * @param mainApp the main app
     */
    public void setMainApp(MainGUI mainApp){
        this.main = mainApp;
    }

    /**
     * When exit clicked.
     *
     * @param actionEvent the action event
     */
    @FXML
    public void whenExitClicked(ActionEvent actionEvent) {
        LoginUI loginUI = (LoginUI) this.main.changeStageContent("/fxml/LoginScreen.fxml");
        loginUI.setMainApp(this.main);
    }
}

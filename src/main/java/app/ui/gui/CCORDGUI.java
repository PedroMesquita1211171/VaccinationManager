package app.ui.gui;

import app.controller.App;
import app.ui.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Ccordgui.
 */
public class CCORDGUI implements Initializable {

    private MainGUI main;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    /**
     * Sets main app.
     *
     * @param mainApp the main app
     */
    public void setMainApp(MainGUI mainApp) {
        this.main = mainApp;
    }

    /**
     * When exit clicked.
     *
     * @param actionEvent the action event
     */
    @javafx.fxml.FXML
    public void whenExitClicked(ActionEvent actionEvent) {
        App.getInstance().doLogout();
        LoginUI loginUI = (LoginUI) this.main.changeStageContent("/fxml/LoginScreen.fxml");
        loginUI.setMainApp(this.main);
    }
}

package app.ui.gui;

import app.controller.App;
import app.ui.MainGUI;
import app.ui.console.SNSUserScheduleUI;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Snsugui.
 */
public class SNSUGUI implements Initializable {


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
     * When schedule clicked.
     *
     * @param actionEvent the action event
     */
    @javafx.fxml.FXML
    public void whenScheduleClicked(ActionEvent actionEvent) {
        new SNSUserScheduleUI().run();
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

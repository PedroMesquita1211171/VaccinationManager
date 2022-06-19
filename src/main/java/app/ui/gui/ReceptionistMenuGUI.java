package app.ui.gui;

import app.controller.App;
import app.ui.MainGUI;
import app.ui.console.ListEmployeesUI;
import app.ui.console.RecepcionistScheduleUI;
import app.ui.console.RegisterArrivalUI;
import app.ui.console.RegisterSNSUserUI;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Receptionist menu gui.
 */
public class ReceptionistMenuGUI implements Initializable {


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

    /**
     * Schedule clicked.
     *
     * @param actionEvent the action event
     */
    @javafx.fxml.FXML
    public void scheduleClicked(ActionEvent actionEvent) {
        new RecepcionistScheduleUI().run();
    }

    /**
     * Registersnsu clicked.
     *
     * @param actionEvent the action event
     */
    @javafx.fxml.FXML
    public void registersnsuClicked(ActionEvent actionEvent) {
        new RegisterSNSUserUI().run();
    }

    /**
     * Listemp clicked.
     *
     * @param actionEvent the action event
     */
    @javafx.fxml.FXML
    public void listempClicked(ActionEvent actionEvent) {
        new ListEmployeesUI().run();
    }

    /**
     * Register arrival clicked.
     *
     * @param actionEvent the action event
     */
    @javafx.fxml.FXML
    public void registerArrivalClicked(ActionEvent actionEvent) {
        new RegisterArrivalUI().run();
    }
}

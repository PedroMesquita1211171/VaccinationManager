package app.ui.gui;

import app.controller.App;
import app.ui.MainGUI;
import app.ui.console.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Admin menu gui.
 */
public class AdminMenuGUI implements Initializable {

    private MainGUI main;

    /**
     * Sets main app.
     *
     * @param mainApp the main app
     */
    public void setMainApp(MainGUI mainApp) {
        this.main = mainApp;
    }

    /**
     * Register employee clicked.
     *
     * @param actionEvent the action event
     */
    @javafx.fxml.FXML
    public void registerEmployeeClicked(ActionEvent actionEvent) {
        new RegisterEmployeeUI().run();
    }

    /**
     * New vaccine type clicked.
     *
     * @param actionEvent the action event
     */
    @javafx.fxml.FXML
    public void newVaccineTypeClicked(ActionEvent actionEvent) {
        new SpecifyNewVaccineTypeUI().run();
    }

    /**
     * Loadusers clicked.
     *
     * @param actionEvent the action event
     */
    @javafx.fxml.FXML
    public void loadusersClicked(ActionEvent actionEvent) {
        new LoadSNSUsersFromFileUI().run();
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
     * Newvaccine clicked.
     *
     * @param actionEvent the action event
     */
    @javafx.fxml.FXML
    public void newvaccineClicked(ActionEvent actionEvent) {
        new SpecifyNewVaccineUI().run();
    }

    /**
     * Newvaccenter clicked.
     *
     * @param actionEvent the action event
     */
    @javafx.fxml.FXML
    public void newvaccenterClicked(ActionEvent actionEvent) {
        new RegisterVaccinationCenterUI().run();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

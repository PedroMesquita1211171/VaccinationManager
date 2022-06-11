package app.ui.gui;

import app.controller.App;
import app.ui.MainGUI;
import app.ui.console.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuGUI implements Initializable {

    private MainGUI main;

    public void setMainApp(MainGUI mainApp) {
        this.main = mainApp;
    }

    @javafx.fxml.FXML
    public void registerEmployeeClicked(ActionEvent actionEvent) {
        new RegisterEmployeeUI().run();
    }

    @javafx.fxml.FXML
    public void newVaccineTypeClicked(ActionEvent actionEvent) {
        new SpecifyNewVaccineTypeUI().run();
    }

    @javafx.fxml.FXML
    public void loadusersClicked(ActionEvent actionEvent) {
        new LoadSNSUsersFromFileUI().run();
    }

    @javafx.fxml.FXML
    public void listempClicked(ActionEvent actionEvent) {
        new ListEmployeesUI().run();
    }

    @javafx.fxml.FXML
    public void newvaccineClicked(ActionEvent actionEvent) {
        new SpecifyNewVaccineUI().run();
    }

    @javafx.fxml.FXML
    public void newvaccenterClicked(ActionEvent actionEvent) {
        new RegisterVaccinationCenterUI().run();
    }

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

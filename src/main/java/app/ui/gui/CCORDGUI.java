package app.ui.gui;

import app.controller.App;
import app.ui.MainGUI;
import app.ui.console.*;
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

    /**
     * When us 18 clicked.
     *
     * @param actionEvent the action event
     */
    @javafx.fxml.FXML
    public void whenUS18clicked(ActionEvent actionEvent) {
        new ListVaccinesUI().run();
    }

    /**
     * When us 16 clicked.
     *
     * @param actionEvent the action event
     */
    @javafx.fxml.FXML
    public void whenUS16clicked(ActionEvent actionEvent) {
        new AnalyzeCenterUI().run();
    }

    public void whenUS17clicked(ActionEvent actionEvent) {
        new ShowDataUI().run();
    }

    public void importDataClicked(ActionEvent actionEvent) {
        new LoadCenterDataUI().run();
    }
}

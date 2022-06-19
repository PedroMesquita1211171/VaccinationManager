package app.ui.gui;

import app.controller.App;
import app.ui.MainGUI;
import app.ui.console.ListSNSUsersInWaitingRoomUI;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Nurse gui.
 */
public class NurseGUI implements Initializable {


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
     * Listsnsuwr clicked.
     *
     * @param actionEvent the action event
     */
    @javafx.fxml.FXML
    public void listsnsuwrClicked(ActionEvent actionEvent) {
        new ListSNSUsersInWaitingRoomUI().run();
    }

    /**
     * When record adverse reaction clicked.
     *
     * @param actionEvent the action event
     */
    @javafx.fxml.FXML
    public void whenRecordAdverseReactionClicked(ActionEvent actionEvent) {
        RecordAdverseReactionUI recordAdverseReactionUI = (RecordAdverseReactionUI) this.main.changeStageContent("/fxml/RecordAdverseReaction.fxml");
        recordAdverseReactionUI.setMainApp(this.main);
    }

    /**
     * Gets main.
     *
     * @return the main
     */
    public MainGUI getMain() {
        return main;
    }

    /**
     * When record vaccination clicked.
     *
     * @param actionEvent the action event
     */
    @javafx.fxml.FXML
    public void whenRecordVaccinationClicked(ActionEvent actionEvent) {
        RecordVaccinationUI recordVaccinationUI = (RecordVaccinationUI) this.main.changeStageContent("/fxml/RecordVaccination.fxml");
        recordVaccinationUI.setMainApp(this.main);
    }
}

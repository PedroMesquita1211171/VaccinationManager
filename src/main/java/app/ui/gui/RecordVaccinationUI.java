package app.ui.gui;

import app.DTO.VaccineDTO;
import app.controller.RecordVaccinationController;
import app.ui.MainGUI;
import app.ui.gui.Utils.ListsToStringList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class RecordVaccinationUI implements Initializable {

    private MainGUI main;


    @javafx.fxml.FXML
    private ComboBox vaccineComboBox;
    @javafx.fxml.FXML
    private TextField SNSNumberTxtField;
    @javafx.fxml.FXML
    private TextField doseNumberTXTField;


    private List<VaccineDTO> vaccines;

    private RecordVaccinationController ctrl;


    public RecordVaccinationUI() {
        this.ctrl = new RecordVaccinationController();
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
          vaccines = ctrl.getVaccines();
        List<String> vaccinestrings = ListsToStringList.vaccineDTOListToStringList(vaccines);
        vaccineComboBox.getItems().addAll(vaccinestrings);

    }

    public void setMainApp(MainGUI main) {
        this.main = main;
    }

    @javafx.fxml.FXML
    public void whenExitClicked(ActionEvent actionEvent) {
        NurseGUI nurseGUI = (NurseGUI) this.main.changeStageContent("/fxml/NurseMenu.fxml");
        nurseGUI.setMainApp(this.main);
    }

    @javafx.fxml.FXML
    public void cleareverything(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void whenOKclicked(ActionEvent actionEvent) {

        try{


            //gets the required data from the GUI
            String SNSNumber = SNSNumberTxtField.getText();
            int vaccineIndex = vaccineComboBox.getSelectionModel().getSelectedIndex();
            String doseNumber = doseNumberTXTField.getText();

            int DoseNumber;
            //checks if inputs are Numbers
            try {
                DoseNumber =  Integer.parseInt(doseNumber);
                checkdoses(DoseNumber);
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("Dose number must be an integer! Try again!");
            }

            try{
                Long.parseLong(SNSNumber);
            }catch(NumberFormatException e){
                throw new IllegalArgumentException("SNS Number must be a number! Try again!");
            }

            VaccineDTO vaccine = vaccines.get(vaccineIndex);

            //creating and saving process
            if(ctrl.createVaccination(SNSNumber, vaccine, DoseNumber)){
                Alert Confirmation = new Alert(Alert.AlertType.CONFIRMATION);
                Confirmation.setTitle("Save Vaccination?");
                Confirmation.setHeaderText("Is the proceding information correct?");
                Confirmation.setContentText(ctrl.getVaccination().toString());
                Confirmation.showAndWait();
                if (Confirmation.getResult() == ButtonType.OK) {
                    if(ctrl.saveVaccination()){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Vaccination Saved");
                        alert.setHeaderText("Vaccination Saved");
                        alert.setContentText("Vaccination was saved successfully!");
                        alert.showAndWait();
                    }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Vaccination not saved");
                        alert.setHeaderText("Vaccination not saved");
                        alert.setContentText("Vaccination form was already filled out for this SNS Number!");
                        alert.showAndWait();
                    }
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Vaccination not saved");
                    alert.setHeaderText("Vaccination not saved");
                    alert.setContentText("Vaccination was not saved!");
                    alert.showAndWait();
                }

            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Vaccination not saved");
                alert.setHeaderText("Vaccination not saved");
                alert.setContentText("Vaccination form was already filled out for this SNS Number!");
                alert.showAndWait();
            }


        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill in all fields");
            alert.showAndWait();
        }




    }



    public void checkdoses(int doseNumber){
        if(doseNumber<1) throw new IllegalArgumentException("Dose number must be greater than 0!");
    }
}

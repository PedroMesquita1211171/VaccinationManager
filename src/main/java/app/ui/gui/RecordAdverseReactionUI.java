package app.ui.gui;

import app.controller.RecordAdverseReactionController;
import app.ui.MainGUI;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class RecordAdverseReactionUI implements Initializable {

    private MainGUI main;
    private RecordAdverseReactionController ctrl;
    @javafx.fxml.FXML
    private TextArea advReactTxtArea;
    @javafx.fxml.FXML
    private TextField SNSNumberTtField;
    @javafx.fxml.FXML
    private Label ErrorLabel;

    public RecordAdverseReactionUI() {
        this.ctrl = new RecordAdverseReactionController();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       ErrorLabel.setText("");
    }

    public void setMainApp(MainGUI main) {
        this.main = main;
    }

    @javafx.fxml.FXML
    public void whenExitClicked(ActionEvent actionEvent) {
        //return to the Nurse GUI
        NurseGUI nurseGUI = (NurseGUI) this.main.changeStageContent("/fxml/NurseMenu.fxml");
        nurseGUI.setMainApp(this.main);
    }

    @javafx.fxml.FXML
    public void cleareverything(ActionEvent actionEvent) {
        ErrorLabel.setText("");
    }

    @javafx.fxml.FXML
    public void cleareverything2(Event event) {
        ErrorLabel.setText("");
    }

    @javafx.fxml.FXML
    public void whenOKclicked(ActionEvent actionEvent) {
        try{

            String SNSNumber;
            try{
                SNSNumber = SNSNumberTtField.getText();
                Long.parseLong(SNSNumber);
            }catch(NumberFormatException e){
                throw new IllegalArgumentException("SNS Number must be a number! Try again!");
            }
            String advReact = advReactTxtArea.getText();
            if(ctrl.createAdverseReaction(SNSNumber, advReact)) {
                //Confirmation Alert Box asking if the user wants to save this adverse reaction
                Alert Confirmation = new Alert(Alert.AlertType.CONFIRMATION);
                Confirmation.setTitle("Save Adverse Reaction?");
                Confirmation.setHeaderText("Save Adverse Reaction?");
                Confirmation.setContentText(ctrl.getAdverseReaction().toString());
                Confirmation.showAndWait();
                if (Confirmation.getResult() == ButtonType.OK) {
                    if(ctrl.saveAdverseReaction()){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Success");
                        alert.setHeaderText("Success");
                        alert.setContentText("Adverse Reaction saved successfully!");
                        alert.showAndWait();
                    }else{
                        Alert notSaved = new Alert(Alert.AlertType.INFORMATION);
                        notSaved.setTitle("Adverse Reaction Not Saved");
                        notSaved.setHeaderText("Adverse Reaction Not Saved");
                        notSaved.setContentText("Adverse Reaction Not Saved");
                        notSaved.showAndWait();
                    }

                }else{
                    Alert notSaved = new Alert(Alert.AlertType.INFORMATION);
                    notSaved.setTitle("Adverse Reaction Not Saved");
                    notSaved.setHeaderText("Adverse Reaction Not Saved");
                    notSaved.setContentText("Adverse Reaction Not Saved");
                    notSaved.showAndWait();
                }
            } else {
                //AlertBox saying that the Adverse Reaction was already recorded
                Alert alreadyRecorded = new Alert(Alert.AlertType.INFORMATION);
                alreadyRecorded.setTitle("Adverse Reaction Already Recorded");
                alreadyRecorded.setHeaderText("Adverse Reaction Already Recorded");
                alreadyRecorded.setContentText("Adverse Reaction Already Recorded");
                alreadyRecorded.showAndWait();
            }

        }catch(IllegalArgumentException e){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("Error");
            error.setContentText(e.getMessage());
            error.getDialogPane().setStyle("-fx-text-fill: red;");
            error.showAndWait();
        }




    }
}

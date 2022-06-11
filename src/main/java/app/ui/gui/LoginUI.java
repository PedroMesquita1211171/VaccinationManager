package app.ui.gui;

import app.controller.AuthController;
import app.domain.shared.Constants;
import app.ui.Main;
import app.ui.MainGUI;
import app.ui.gui.Utils.SharedMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginUI implements Initializable {

    private MainGUI mainApp;
    private AuthController authController;
    private Stage stage;

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button developersButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        authController = new AuthController();
    }

    public void setMainApp(MainGUI mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void showDevelopersScreen(ActionEvent actionEvent) {
        DevelopersUI developersUI = (DevelopersUI) this.mainApp.changeStageContent("/fxml/AboutDevelopersScreen.fxml");
        developersUI.setMainApp(mainApp);
    }

    @FXML
    private void doLogin(ActionEvent actionEvent) {
        String email = emailField.getText();
        String password = passwordField.getText();
        boolean success;
        if (!email.isBlank() && !password.isBlank()) {
            success = authController.doLogin(email, password);

            if (!success) {
                SharedMethods.infoAlert("Invalid UserId and/or Password.", "Login Error");
            } else {
                List<UserRoleDTO> roles = this.authController.getUserRoles();
                if ((roles == null) || (roles.isEmpty())) {
                    SharedMethods.infoAlert("Login Error", "User has no valid roles.");
                } else {
                    UserRoleDTO role = roles.get(0);
                    getUiForRole(role);
                }
            }
        } else {
            SharedMethods.infoAlert("Email/Password fields can't be empty", "Login Error");
        }
    }

    private void getUiForRole(UserRoleDTO role) {
        switch (role.getDescription()) {
            case Constants.ROLE_ADMIN:
                AdminMenuGUI adminMenuGUI = (AdminMenuGUI) this.mainApp.changeStageContent("/fxml/AdminMenu.fxml");
                adminMenuGUI.setMainApp(mainApp);
                break;

            case Constants.ROLE_RECEPTIONIST:
                ReceptionistMenuGUI receptionistMenuGUI = (ReceptionistMenuGUI) this.mainApp.changeStageContent("/fxml/ReceptionistMenu.fxml");
                receptionistMenuGUI.setMainApp(mainApp);
                break;

            case Constants.ROLE_NURSE:
                NurseGUI nurseGUI = (NurseGUI) this.mainApp.changeStageContent("/fxml/NurseMenu.fxml");
                nurseGUI.setMainApp(mainApp);
                break;

            case Constants.ROLE_CENTER_COORDINATOR:
                CCORDGUI cCordGUI = (CCORDGUI) this.mainApp.changeStageContent("/fxml/CenterCoordinatorMenu.fxml");
                cCordGUI.setMainApp(mainApp);
                break;

            case Constants.ROLE_SNSUSER:
                SNSUGUI specialistDoctorMenuUI = (SNSUGUI) this.mainApp.changeStageContent("/fxml/SNSUserMenu.fxml");
                specialistDoctorMenuUI.setMainApp(mainApp);
                break;

            default:
                SharedMethods.errorAlert(new Exception("Invalid Role For Login!\n"),"There is no valid Role for this type of User!");
                break;
        }
    }
}

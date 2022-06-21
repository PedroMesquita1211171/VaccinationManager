package app.ui;

import app.ui.gui.LoginUI;
import app.ui.gui.Utils.Scheduler;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Timer;
import java.util.TimerTask;

import java.io.IOException;

/**
 * The type Main gui.
 */
public class MainGUI extends Application{

    private Stage stage;
    private final String COMP_DESIGNATION = "DGS/SNS Portugal";


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try{
            new Scheduler();
            launch(args);
        }catch (Exception e){
            System.out.println("\nError while initializing Application.\nTry again.\n");
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoadingScreen.fxml"));
            Parent root = loader.load();
            String css = this.getClass().getResource("/styles/Styles.css").toExternalForm();
            root.getStylesheets().add(css);

            Scene scene = new Scene(root);

            this.stage.setTitle(COMP_DESIGNATION);
            this.stage.setScene(scene);

            stage.setOnCloseRequest(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                alert.setTitle(COMP_DESIGNATION);
                alert.setHeaderText("Action Confirmation");
                alert.setContentText("Sure you want to exit?");

                ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Yes");
                ((Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("No");

                if (alert.showAndWait().get() == ButtonType.CANCEL) {
                    event.consume();
                }
            });
            this.stage.show();

            PauseTransition delay = new PauseTransition(Duration.seconds(3));
            delay.setOnFinished(event -> {
                try {
                    LoginUI loginUI = (LoginUI) changeStageContent("/fxml/LoginScreen.fxml");
                    loginUI.setMainApp(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            delay.play();
        } catch (IOException e) {
            errorAlert(e).show();
        }
    }


    /**
     * Change stage content initializable.
     *
     * @param fxml the fxml
     * @return the initializable
     */
    public Initializable changeStageContent(String fxml)  {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            this.stage.setScene(scene);
            return loader.getController();
        } catch (IOException e) {
            errorAlert(e).show();
            System.out.println(e.toString());
            return null;
        }
    }

    /**
     * Error alert alert.
     *
     * @param e the e
     * @return the alert
     */
    public Alert errorAlert(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(COMP_DESIGNATION);
        alert.setHeaderText("App launch error.");
        alert.setContentText(e.getMessage());

        return alert;
    }
}

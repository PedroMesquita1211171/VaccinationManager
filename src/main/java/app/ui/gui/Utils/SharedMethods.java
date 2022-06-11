package app.ui.gui.Utils;

import javafx.scene.control.Alert;

public class SharedMethods {

    public static void errorAlert(Exception e, String headerText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("DGS/SNS Portugal");
        alert.setHeaderText(headerText);
        alert.setContentText(e.getLocalizedMessage());

        alert.show();
    }

    public static void infoAlert(String message, String headerText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("DGS/SNS Portugal");
        alert.setHeaderText(headerText);
        alert.setContentText(message);

        alert.show();
    }

    public static void notificationAlert(String message, String headerText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("DGS/SNS Portugal");
        alert.setHeaderText(headerText);
        alert.setContentText(message);

        alert.show();
    }


}

package app.ui.gui.Utils;

import javafx.scene.control.Alert;

/**
 * The type Shared methods.
 */
public class SharedMethods {

    /**
     * Error alert.
     *
     * @param e          the e
     * @param headerText the header text
     */
    public static void errorAlert(Exception e, String headerText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("DGS/SNS Portugal");
        alert.setHeaderText(headerText);
        alert.setContentText(e.getLocalizedMessage());

        alert.show();
    }

    /**
     * Info alert.
     *
     * @param message    the message
     * @param headerText the header text
     */
    public static void infoAlert(String message, String headerText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("DGS/SNS Portugal");
        alert.setHeaderText(headerText);
        alert.setContentText(message);

        alert.show();
    }

    /**
     * Notification alert.
     *
     * @param message    the message
     * @param headerText the header text
     */
    public static void notificationAlert(String message, String headerText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("DGS/SNS Portugal");
        alert.setHeaderText(headerText);
        alert.setContentText(message);

        alert.show();
    }


}

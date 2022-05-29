package app.ui.console;
import app.controller.ArrivalListController;
import app.domain.model.SNSUser;
import app.ui.console.utils.Utils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * The type Arrival list ui.
 */
public class ArrivalListUI implements Runnable {

    private final ArrivalListController controller;

    /**
     * Instantiates a new Arrival list ui.
     */
    public ArrivalListUI() {
        controller = new ArrivalListController();
    }

    public void run() {
        String centerName = getCenterName();
        if (centerName != null) {
            DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar today = Calendar.getInstance();
            String stringToday = dateformat.format(today.getTime());
            System.out.println("Users Waiting in the Waiting Room: " + stringToday);
            System.out.println("Center: " + centerName);
            peopleWaitingForThePresentDay(centerName);
        }
    }

    /**
     * People waiting for the present day.
     *
     * @param centerName the center name
     */
    public void peopleWaitingForThePresentDay(String centerName) {
        DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat hourformat = new SimpleDateFormat("HH:mm:ss");
        Calendar today = Calendar.getInstance();
        String stringToday = dateformat.format(today.getTime());

        int numeroPessoas = 1;
        for (int i = 0; i < controller.arrival().size(); i++) {
            String dayAux = dateformat.format(controller.arrival().get(i).getArrivalDate());
            String centerNameAux = controller.arrival().get(i).getCenterName();
            if (dayAux.equals(stringToday)) {
                if (centerNameAux.equals(centerName)) {
                    String hourSchedule = hourformat.format(controller.arrival().get(i).getScheduledHour());
                    String hourArrival = hourformat.format(controller.arrival().get(i).getArrivalHour());
                    printUsers(numeroPessoas,controller.arrival().get(i).getSnsUserNumber(),hourArrival);
                    numeroPessoas++;
                }
            }
        }
        if (numeroPessoas == 1) {
            System.out.println("There are no people in the waiting room.");
        }
    }

    /**
     * Print users.
     *
     * @param contador      the contador
     * @param snsUserNumber the sns user number
     * @param hourArrival   the hour arrival
     */
    public void printUsers(int contador, int snsUserNumber,String hourArrival) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        SNSUser user;
        for (int i = 0; i < controller.getUsers().size(); i++) {
            String snsUserAux = controller.getUsers().get(i).getSNSNumber();
            if (snsUserAux.equals(snsUserNumber)) {
                user = controller.getUsers().get(i);
                String birthdayPrint = df.format(user.getBirthDate());
                System.out.println(String.format(contador + ". Name: %s, Sex: %s, Birth Date: %s, SNS User Number: %s, Phone Number: %s, Arrived at: %s", user.getName(), user.getGender(), birthdayPrint, snsUserNumber, user.getPhoneNumber(),hourArrival)+"\n");
            }
        }
    }

    /**
     * Gets center name.
     *
     * @return the center name
     */
    public String getCenterName() {
        int count;
        int option;
        if (controller.getCenter().isEmpty()) {
            System.out.println("There aren't any centers available.");
            return null;
        }
        do {
            count = 0;
            for (int i = 0; i < controller.getCenter().size(); i++) {
                System.out.println(count + " - " + controller.getCenter().get(i));
                count++;
            }
            option = Utils.readIntegerFromConsole("Choose a center: ");
        } while (option < 0 || option > controller.getCenter().size());
        return controller.getCenter().get(option).getAddress();
    }
}
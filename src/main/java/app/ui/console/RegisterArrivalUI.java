package app.ui.console;

import app.ui.console.utils.Utils;
import app.controller.RegisterArrivalController;
import app.domain.model.ScheduleVaccine;
import app.domain.model.WaitingRoom;
import app.domain.model.VaccinationCenter;
import app.domain.model.Vaccine;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class RegisterArrivalUI implements Runnable {

    private final RegisterArrivalController controller;

    public RegisterArrivalUI() {
        this.controller = new RegisterArrivalController();
    }

    @Override
    public void run() {
        try {
            VaccinationCenter center = getVaccinationCenter();
            if (center != null) {
                System.out.println("Valid center \n");
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Calendar today = Calendar.getInstance();
                String scheduleAux = df.format(today.getTime());
                Date findSchedule = df.parse(scheduleAux);
                ScheduleVaccine schedule = getScheduledVaccinesForCenter(center.getAddress(), findSchedule);
                if (schedule != null) {
                    System.out.println("Valid appointment \n");
                    registerArrival(schedule);
                    System.out.println("User Sent. Leaving...");
                }
            }
        } catch (ParseException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private VaccinationCenter getVaccinationCenter() {
        daySchedule.clear();
        VaccinationCenter center;
        int contador = 0;
        int option;
        do {
            for (int i = 0; i < controller.getCenterList().size(); i++) {
                System.out.println(contador + " - " + controller.getCenterList().get(i) + "\n");
                contador++;
            }
            option = Utils.readIntegerFromConsole("Choose a vaccination center:");
        } while (option < 0 || option > controller.getCenterList().size());
        center = controller.getCenterList().get(option);
        if (controller.getCenterList().isEmpty()) {
            System.out.println("No vaccination centers available");
            return null;
        }
        return center;
    }

    private ArrayList<ScheduleVaccine> daySchedule = new ArrayList<>();

    private ScheduleVaccine getScheduledVaccinesForCenter(String centerName, Date date) {
        int option;
        int contador;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dateFind = Calendar.getInstance();
        dateFind.setTime(date);
        String findDate = df.format(dateFind.getTime());

        if (controller.getSchedules().isEmpty()) {
            System.out.println("No scheduled vaccines for today");
            return null;
        }
        do {
            contador = 0;
            for (int i = 0; i < controller.getSchedules().size(); i++) {
                String centerAux = controller.getSchedules().get(i).getCenterName();
                if (centerAux.equals(centerName)) {
                    String dateAux = df.format(controller.getSchedules().get(i).getScheduleDate());
                    if (dateAux.equals(findDate)) {
                        System.out.println(contador + " - " + controller.getSchedules().get(i) + "\n");
                        daySchedule.add(controller.getSchedules().get(i));
                        contador++;
                    }
                }
            }
            if (contador == 0) {
                System.out.println("No scheduled vaccines for today.");
                return null;
            }
            option = Utils.readIntegerFromConsole("Choose a schedule:");
        } while (option < 0 || option > contador);
        if (!daySchedule.isEmpty()) {
            return daySchedule.get(option);
        }
        return null;
    }

    private boolean registerArrivalRemoveSchedule(ScheduleVaccine schedule) {
        int send;
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String hour = hourFormat.format(schedule.getScheduledHour());
        String date = dateFormat.format(schedule.getScheduleDate());

        System.out.println(String.format("\nUser: %s, Hour: %s, For: %s.", schedule.getSnsUserNumber(), hour, date) + "\n");
        do {
            System.out.println("Send the user to the waiting room? \n");
            System.out.println("0 - Yes \n");
            System.out.println("1 - No");
            send = Utils.readIntegerFromConsole("Choose an option: ");
            if (send == 0) {
                return true;
            }
        } while (send < 0 || send > 1);
        return true;
    }

    private void registerArrival(ScheduleVaccine scheduleVaccine) {
        try {
            DateFormat hf = new SimpleDateFormat("HH:mm:ss");
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Calendar thisHour = Calendar.getInstance();
            Calendar thisDate = Calendar.getInstance();
            String thisDateAux = df.format(thisDate.getTime());
            String thisHourAux = hf.format(thisHour.getTime());
            Date date = df.parse(thisDateAux);
            Date hour = hf.parse(thisHourAux);
            System.out.println("Hour of Arrival --> " + thisHourAux + "\n");
            WaitingRoom wait = new WaitingRoom(date, hour, scheduleVaccine.getSnsUserNumber(), scheduleVaccine.getScheduledHour(), scheduleVaccine.getCenterName(), scheduleVaccine.getVaccineName());
            if (registerArrivalRemoveSchedule(scheduleVaccine)) {
                if (controller.addWaitingRoom(wait)) {
                    controller.removeScheduleFromList(scheduleVaccine);
                    System.out.println("User sent to the waiting room successfully\n");
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

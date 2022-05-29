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
                Utils.printToConsole("-> INFO <- Valid Center \n");
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Calendar today = Calendar.getInstance();
                String scheduleAux = df.format(today.getTime());
                Date findSchedule = df.parse(scheduleAux);
                ScheduleVaccine schedule = getScheduledVaccinesForCenter(center.getName(), findSchedule);
                if (schedule != null) {
                    Utils.printToConsole("-> INFO <- Valid Appointment \n");
                    registerArrival(schedule);
                    Utils.printToConsole("-> INFO <- User Sent. Leaving...");
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
                Utils.printToConsole(contador + " - " + controller.getCenterList().get(i) + "\n");
                contador++;
            }
            option = Utils.readIntegerFromConsole("Choose a Center:");
        } while (option < 0 || option > controller.getCenterList().size());
        center = controller.getCenterList().get(option);
        if (controller.getCenterList().isEmpty()) {
            Utils.printToConsole("-> INFO <- There Aren't Any Vaccination Centers Available.");
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
            Utils.printToConsole("-> INFO <- There Aren't Any Scheduled Vaccines For Today!");
            return null;
        }
        do {
            contador = 0;
            for (int i = 0; i < controller.getSchedules().size(); i++) {
                String centerAux = controller.getSchedules().get(i).getCenterName();
                if (centerAux.equals(centerName)) {
                    String dateAux = df.format(controller.getSchedules().get(i).getScheduleDate());
                    if (dateAux.equals(findDate)) {
                        Utils.printToConsole(contador + " - " + controller.getSchedules().get(i) + "\n");
                        daySchedule.add(controller.getSchedules().get(i));
                        contador++;
                    }
                }
            }
            if (contador == 0) {
                Utils.printToConsole("-> INFO <- There Aren't Any Scheduled Vaccines For Today!");
                return null;
            }
            option = Utils.readIntegerFromConsole("Choose a Schedule:");
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

        Utils.printToConsole(String.format("\nUser: %s, Hour: %s, For: %s.", schedule.getSnsUserNumber(), hour, date) + "\n");
        do {
            Utils.printToConsole("Send the User for the Waiting Room? \n");
            Utils.printToConsole("0 - YES \n");
            Utils.printToConsole("1 - NO");
            send = Utils.readIntegerFromConsole("Choose an Option: ");
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
            Calendar rightNowHour = Calendar.getInstance();
            Calendar rightNowDate = Calendar.getInstance();
            String rightNowDateAux = df.format(rightNowDate.getTime());
            String rightNowHourAux = hf.format(rightNowHour.getTime());
            Date date = df.parse(rightNowDateAux);
            Date hour = hf.parse(rightNowHourAux);
            Utils.printToConsole("-> INFO <- Hour of Arrival --> " + rightNowHourAux + "\n");
            WaitingRoom wait = new WaitingRoom(date, hour, scheduleVaccine.getSnsUserNumber(), scheduleVaccine.getScheduledHour(), scheduleVaccine.getCenterName(), scheduleVaccine.getVaccineName());
            if (registerArrivalRemoveSchedule(scheduleVaccine)) {
                if (controller.addWaitingRoom(wait)) {
                    controller.removeScheduleFromList(scheduleVaccine);
                    Utils.printToConsole("-> INFO <- User Has Been Sent For The Waiting Room\n");
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

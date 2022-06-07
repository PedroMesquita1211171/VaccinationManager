package app.domain.Store;


import app.domain.model.SNSUser;
import app.domain.model.ScheduleVaccine;
import app.domain.model.VaccinationCenter;
import app.domain.model.Vaccine;
import app.ui.console.utils.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The type Schedule vaccine store.
 */
public class ScheduleVaccineStore {

    private List<ScheduleVaccine> scheduleVaccineList;

    /**
     * Instantiates a new Schedule vaccine store.
     */
    public ScheduleVaccineStore() {
        this.scheduleVaccineList = new ArrayList<>();
    }

    /**
     * Gets scheduled vaccine list.
     *
     * @return the scheduled vaccine list
     */
    public List<ScheduleVaccine> getScheduledVaccineList() {
        return scheduleVaccineList;
    }

    /**
     * Validate schedule vaccine boolean.
     *
     * @param scheduleVaccine the schedule vaccine
     * @return the boolean
     */
    public boolean validateScheduleVaccine(ScheduleVaccine scheduleVaccine) {

        if (scheduleVaccine == null) return false;
        for (ScheduleVaccine sv : scheduleVaccineList) {
            if(scheduleVaccine.equals(sv)) return false;
        }


        return true;

    }

    /**
     * Create schedule vaccine schedule.
     *
     * @param scheduleDate the schedule date
     * @param scheduleHour the schedule hour
     * @param snsUserID    the sns user id
     * @param centerName   the center name
     * @param vaccineName  the vaccine name
     * @return the schedule vaccine
     */
    public ScheduleVaccine createScheduleVaccine(Date scheduleDate, Date scheduleHour, String snsUserID, String centerName, String vaccineName) {
        return new ScheduleVaccine(scheduleDate, scheduleHour, snsUserID,centerName, vaccineName);
    }

    private Date addMinutesToScheduledHour(Date scheduleHour, String slotDuration, String maxVaccinesPerSlot) {
        DateFormat hourFormat = new SimpleDateFormat("HH:mm");
        try {
            Calendar calHour = Calendar.getInstance();
            int slotTime = Integer.parseInt(slotDuration);
            int maxVaccinesSlot = Integer.parseInt(maxVaccinesPerSlot);
            int minutesPerSlot = slotTime / maxVaccinesSlot;
            calHour.setTime(scheduleHour);
            calHour.add(Calendar.MINUTE, minutesPerSlot);

            String finalHourString = hourFormat.format(calHour.getTime());
            Date nextHour = hourFormat.parse(finalHourString);

            scheduleHour = nextHour;
            return nextHour;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return scheduleHour;
    }

    private boolean checkHourIsInSlot(Date scheduledHour, String closingHour) {
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            Date closing = hourFormat.parse(closingHour);

            Calendar openHour = Calendar.getInstance();
            Calendar closeHour = Calendar.getInstance();

            openHour.setTime(scheduledHour);
            closeHour.setTime(closing);
            if (closeHour.compareTo(openHour) > 0) {
                System.out.println("There Are Slots Available!");
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("No more slots availabel for this day.");
        return false;
    }

    /**
     * Find schedule boolean.
     *
     * @param findDate    the find date
     * @param centerName  the center name
     * @param vaccineName the vaccine name
     * @return the boolean
     */
    public boolean findSchedule(Date findDate, String centerName, String vaccineName) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date = df.format(findDate);
        for (int i = 0; i < scheduleVaccineList.size(); i++) {
            String centerAux = scheduleVaccineList.get(i).getCenterName();
            String dateAux = df.format(scheduleVaccineList.get(i).getScheduleDate());
            if (dateAux.equals(date)) {
                if (centerName.equals(centerAux)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Schedule vaccine with entries boolean.
     *
     * @param email              the email
     * @param snsUserNumber      the sns user number
     * @param centerName         the center name
     * @param vaccineName        the vaccine name
     * @param scheduleDate       the schedule date
     * @param slotDuration       the slot duration
     * @param maxVaccinesPerSlot the max vaccines per slot
     * @param openingHour        the opening hour
     * @param closingHour        the closing hour
     * @return the boolean
     */
    public boolean scheduleVaccineWithEntries(String email, String snsUserNumber, String centerName, String vaccineName, Date scheduleDate, String slotDuration, String maxVaccinesPerSlot, String openingHour, String closingHour) {
        DateFormat hf = new SimpleDateFormat("HH:mm");
        String hour = "00:00";
        try {
            Date scheduledHour = hf.parse(hour);
            ScheduleVaccine a1 = new ScheduleVaccine(scheduleDate, scheduledHour, snsUserNumber, centerName, vaccineName);
            Date newHour = getLastHour(a1);
            if (checkHourIsInSlot(newHour, closingHour)) {
                newHour = addMinutesToScheduledHour(newHour, slotDuration, maxVaccinesPerSlot);
            } else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Gets last hour.
     *
     * @param scheduleVaccine the schedule vaccine
     * @return the last hour
     */
    public Date getLastHour(ScheduleVaccine scheduleVaccine) {
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        String centerName = scheduleVaccine.getCenterName();
        String vaccineName = scheduleVaccine.getVaccineName();
        Date scheduleDate = scheduleVaccine.getScheduleDate();
        String dateFind = df.format(scheduleDate);
        Date lastHour = scheduleVaccine.getScheduledHour();
        Calendar firstCompare = Calendar.getInstance();
        Calendar secoundCompare = Calendar.getInstance();
        for (int i = 0; i < scheduleVaccineList.size(); i++) {
            String centerAux = scheduleVaccineList.get(i).getCenterName();
            if (centerAux.equals(centerName)) {
                String vaccineAux = scheduleVaccineList.get(i).getVaccineName();
                String dateAux = df.format(scheduleVaccineList.get(i).getScheduleDate());
                if (dateAux.equals(dateFind)) {
                    Date dateAUX = scheduleVaccineList.get(i).getScheduledHour();
                    firstCompare.setTime(lastHour);
                    secoundCompare.setTime(dateAUX);
                    if (secoundCompare.compareTo(firstCompare) >= 0) {
                        firstCompare = secoundCompare;
                    }
                }
            }
        }
        Date goingHour;
        String firstCompareString = df.format(firstCompare.getTime());
        try {
            goingHour = df.parse(firstCompareString);
            return goingHour;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Save schedule boolean.
     *
     * @param scheduleVaccine the schedule vaccine
     * @return the boolean
     */
    public boolean saveSchedule(ScheduleVaccine scheduleVaccine) {
        if(validateScheduleVaccine(scheduleVaccine)){
            this.scheduleVaccineList.add(scheduleVaccine);
            return true;
        }
        return false;
    }
}

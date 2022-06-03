package app.domain.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Waiting room.
 */
public class WaitingRoom {

    private Date arrivalDate;

    private Date arrivalHour;

    private String snsUserNumber;

    private Date scheduledHour;

    private String vaccinationCenterName;

    private String vaccineName;

    /**
     * Instantiates a new Waiting room.
     *
     * @param arrivalDate   the arrival date
     * @param arrivalHour   the arrival hour
     * @param snsUserNumber the sns user number
     * @param scheduledHour the scheduled hour
     * @param centerName    the center name
     * @param vaccineName   the vaccine name
     */
    public WaitingRoom(Date arrivalDate, Date arrivalHour, String snsUserNumber, Date scheduledHour, String centerName, String vaccineName) {
        this.arrivalDate = arrivalDate;
        this.arrivalHour = arrivalHour;
        this.snsUserNumber = snsUserNumber;
        this.scheduledHour = scheduledHour;
        this.vaccinationCenterName = centerName;
        this.vaccineName = vaccineName;
    }

    public String toString() {
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String hour = hourFormat.format(scheduledHour);
        String date = dateFormat.format(arrivalDate);
        return String.format("Day: %s, User: %s, Hour: %s, Vaccine: %s --> Arrived at: %s",date,snsUserNumber,hour,vaccineName,arrivalHour);
    }

    /**
     * Gets arrival date.
     *
     * @return the arrival date
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets arrival date.
     *
     * @param arrivalDate the arrival date
     */
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * Gets arrival hour.
     *
     * @return the arrival hour
     */
    public Date getArrivalHour() {
        return arrivalHour;
    }

    /**
     * Sets arrival hour.
     *
     * @param arrivalHour the arrival hour
     */
    public void setArrivalHour(Date arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    /**
     * Gets sns user number.
     *
     * @return the sns user number
     */
    public String getSnsUserNumber() {
        return snsUserNumber;
    }

    /**
     * Sets sns user number.
     *
     * @param snsUserNumber the sns user number
     */
    public void setSnsUserNumber(String snsUserNumber) {
        this.snsUserNumber = snsUserNumber;
    }

    /**
     * Gets scheduled hour.
     *
     * @return the scheduled hour
     */
    public Date getScheduledHour() {
        return scheduledHour;
    }

    /**
     * Sets scheduled hour.
     *
     * @param scheduledHour the scheduled hour
     */
    public void setScheduledHour(Date scheduledHour) {
        this.scheduledHour = scheduledHour;
    }

    /**
     * Gets center name.
     *
     * @return the center name
     */
    public String getCenterName() {
        return vaccinationCenterName;
    }

    /**
     * Sets center name.
     *
     * @param centerName the center name
     */
    public void setCenterName(String centerName) {
        this.vaccinationCenterName = centerName;
    }

    /**
     * Gets vaccine name.
     *
     * @return the vaccine name
     */
    public String getVaccineName() {
        return vaccineName;
    }

    /**
     * Sets vaccine name.
     *
     * @param vaccineName the vaccine name
     */
    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }
}


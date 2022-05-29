package app.domain.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitingRoom {

    private Date arrivalDate;

    private Date arrivalHour;

    private String snsUserNumber;

    private Date scheduledHour;

    private String vaccinationCenterName;

    private String vaccineName;

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

    public Date getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getArrivalHour() {
        return arrivalHour;
    }
    public void setArrivalHour(Date arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    public String getSnsUserNumber() {
        return snsUserNumber;
    }
    public void setSnsUserNumber(String snsUserNumber) {
        this.snsUserNumber = snsUserNumber;
    }

    public Date getScheduledHour() {
        return scheduledHour;
    }
    public void setScheduledHour(Date scheduledHour) {
        this.scheduledHour = scheduledHour;
    }

    public String getCenterName() {
        return vaccinationCenterName;
    }
    public void setCenterName(String centerName) {
        this.vaccinationCenterName = centerName;
    }

    public String getVaccineName() {
        return vaccineName;
    }
    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }
}


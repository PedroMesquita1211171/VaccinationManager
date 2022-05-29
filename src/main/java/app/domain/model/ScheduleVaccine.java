package app.domain.model;


import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ScheduleVaccine {



    private Date scheduleDate;
    private int snsUserNumber;
    private Date scheduledHour;
    private String centerName;
    private String vaccineName;


    public ScheduleVaccine(Date scheduleDate, Date scheduledHour, int snsUserNumber, String centerName, String vaccineName) {
        this.scheduleDate = scheduleDate;
        this.snsUserNumber = snsUserNumber;
        this.centerName = centerName;
        this.vaccineName = vaccineName;
        this.scheduledHour = scheduledHour;
    }

    public String toString() {
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String hour = hourFormat.format(scheduledHour);
        String date = dateFormat.format(scheduleDate);
        return String.format("Date: %s, Hour: %s, User: %s, Center: %s, Vaccine: %sm ",date,hour,snsUserNumber,centerName,vaccineName);
    }


    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public int getSnsUserNumber() {
        return snsUserNumber;
    }

    public void setSnsUserNumber(int snsUserNumber) {
        this.snsUserNumber = snsUserNumber;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public Date getScheduledHour() {
        return scheduledHour;
    }

    public void setScheduledHour(Date scheduledHour) {
        this.scheduledHour = scheduledHour;
    }

}

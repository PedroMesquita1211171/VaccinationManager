package app.domain.model;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ScheduleVaccine {



    private Date scheduleDate;
    private String snsUserNumber;
    private Date scheduledHour;
    private String centerName;
    private String vaccineName;


    /**
     * Instantiates a new Schedule vaccine.
     *
     * @param scheduleDate  the schedule date
     * @param scheduledHour the scheduled hour
     * @param snsUserNumber the sns user number
     * @param centerAddress the center address
     * @param vaccineName   the vaccine name
     */
    public ScheduleVaccine(Date scheduleDate, Date scheduledHour, String snsUserNumber, String centerAddress, String vaccineName) {
        checkScheduleDate(scheduleDate);
        checkVaccine(vaccineName);
        checkScheduledHour(scheduledHour);
        checkCenterAddress(centerAddress);
        checkSnsNumber(snsUserNumber);
        

        this.scheduleDate = scheduleDate;
        this.snsUserNumber = snsUserNumber;
        this.centerName = centerAddress;
        this.vaccineName = vaccineName;
        this.scheduledHour = scheduledHour;
    }

    public String toString() {
        DateFormat hourFormat = new SimpleDateFormat("HH:mm");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String hour = hourFormat.format(scheduledHour);
        String date = dateFormat.format(scheduleDate);
        return String.format("Date: %s, Hour: %s, User: %s, Center: %s, Vaccine: %sm ",date,hour,snsUserNumber,centerName,vaccineName);
    }


    /**
     * Gets schedule date.
     *
     * @return the schedule date
     */
    public Date getScheduleDate() {
        return scheduleDate;
    }

    /**
     * Sets schedule date.
     *
     * @param scheduleDate the schedule date
     */
    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
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
     * Gets center name.
     *
     * @return the center name
     */
    public String getCenterName() {
        return centerName;
    }

    /**
     * Sets center name.
     *
     * @param centerName the center name
     */
    public void setCenterName(String centerName) {
        this.centerName = centerName;
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
    private void checkScheduleDate(Date scheduleDate){
        if (scheduleDate==null)
            throw new IllegalArgumentException("Date can't be null or empty!");
    }
    private void checkSnsNumber(String snsUserNumber){
        if (snsUserNumber==null || snsUserNumber.isEmpty())
            throw new IllegalArgumentException("Sns number can't be null or empty!");
    }
    private void checkCenterAddress(String centerName){
        if (centerName==null || centerName.isEmpty())
            throw new IllegalArgumentException("Address can't be null or empty!");
    }
    private void checkVaccine(String vaccineName){
        if (vaccineName==null || vaccineName.isEmpty())
            throw new IllegalArgumentException("Vaccine can't be null or empty!");
    }
    private void checkScheduledHour(Date scheduledHour){
        if (scheduledHour==null)
            throw new IllegalArgumentException("Hour can't be null or empty!");
    }
}

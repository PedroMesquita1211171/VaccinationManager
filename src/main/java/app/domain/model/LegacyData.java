package app.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The type Legacy data.
 */
public class LegacyData implements Serializable {
    private String SNSNumber;
    private String VaccineName;
    private String Dose;
    private String LotNumber;
    private Calendar ScheduleDateTime;
    private Calendar ArrivalDateTime;
    private Calendar AdministrationDateTime;
    private Calendar LeavingTime;

    /**
     * Instantiates a new Legacy data.
     *
     * @param SNSNumber              the sns number
     * @param VaccineName            the vaccine name
     * @param Dose                   the dose
     * @param LotNumber              the lot number
     * @param ScheduleDateTime       the schedule date time
     * @param ArrivalDateTime        the arrival date time
     * @param AdministrationDateTime the administration date time
     * @param LeavingTime            the leaving time
     */
    public LegacyData(String SNSNumber, String VaccineName, String Dose, String LotNumber, Calendar ScheduleDateTime, Calendar ArrivalDateTime, Calendar AdministrationDateTime, Calendar LeavingTime) {

        this.SNSNumber = SNSNumber;
        this.VaccineName = VaccineName;
        this.Dose = Dose;
        this.LotNumber = LotNumber;
        this.ScheduleDateTime = ScheduleDateTime;
        this.ArrivalDateTime = ArrivalDateTime;
        this.AdministrationDateTime = AdministrationDateTime;
        this.LeavingTime = LeavingTime;
    }

    /**
     * Sets sns number.
     *
     * @param SNSNumber the sns number
     */
    public void setSNSNumber(String SNSNumber) {
        this.SNSNumber = SNSNumber;
    }

    /**
     * Sets vaccine name.
     *
     * @param VaccineName the vaccine name
     */
    public void setVaccineName(String VaccineName) {
        this.VaccineName = VaccineName;
    }

    /**
     * Sets lot number.
     *
     * @param LotNumber the lot number
     */
    public void setLotNumber(String LotNumber) {
        this.LotNumber = LotNumber;
    }

    /**
     * Sets dose.
     *
     * @param Dose the dose
     */
    public void setDose(String Dose) {
        this.Dose = Dose;
    }

    /**
     * Sets schedule date time.
     *
     * @param ScheduleDateTime the schedule date time
     */
    public void setScheduleDateTime(Calendar ScheduleDateTime) {
        this.ScheduleDateTime = ScheduleDateTime;
    }

    /**
     * Sets arrival date time.
     *
     * @param ArrivalDateTime the arrival date time
     */
    public void setArrivalDateTime(Calendar ArrivalDateTime) {
        this.ArrivalDateTime = ArrivalDateTime;
    }

    /**
     * Sets administration date time.
     *
     * @param AdministrationDateTime the administration date time
     */
    public void setAdministrationDateTime(Calendar AdministrationDateTime) {
        this.AdministrationDateTime = AdministrationDateTime;
    }

    /**
     * Sets leaving time.
     *
     * @param LeavingTime the leaving time
     */
    public void setLeavingTime(Calendar LeavingTime) {
        this.LeavingTime = LeavingTime;
    }

    /**
     * Gets sns number.
     *
     * @return the sns number
     */
    public String getSNSNumber() {
        return SNSNumber;
    }

    /**
     * Gets vaccine name.
     *
     * @return the vaccine name
     */
    public String getVaccineName() {
        return VaccineName;
    }

    /**
     * Gets lot number.
     *
     * @return the lot number
     */
    public String getLotNumber() {
        return LotNumber;
    }

    /**
     * Gets dose.
     *
     * @return the dose
     */
    public String getDose() {
        return Dose;
    }

    /**
     * Gets schedule date time.
     *
     * @return the schedule date time
     */
    public Calendar getScheduleDateTime() {
        return ScheduleDateTime;
    }

    /**
     * Gets arrival date time.
     *
     * @return the arrival date time
     */
    public Calendar getArrivalDateTime() {
        return ArrivalDateTime;
    }

    /**
     * Gets administration date time.
     *
     * @return the administration date time
     */
    public Calendar getAdministrationDateTime() {
        return AdministrationDateTime;
    }

    /**
     * Gets leaving time.
     *
     * @return the leaving time
     */
    public Calendar getLeavingTime() {
        return LeavingTime;
    }
    public String toString() {
        return "LegacyData{" +
                "SNSNumber='" + SNSNumber + '\'' +
                ", VaccineName='" + VaccineName + '\'' +
                ", Dose='" + Dose + '\'' +
                ", LotNumber='" + LotNumber + '\'' +
                ", ScheduleDateTime=" + ScheduleDateTime +
                ", ArrivalDateTime=" + ArrivalDateTime +
                ", AdministrationDateTime=" + AdministrationDateTime +
                ", LeavingTime=" + LeavingTime +
                '}';
    }
}

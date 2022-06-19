package app.domain.model;

import java.util.Calendar;

public class LegacyData {
    private String SNSNumber;
    private String VaccineName;
    private String Dose;
    private String LotNumber;
    private Calendar ScheduleDateTime;
    private Calendar ArrivalDateTime;
    private Calendar AdministrationDateTime;
    private Calendar LeavingTime;

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
    public void setSNSNumber(String SNSNumber) {
        this.SNSNumber = SNSNumber;
    }
    public void setVaccineName(String VaccineName) {
        this.VaccineName = VaccineName;
    }
    public void setLotNumber(String LotNumber) {
        this.LotNumber = LotNumber;
    }
    public void setDose(String Dose) {
        this.Dose = Dose;
    }
    public void setScheduleDateTime(Calendar ScheduleDateTime) {
        this.ScheduleDateTime = ScheduleDateTime;
    }
    public void setArrivalDateTime(Calendar ArrivalDateTime) {
        this.ArrivalDateTime = ArrivalDateTime;
    }
    public void setAdministrationDateTime(Calendar AdministrationDateTime) {
        this.AdministrationDateTime = AdministrationDateTime;
    }
    public void setLeavingTime(Calendar LeavingTime) {
        this.LeavingTime = LeavingTime;
    }
    public String getSNSNumber() {
        return SNSNumber;
    }
    public String getVaccineName() {
        return VaccineName;
    }
    public String getLotNumber() {
        return LotNumber;
    }
    public String getDose() {
        return Dose;
    }
    public Calendar getScheduleDateTime() {
        return ScheduleDateTime;
    }
    public Calendar getArrivalDateTime() {
        return ArrivalDateTime;
    }
    public Calendar getAdministrationDateTime() {
        return AdministrationDateTime;
    }
    public Calendar getLeavingTime() {
        return LeavingTime;
    }
}

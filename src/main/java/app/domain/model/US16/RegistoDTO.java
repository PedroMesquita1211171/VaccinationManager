package app.domain.model.US16;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistoDTO {
    private String snsUserNumber;
    private String vaccineName;
    private String doseNumber;
    private String lotNumber;
    private LocalDateTime scheduledDateTime;
    private LocalDateTime arrivalDateTime;
    private LocalDateTime administrationDateTime;
    private LocalDateTime leavingDateTime;

    private final String format = "M/d/yyyy H:mm";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);


    public RegistoDTO(String snsUserNumber,
                      String vaccineName,
                      String doseNumber,
                      String lotNumber,
                      LocalDateTime scheduledDateTime,
                      LocalDateTime arrivalDateTime,
                      LocalDateTime administrationDateTime,
                      LocalDateTime leavingDateTime) {
        this.snsUserNumber = snsUserNumber;
        this.vaccineName = vaccineName;
        this.doseNumber = doseNumber;
        this.lotNumber = lotNumber;
        this.scheduledDateTime = scheduledDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.administrationDateTime = administrationDateTime;
        this.leavingDateTime = leavingDateTime;
    }

    public String getSnsUserNumber() {
        return snsUserNumber;
    }

    public void setSnsUserNumber(String snsUserNumber) {
        this.snsUserNumber = snsUserNumber;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getDoseNumber() {
        return doseNumber;
    }

    public void setDoseNumber(String doseNumber) {
        this.doseNumber = doseNumber;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public LocalDateTime getScheduledDateTime() {
        return scheduledDateTime;
    }

    public void setScheduledDateTime(LocalDateTime scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public LocalDateTime getAdministrationDateTime() {
        return administrationDateTime;
    }

    public void setAdministrationDateTime(LocalDateTime administrationDateTime) {
        this.administrationDateTime = administrationDateTime;
    }

    public LocalDateTime getLeavingDateTime() {
        return leavingDateTime;
    }

    public void setLeavingDateTime(LocalDateTime leavingDateTime) {
        this.leavingDateTime = leavingDateTime;
    }

    @Override
    public String toString() {
        return  snsUserNumber + " | " +
                vaccineName + " | " +
                doseNumber + " | " +
                lotNumber + " | " +
                scheduledDateTime.format(formatter) + " | " +
                arrivalDateTime.format(formatter) + " | " +
                administrationDateTime.format(formatter) + " | " +
                leavingDateTime.format(formatter);
    }
}

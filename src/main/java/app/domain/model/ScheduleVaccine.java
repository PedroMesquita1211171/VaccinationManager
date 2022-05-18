package app.domain.model;
import app.DTO.SNSUserDTO;
import app.domain.model.Vaccine;
import app.domain.model.SNSUser;
import app.domain.model.VaccinationCenter;

public class ScheduleVaccine {
    private String nameUser;
    private String phoneNumber;
    private String vaccinationCenter;
    private String vaccine;
    private String hour;

    public ScheduleVaccine(String nameUser, String phoneNumber, String vaccinationCenter, String vaccine, String hour) {

        this.nameUser = nameUser;
        this.phoneNumber = phoneNumber;
        this.vaccinationCenter = vaccinationCenter;
        this.vaccine = vaccine;
        this.hour = hour;

    }

     public String getNameUser() {
        return nameUser;
    }

    /**
     * Gets employee email.
     *
     * @return the email
     */

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets employee address.
     *
     * @return the address
     */

    public String getVaccinationCenter() {
        return vaccinationCenter;
    }

    /**
     * Gets employee phone number.
     *
     * @return the phone number
     */

    public String getVaccine() {
        return vaccine;
    }

    /**
     * Gets employee citizen card number.
     *
     * @return the citizen card number
     */

    public String getHour() {
        return hour;
    }

}

package app.domain.model;




public class ScheduleVaccine {


    private SNSUser user;
    private VaccinationCenter v;
    private Vaccine vaccine;
    private String hour;

    public ScheduleVaccine(SNSUser user, VaccinationCenter v, Vaccine vaccine, String hour) {

        this.user = user;
        this.v = v;
        this.vaccine = vaccine;
        this.hour = hour;

    }

    /**
     * Gets employee email.
     *
     * @return the email
     */

    public SNSUser getSnsUser() {
        return user;
    }

    /**
     * Gets employee address.
     *
     * @return the address
     */

    public VaccinationCenter getVaccinationCenter() {
        return v;
    }

    /**
     * Gets employee phone number.
     *
     * @return the phone number
     */

    public Vaccine getVaccine() {
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

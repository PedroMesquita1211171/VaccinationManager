package app.domain.model;


import javax.swing.*;
import java.util.Objects;

public class ScheduleVaccine {


    private SNSUser user;
    private VaccinationCenter v;
    private Vaccine vaccine;
    private String slot;

    public ScheduleVaccine(SNSUser user, VaccinationCenter v, Vaccine vaccine, String slot) {
        checkUser(user);
        checkVaccinationCenter(v);
        checkVaccine(vaccine);

        this.user = user;
        this.v = v;
        this.vaccine = vaccine;
        this.slot = slot;

    }


    public SNSUser getSnsUser() {
        return user;
    }

    public VaccinationCenter getVaccinationCenter() {
        return v;
    }


    public Vaccine getVaccine() {
        return vaccine;
    }


    public String getSlot() {
        return slot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScheduleVaccine)) return false;
        ScheduleVaccine that = (ScheduleVaccine) o;
        return Objects.equals(user, that.user) &&  Objects.equals(vaccine, that.vaccine);
    }

    public void checkUser(SNSUser user){

    }

    public void checkVaccinationCenter(VaccinationCenter v){

    }

    public void checkVaccine(Vaccine vaccine){

    }
}

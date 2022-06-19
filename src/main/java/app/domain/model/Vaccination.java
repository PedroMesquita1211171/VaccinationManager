package app.domain.model;

import app.domain.model.VaccineDependencies.AdministrationProcess;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Vaccination.
 */
public class Vaccination implements Serializable {
    private AdverseReaction ar;
    private Vaccine v;
    private int dose;
    private AdministrationProcess ap;
    private String Status;

    /**
     * Instantiates a new Vaccination.
     *
     * @param ar   the ar
     * @param v    the v
     * @param dose the dose
     * @param ap   the ap
     */
    public Vaccination(AdverseReaction ar, Vaccine v, int dose,AdministrationProcess ap) {
        checkAR(ar);
        checkV(v);
        checkDose(dose, ap.getDosesPerGroup());
        this.ar = ar;
        this.v = v;
        this.ap = ap;
        this.dose = dose;
        if(this.dose == this.ap.getDosesPerGroup()){
            this.Status = "Completed";
        }else{
            this.Status = "In Progress";
        }
    }

    /**
     * Instantiates a new Vaccination.
     *
     * @param ar     the ar
     * @param v      the v
     * @param dose   the dose
     * @param Status the status
     * @param ap     the ap
     */
    public Vaccination(AdverseReaction ar, Vaccine v, int dose, String Status, AdministrationProcess ap){
        this.ar = ar;
        this.v = v;
        this.ap = ap;
        this.dose = dose;
        this.Status = Status;
    }

    /**
     * checks if the dose is valid
     *
     * @param dose the dose
     */
    private void checkDose(int dose, int maxdoses) {
        if (dose < 1 ) {
            throw new IllegalArgumentException("Dose must be greater than 0");
        }
        if (dose > maxdoses) {
            throw new IllegalArgumentException("Dose must be less than " + maxdoses);
        }
    }


    /**
     * checks if the vaccine is valid
     *
     * @param v the vaccine
     */
    private void checkV(Vaccine v) {
        if (v == null) {
            throw new IllegalArgumentException("Vaccine cannot be null");
        }
    }

    /**
     * checks if the AR is valid
     *
     * @param ar the AR
     */
    private void checkAR(AdverseReaction ar) {
        if (ar == null) {
            throw new IllegalArgumentException("There was no adverse reaction for such SNS User");
        }
    }

    /**
     * Gets ar.
     *
     * @return the ar
     */
    public AdverseReaction getAr() {
        return ar;
    }

    /**
     * Sets ar.
     *
     * @param ar the ar
     */
    public void setAr(AdverseReaction ar) {
        this.ar = ar;
    }

    /**
     * Gets v.
     *
     * @return the v
     */
    public Vaccine getV() {
        return v;
    }

    /**
     * Sets v.
     *
     * @param v the v
     */
    public void setV(Vaccine v) {
        this.v = v;
    }

    /**
     * Gets dose.
     *
     * @return the dose
     */
    public int getDose() {
        return dose;
    }

    /**
     * Sets dose.
     *
     * @param dose the dose
     */
    public void setDose(int dose) {
        this.dose = dose;
    }

    /**
     * Gets ap.
     *
     * @return the ap
     */
    public AdministrationProcess getAp() {
        return ap;
    }

    /**
     * Sets ap.
     *
     * @param ap the ap
     */
    public void setAp(AdministrationProcess ap) {
        this.ap = ap;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccination that = (Vaccination) o;
        return dose == that.dose && Objects.equals(ar.getSnsu(), that.ar.getSnsu()) && Objects.equals(Status, that.Status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ar, dose, Status);
    }
}

package app.DTO;

import app.domain.model.AdverseReaction;
import app.domain.model.Vaccine;
import app.domain.model.VaccineDependencies.AdministrationProcess;

import java.io.Serializable;

/**
 * The type Vaccination dto.
 */
public class VaccinationDTO implements Serializable {

    private AdverseReaction ar;
    private Vaccine v;
    private int dose;
    private AdministrationProcess ap;
    private String Status;

    /**
     * Instantiates a new Vaccination dto.
     *
     * @param ar     the ar
     * @param v      the v
     * @param dose   the dose
     * @param Status the status
     * @param ap     the ap
     */
    public VaccinationDTO(AdverseReaction ar, Vaccine v, int dose, String Status, AdministrationProcess ap) {
        this.ar = ar;
        this.v = v;
        this.ap = ap;
        this.dose = dose;
        this.Status = Status;
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
     * Gets v.
     *
     * @return the v
     */
    public Vaccine getV() {
        return v;
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
     * Gets ap.
     *
     * @return the ap
     */
    public AdministrationProcess getAp() {
        return ap;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return Status;
    }

    @Override
    public String toString() {
        return
                "\n" + "SNS User " + ar.getSnsu().getName() + "/" + ar.getSnsu().getSNSNumber() + "\n" +
                "Vaccine Brand: " + v.getBrand() + "\n" +
                        "Vaccine Lot Number: " + v.getLotNumber() + "\n" +
                        "Dose Number: " + dose + "\n" +
                "Status: " + Status + "\n"
                ;
    }
}

package app.domain.model.VaccinationCenterDependencies;

import java.io.Serializable;

/**
 * The type Time slot.
 */
public class TimeSlot implements Serializable {
    private Tempo opSlot;
    private Tempo clSlot;

    /**
     * Instantiates a new Time slot.
     *
     * @param opSlot the op slot
     * @param clSlot the cl slot
     */
    public TimeSlot(Tempo opSlot, Tempo clSlot) {
        this.opSlot = opSlot;
        this.clSlot = clSlot;
    }

    /**
     * Gets op slot.
     *
     * @return the op slot
     */
    public Tempo getOpSlot() {
        return opSlot;
    }

    /**
     * Gets cl slot.
     *
     * @return the cl slot
     */
    public Tempo getClSlot() {
        return clSlot;
    }

    /**
     * Is valid boolean.
     *
     * @param t the t
     * @return the boolean
     */
    public boolean isValid(Tempo t) {
        return (t.isMaior(opSlot) && clSlot.isMaior(t));
    }

    /**
     * Sets op slot.
     *
     * @param opSlot the op slot
     */
    public void setOpSlot(Tempo opSlot) {
        this.opSlot = opSlot;
    }

    /**
     * Sets cl slot.
     *
     * @param clSlot the cl slot
     */
    public void setClSlot(Tempo clSlot) {
        this.clSlot = clSlot;
    }

    @Override
    public String toString() {
        return "["+ opSlot +"-"+ clSlot +"]";
    }
}

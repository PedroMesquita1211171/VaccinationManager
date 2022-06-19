package app.domain.model.VaccineDependencies;

/**
 * The type Age group.
 */
public class AgeGroup {
    private int ageInit;
    private int ageEnd;

    /**
     * Instantiates a new Age group.
     *
     * @param ageInit the age init
     * @param ageEnd  the age end
     */
    public AgeGroup(int ageInit, int ageEnd) {
        checkAgeInit(ageInit);
        checkAgeEnd(ageEnd);
        this.ageInit = ageInit;
        this.ageEnd = ageEnd;
    }

    /**
     * Check age init.
     *
     * @param ageInit the age init
     */
    public void checkAgeInit(int ageInit) {
        if (ageInit < 0) {
            throw new IllegalArgumentException("Age init cannot be less than 0");
        }
    }


    /**
     * Check age end.
     *
     * @param ageEnd the age end
     */
    public void checkAgeEnd(int ageEnd) {
        if (ageEnd < 0) {
            throw new IllegalArgumentException("Age end cannot be less than 0");
        }
    }

    /**
     * Gets age init.
     *
     * @return the age init
     */
    public int getAgeInit() {
        return ageInit;
    }

    /**
     * Gets age end.
     *
     * @return the age end
     */
    public int getAgeEnd() {
        return ageEnd;
    }

    /**
     * Gets age range.
     *
     * @return the age range
     */
    public int getAgeRange() {
        return ageEnd - ageInit;
    }

    /**
     * Sets age init.
     *
     * @param ageInit the age init
     */
    public void setAgeInit(int ageInit) {
        this.ageInit = ageInit;
    }

    /**
     * Sets age end.
     *
     * @param ageEnd the age end
     */
    public void setAgeEnd(int ageEnd) {
        this.ageEnd = ageEnd;
    }

    /**
     * Is in boolean.
     *
     * @param age the age
     * @return the boolean
     */
    public boolean isIn(int age){
        return age >= ageInit && age <= ageEnd;
    }

    @Override
    public String toString() {
        return "[ " + ageInit + "-" + ageEnd + " ]";
    }
}

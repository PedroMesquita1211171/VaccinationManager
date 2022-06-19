package app.domain.model.VaccineDependencies;

import java.io.Serializable;

/**
 * The type Administration process.
 */
public class AdministrationProcess implements Serializable {

    private AgeGroup ageGroup;
    private Integer dosesPerGroup;
    private Double dosagePerGroup;
    private Integer numberOfDaysPerGroup;

    /**
     * Instantiates a new Administration process.
     *
     * @param ageGroups            the age groups
     * @param dosesPerGroup        the doses per group
     * @param dosagePerGroup       the dosage per group
     * @param numberOfDaysPerGroup the number of days per group
     */
    public AdministrationProcess(AgeGroup ageGroups, Integer dosesPerGroup, Double dosagePerGroup, Integer numberOfDaysPerGroup) {
        this.ageGroup = ageGroups;
        this.dosesPerGroup = dosesPerGroup;
        this.dosagePerGroup = dosagePerGroup;
        this.numberOfDaysPerGroup = numberOfDaysPerGroup;
    }

    /**
     * Gets age groups.
     *
     * @return the age groups
     */
    public AgeGroup getAgeGroup() {
                return ageGroup;
            }

    /**
     * Sets age groups.
     *
     * @param ageGroups the age groups
     */
    public void setAgeGroup(AgeGroup ageGroups) {
                this.ageGroup = ageGroups;
            }

    /**
     * Gets doses per group.
     *
     * @return the doses per group
     */
    public Integer getDosesPerGroup () {
                return dosesPerGroup;
            }

    /**
     * Sets doses per group.
     *
     * @param dosesPerGroup the doses per group
     */
    public void setDosesPerGroup (Integer dosesPerGroup) {
                this.dosesPerGroup = dosesPerGroup;
            }

    /**
     * Gets dosage per group.
     *
     * @return the dosage per group
     */
    public Double getDosagePerGroup () {
                return dosagePerGroup;
            }

    /**
     * Sets dosage per group.
     *
     * @param dosagePerGroup the dosage per group
     */
    public void setDosagePerGroup (Double dosagePerGroup) {
                this.dosagePerGroup = dosagePerGroup;
            }

    /**
     * Gets number of days per group.
     *
     * @return the number of days per group
     */
    public Integer getNumberOfDaysPerGroup () {
                return numberOfDaysPerGroup;
            }

    /**
     * Sets number of days per group.
     *
     * @param numberOfDaysPerGroup the number of days per group
     */
    public void setNumberOfDaysPerGroup (Integer numberOfDaysPerGroup) {
        this.numberOfDaysPerGroup = numberOfDaysPerGroup;
    }

    @Override
    public String toString() {
        return  "\nAdministration Process" + "\n" +
                "Age Group: " + this.ageGroup + "\n" +
                "Doses: " + this.dosesPerGroup + "\n" +
                "Dosage: " + this.dosagePerGroup + "\n" +
                "Days of recovery: " + this.numberOfDaysPerGroup + "\n"
                ;

    }
}
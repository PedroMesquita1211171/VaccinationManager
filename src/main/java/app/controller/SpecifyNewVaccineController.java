package app.controller;

import app.domain.model.Vaccine;
import app.domain.model.Company;

/**
 * The type Specify new vaccine controller.
 *
 * @author Pedro Mesquita - 1211171
 */
public class SpecifyNewVaccineController {

    private Company company;
    private Vaccine vaccine;

    /**
     * Instantiates the controller used by the UI.
     */
    public SpecifyNewVaccineController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Instantiates the controller used by the UI.
     */
    public SpecifyNewVaccineController(Company company) {
        this.company = company;
        this.vaccine = null;
    }
  
    public boolean createVaccine(String name, int id, int doses,int recovery, int doseinterval) {
        try {
            this.vaccine = new Vaccine(name, id, doses, recovery, doseinterval);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return validateVaccine(vaccine);
    }

    /**
     * Validates the created vaccine.
     *
     * @param vaccine
     * @return the boolean
     */
    public boolean validateVaccine (Vaccine vaccine){
        if (vaccine == null) return false;
        return !company.getVaccineTypeStore().getVaccineTypeList().contains(vaccine);
    }

    /**
     * Adds vaccine.
     */
    public void addVaccine() {
        this.company.addVaccine(vaccine);
    }

    /**
     * Shows vaccine into string format.
     *
     * @return the vaccine in a string format
     */
    public String showVaccine() {
        return this.vaccine.toString();
    }

}

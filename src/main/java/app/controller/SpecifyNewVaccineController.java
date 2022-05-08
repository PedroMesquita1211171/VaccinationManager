package app.controller;

import app.domain.model.Vaccine;
import app.domain.model.Company;

public class SpecifyNewVaccineController {

    private Company company;
    private Vaccine vaccine;

    public SpecifyNewVaccineController() {
        this(App.getInstance().getCompany());
    }

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
    
    public boolean validateVaccine (Vaccine vaccine){
        if (vaccine == null) return false;
        return company.getVaccineTypeStore().getVaccineTypeList().contains(vaccine);
    }

    public void addVaccine() {
        this.company.addVaccine(vaccine);
    }
    
    public String showVaccine() {
        return this.vaccine.toString();
    }

}

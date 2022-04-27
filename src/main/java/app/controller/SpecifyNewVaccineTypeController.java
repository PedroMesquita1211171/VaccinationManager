package app.controller;

import app.domain.model.VaccineType;
import app.domain.model.Company;

public class SpecifyNewVaccineTypeController {

    private Company company;
    private VaccineType vt;

    public SpecifyNewVaccineTypeController () {
        this(App.getInstance().getCompany());
    }

    public SpecifyNewVaccineTypeController(Company company) {
        this.company = company;
        this.vt = null;
    }
    public boolean createVaccineType(String code, String designation, String whoId) {
        try{
            this.vt = new VaccineType(code, designation, whoId);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }

        return validateVaccineType(vt);
    }

    public boolean validateVaccineType (VaccineType vt) {
        if (vt == null) return false;
        return company.getVaccineTypeStore().getVaccineTypeList().contains(vt);
    }

    public void addVaccineType() {
        this.company.addVaccineType(vt);
    }

    public String showVaccineType() {
        return this.vt.toString();
    }
}

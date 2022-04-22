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
        this.vt = this.company.createVaccineType(code, designation, whoId);
        return this.company.validateVaccineType(vt);
    }
    public boolean saveVaccineType() {
        return this.company.saveVaccineType(vt);
    }
}

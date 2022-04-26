package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.shared.Constants;

public class SpecifyNewEmployeeController {

    private final Company company;

    public SpecifyNewEmployeeController() {
        this(App.getInstance().getCompany());
    }

    public SpecifyNewEmployeeController(Company company) {
        this.company = company;
    }
}

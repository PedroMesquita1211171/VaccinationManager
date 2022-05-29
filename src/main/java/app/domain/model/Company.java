package app.domain.model;

import app.domain.Store.*;
import app.domain.shared.Constants;
import app.ui.console.utils.Generators;
import pt.isep.lei.esoft.auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    FileWriter writer;

    private String designation;
    private AuthFacade authFacade;

    private VaccineTypeStore vaccineTypeStore;
    private EmployeeStore employeeStore;
    private SNSUserStore snsUserStore;
    private VaccinationCenterStore vaccinationCenterStore ;
    private VaccineStore vaccineStore;
    private ScheduleVaccineStore scheduleVaccineStore;


    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.vaccineTypeStore = new VaccineTypeStore();
        this.employeeStore = new EmployeeStore();
        this.snsUserStore = new SNSUserStore();
        this.vaccinationCenterStore = new VaccinationCenterStore();
        this.vaccineStore = new VaccineStore();
        this.scheduleVaccineStore= new ScheduleVaccineStore();
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public VaccineTypeStore getVaccineTypeStore() {
        return vaccineTypeStore;
    }

    public EmployeeStore getEmployeeStore() {
        return employeeStore;
    }

    public SNSUserStore getSNSUserStore() {
        return snsUserStore;
    }

    public VaccinationCenterStore getVaccinationCenterStore() { return vaccinationCenterStore; }

    public VaccineStore getVaccineStore(){ return vaccineStore; }

    public ScheduleVaccineStore getScheduleVaccineStore(){ return scheduleVaccineStore;}







}



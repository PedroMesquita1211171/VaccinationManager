package app.domain.model;

import app.domain.Store.EmployeeStore;
import app.domain.Store.SNSUserStore;
import app.domain.Store.VaccineTypeStore;
import pt.isep.lei.esoft.auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;
    private VaccineTypeStore vaccineTypeStore;
    private EmployeeStore employeeStore;
    private SNSUserStore snsUserStore;
    /*private List<VaccineType> vaccineTypeList;
    private List<SNSUser> clients;*/

    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.vaccineTypeStore = new VaccineTypeStore();
        this.employeeStore = new EmployeeStore();
        /*vaccineTypeList = new ArrayList<>();
        clients = new ArrayList<>();*/
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public void addVaccineType (VaccineType vt) {
        vaccineTypeStore.addVaccineType(vt);
    }

    public VaccineTypeStore getVaccineTypeStore() {
        return vaccineTypeStore;
    }

    public EmployeeStore getEmployeeStore() {
        return employeeStore;
    }

    public void addEmployee (Employee e) {
        employeeStore.addEmployee(e);
    }

    public SNSUserStore getSNSUserStore() {
        return snsUserStore;
    }

    public void addSNSUser (SNSUser snsu) {
        snsUserStore.addSNSUser(snsu);
    }


   /* public boolean saveVaccineType (VaccineType vt) {
        if (!validateVaccineType(vt))
            return false;
        return this.vaccineTypeList.add(vt);
    }

    public boolean validateSNSUser (SNSUser snsUser) {
        if (snsUser == null) return false;
        return !this.clients.contains(snsUser);
    }

    public boolean saveSNSUser (SNSUser snsUser) {
        if (!validateSNSUser(snsUser))
            return false;
        return this.clients.add(snsUser);
    }

    public List<VaccineType> getVaccineTypeList() {
        return vaccineTypeList;
    }

    public List<SNSUser> getClients() {
        return clients;
    }*/
}

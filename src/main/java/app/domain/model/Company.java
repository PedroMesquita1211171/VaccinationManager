package app.domain.model;

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
    private List<VaccineType> vaccineTypeList;
    private List<SNSUser> clients;

    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        vaccineTypeList = new ArrayList<>();
        clients = new ArrayList<>();
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public VaccineType createVaccineType (String code, String designation, String whoId) {
        return new VaccineType(code, designation, whoId);
    }

    public boolean validateVaccineType (VaccineType vt) {
        if (vt == null) return false;
        return !this.vaccineTypeList.contains(vt);
    }

    public boolean saveVaccineType (VaccineType vt) {
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
    }
}

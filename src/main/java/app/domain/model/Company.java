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
    private List<VaccineType> vaccineTypeList = new ArrayList<>();

    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
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

}

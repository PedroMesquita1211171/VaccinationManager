package app.domain.model;

import org.junit.platform.commons.util.StringUtils;

import java.io.Serializable;

/**
 * The type Vaccine type.
 *
 * @author Henrique Pinto - 1211201
 */
public class VaccineType implements Serializable {

    private String code;
    private String designation;
    private String vaccineTechnology;

    /**
     * Instantiates a new Vaccine type.
     *
     * @param code              the code
     * @param designation       the designation
     * @param vaccineTechnology the vaccine technology
     */
    public VaccineType (String code, String designation, String vaccineTechnology) {
        checkCodeRules(code);
        checkDesignationRules(designation);
        this.code = code;
        this.designation = designation;
        this.vaccineTechnology = vaccineTechnology;
    }

    /**
     * Checks if VaccineType parameters are valid.
     */
    private void checkCodeRules(String code) {
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be blank.");
        if ( (code.length() < 4) || (code.length() > 8))
            throw new IllegalArgumentException("Code must have 4 to 8 chars.");
    }
    private void checkDesignationRules(String designation){
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");
        if (designation.length() > 40)
            throw new IllegalArgumentException("Designation must have less than 40 chars.");
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets designation.
     *
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Gets vaccine technology.
     *
     * @return the vaccine technology
     */
    public String getVaccineTechnology() {
        return vaccineTechnology;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Sets designation.
     *
     * @param designation the designation
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * Sets vaccine technology.
     *
     * @param vaccineTechnology the vaccine technology
     */
    public void setVaccineTechnology(String vaccineTechnology) {
        this.vaccineTechnology = vaccineTechnology;
    }

    public String toString() {
        return "\n\nInfo: " + "\n" +
                "Code: " + code + "\n" +
                "Designation: " + designation + "\n" +
                "Vaccine Technology: " + vaccineTechnology + "\n\n";
    }
}

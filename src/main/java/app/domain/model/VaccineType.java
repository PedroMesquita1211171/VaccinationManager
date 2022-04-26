package app.domain.model;

import org.junit.platform.commons.util.StringUtils;

public class VaccineType {

    private String code;
    private String designation;
    private String whoId;

    public VaccineType (String code, String designation, String whoId) {
        checkCodeRules(code);
        checkDesignationRules(designation);
        this.code = code;
        this.designation = designation;
        this.whoId = whoId;
    }
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
    public String toString() {
        return "\n\nInfo: " + "\n" +
                "Code: " + code + "\n" +
                "Designation: " + designation + "\n" +
                "WHOId: " + whoId + "\n\n";
    }
}

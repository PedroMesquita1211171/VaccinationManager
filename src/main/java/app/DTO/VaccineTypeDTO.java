package app.DTO;

/**
 * The type Vaccine type dto.
 */
public class VaccineTypeDTO {
    private String code;
    private String designation;
    private String whoId;

    /**
     * Instantiates a new Vaccine type dto.
     *
     * @param code        the code
     * @param designation the designation
     * @param whoId       the who id
     */
    public VaccineTypeDTO(String code, String designation, String whoId) {
        this.code = code;
        this.designation = designation;
        this.whoId = whoId;
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
     * Gets whoId.
     *
     * @return the whoId
     */
    public String getWhoId() {
        return whoId;
    }

    @Override
    public String toString() {
        return
                "\n" + "Code: " + code + "\n" +
                "Designation: " + designation + "\n" +
                "WhoId: " + whoId + "\n"
                ;
    }
}

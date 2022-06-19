package app.DTO;

import app.domain.model.VaccineDependencies.AdministrationProcess;
import app.domain.model.VaccineType;

import java.util.List;

/**
 * The type Vaccine dto.
 */
public class VaccineDTO {

    private String brand;
    private String lotNumber;
    private List<AdministrationProcess> administrationProcesses;
    private VaccineType vaccineType;

    /**
     * Instantiates a new Vaccine dto.
     *
     * @param brand                 the brand
     * @param lotNumber             the lot number
     * @param administrationProcess the administration process
     * @param vaccineType           the vaccine type
     */
    public VaccineDTO(String brand, String lotNumber, List<AdministrationProcess> administrationProcess, VaccineType vaccineType) {
        this.brand = brand;
        this.lotNumber = lotNumber;
        this.administrationProcesses = administrationProcess;
        this.vaccineType = vaccineType;
    }

    /**
     * Gets brand.
     *
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Gets lot number.
     *
     * @return the lot number
     */
    public String getLotNumber() {
        return lotNumber;
    }

    /**
     * Gets administration processes.
     *
     * @return the administration processes
     */
    public List<AdministrationProcess> getAdministrationProcesses() {
        return administrationProcesses;
    }

    /**
     * Gets vaccine type.
     *
     * @return the vaccine type
     */
    public VaccineType getVaccineType() {
        return vaccineType;
    }

    /**
     * Gets administration process.
     *
     * @param age the age
     * @return the administration process
     */
    public AdministrationProcess getAdministrationProcess(int age) {
        for (AdministrationProcess process : this.administrationProcesses) {
            if (process.getAgeGroup().isIn(age)) {
                return process;
            }
        }
        throw new IllegalArgumentException("No administration process found for age " + age);
    }

    @Override
    public String toString() {
        return  "Vaccine to Be Added: " + "\n" +
                "Brand: " + brand + "\n" +
                "Lot Number: " + lotNumber + "\n" +
                "Vaccine Type Code: " + vaccineType.getCode() + "\n" +
                "Vaccine Type Designation: " + vaccineType.getDesignation() + "\n"
                ;

    }
}

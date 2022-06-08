package app.DTO;

import app.domain.model.VaccineDependencies.AdministrationProcess;
import app.domain.model.VaccineType;

import java.util.List;

public class VaccineDTO {

    private String brand;
    private String lotNumber;
    private List<AdministrationProcess> administrationProcesses;
    private VaccineType vaccineType;

    public VaccineDTO(String brand, String lotNumber, List<AdministrationProcess> administrationProcess, VaccineType vaccineType) {
        this.brand = brand;
        this.lotNumber = lotNumber;
        this.administrationProcesses = administrationProcess;
        this.vaccineType = vaccineType;
    }

    public String getBrand() {
        return brand;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public List<AdministrationProcess> getAdministrationProcesses() {
        return administrationProcesses;
    }

    public VaccineType getVaccineType() {
        return vaccineType;
    }

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

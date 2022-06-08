package app.domain.model;

import app.domain.model.VaccineDependencies.AdministrationProcess;

import java.util.List;
import java.util.Objects;

/**
 * The type Vaccine.
 */
public class Vaccine implements Comparable<Vaccine> {

    private String brand;
    private String lotNumber;
    private List<AdministrationProcess> administrationProcesses;
    private VaccineType vaccineType;

    /**
     * Instantiates a new Vaccine.
     *
     * @param brand                 the brand
     * @param lotNumber             the lot number
     * @param administrationProcess the administration process
     * @param vaccineType           the vaccine type
     */
    public Vaccine(String brand, String lotNumber, List<AdministrationProcess> administrationProcess, VaccineType vaccineType) {
        checkBrand(brand);
        checkLotNumber(lotNumber);
        checkAdministrationProcess(administrationProcess);
        checkVaccineType(vaccineType);
        this.brand = brand;
        this.lotNumber = lotNumber;
        this.administrationProcesses = administrationProcess;
        this.vaccineType = vaccineType;
    }

    /**
     * Check brand.
     *
     * @param brand the brand
     */
    public void checkBrand(String brand) {
        if(brand== null || brand.isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or empty");
        }
        if (brand.length() < 3) {
            throw new IllegalArgumentException("Brand is too short");
        }
    }

    /**
     * Check lot number.
     *
     * @param lotNumber the lot number
     */
    public void checkLotNumber(String lotNumber) {
        if(lotNumber== null || lotNumber.isEmpty()) {
            throw new IllegalArgumentException("Lot number cannot be null or empty");
        }
        try{
            Long.parseLong(lotNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Lot number is not a number");
        }
        if (lotNumber.length() < 3) {
            throw new IllegalArgumentException("Lot number is too short");
        }
    }

    /**
     * Check administration process.
     *
     * @param administrationProcess the administration process
     */
    public void checkAdministrationProcess(List<AdministrationProcess> administrationProcess) {
        if(administrationProcess == null) {
            throw new IllegalArgumentException("Administration process cannot be null");
        }
    }

    /**
     * Check vaccine type.
     *
     * @param vaccineType the vaccine type
     */
    public void checkVaccineType(VaccineType vaccineType) {
        if(vaccineType == null) {
            throw new IllegalArgumentException("Vaccine type cannot be null");
        }
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
     * Sets brand.
     *
     * @param brand the brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
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
     * Sets lot number.
     *
     * @param lotNumber the lot number
     */
    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    /**
     * Gets administration process.
     *
     * @return the administration process
     */
    public List<AdministrationProcess> getAdministrationProcesses() {
        return administrationProcesses;
    }

    /**
     * Sets administration process.
     *
     * @param administrationProcesses the administration process
     */
    public void setAdministrationProcesses(List<AdministrationProcess> administrationProcesses) {
        this.administrationProcesses = administrationProcesses;
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
     * Sets vaccine type.
     *
     * @param vaccineType the vaccine type
     */
    public void setVaccineType(VaccineType vaccineType) {
        this.vaccineType = vaccineType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccine vaccine = (Vaccine) o;
        return brand.equals(vaccine.brand) && lotNumber.equals(vaccine.lotNumber) && administrationProcesses.equals(vaccine.administrationProcesses) && vaccineType.equals(vaccine.vaccineType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, lotNumber, administrationProcesses, vaccineType);
    }

    @Override
    public int compareTo(Vaccine o) {
        if(this.equals(o)) {
            if(this.getVaccineType().getDesignation().compareTo(o.getVaccineType().getDesignation()) < 0) {
                return -1;
            }else if(this.getVaccineType().getDesignation().compareTo(o.getVaccineType().getDesignation()) > 0) {
                return 1;
            }else {
                return 0;
            }
        }else if(this.getBrand().compareTo(o.getBrand()) < 0) {
            return -1;
        }else if(this.getBrand().compareTo(o.getBrand()) > 0) {
            return 1;
        }else{
             return 0;
        }
    }
}

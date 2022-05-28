package app.domain.model;

import org.junit.platform.commons.util.StringUtils;

/**
 * The type Vaccine.
 *
 * @author Pedro Mesquita - 1211171
 */
public class Vaccine {


    private String name;
    private int ID;
    private String brand;
    private int doses;
    private int dosage;
    private int recovery;
    private int doseinterval;


    /**
     * Instantiates a new Vaccine.
     *
     * @param name         the name
     * @param ID           the id
     * @param brand        the brand
     * @param doses        the doses
     * @param dosage       the dosage
     * @param recovery     the recovery
     * @param doseinterval the doseinterval
     */
    public Vaccine(String name, int ID, String brand ,int doses,int dosage, int recovery, int doseinterval){

        checkName(name);
        checkID(ID);
        checkBrand(brand);
        checkDoses(doses);
        checkDosage(dosage);
        checkRecovery(recovery);
        checkDoseInterval(doseinterval);

        this.name = name;
        this.ID = ID;
        this.brand = brand;
        this.doses = doses;
        this.dosage = dosage;
        this.recovery = recovery;
        this.doseinterval = doseinterval;

    }

    /**
     * Checkers used to verify if the Vaccine is valid.
     *
     */

    private void checkName(String name) {
        if(name.isEmpty() || name == null) throw new IllegalArgumentException("Name can't be empty or null!");
        if (name.length() < 3)
            throw new IllegalArgumentException("Name is too short!");

        if (name.length() > 20)
            throw new IllegalArgumentException("Name Can't Have More Than 20 Characters");
    }

    private void checkID(int ID) {
        if (ID < 1)
            throw new IllegalArgumentException("ID must be greater than 0");
    }

    private void checkBrand(String brand) {
        if(brand.isEmpty() || brand == null) throw new IllegalArgumentException("Brand can't be empty or null!");
        if (brand.length() < 3)
            throw new IllegalArgumentException("Brand is too short!");

        if (brand.length() > 20)
            throw new IllegalArgumentException("Brand Can't Have More Than 20 Characters");
    }

    private void checkDoses(int doses) {
        if (doses < 1)
            throw new IllegalArgumentException("Number of doses must be greater than 0");
    }

    private void checkDosage(int dosage) {
        if (dosage < 1)
            throw new IllegalArgumentException("Dosage must be greater than 0ml");
    }

    private void checkRecovery(int recovery) {
        if (recovery < 1)
            throw new IllegalArgumentException("Recovery days must be greater than 0");
    }

    private void checkDoseInterval(int doseinterval) {
        if (doseinterval < 1)
            throw new IllegalArgumentException("Dose interval days must be greater than 0");
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getBrand() {
        return brand;
    }

    public int getDoses() {
        return doses;
    }

    public int getDosage() {
        return dosage;
    }

    public int getRecovery() {
        return recovery;
    }

    public int getDoseInterval() {
        return doseinterval;
    }

    /**
     * returns the vaccine data as a string.
     *
     */

    @Override
    public String toString() {
        return
                "\n\nName: " + name + "\n" +
                "ID: " + ID + "\n" +
                "Brand: " + brand + "\n" +
                "Doses: " + doses + "\n" +
                "Dosage: " + dosage + "\n" +
                "Recovery: " + recovery + "\n" +
                "Dose Interval: " + doseinterval + "\n"
                ;
    }
}
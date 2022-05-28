package app.DTO;

public class VaccineDTO {

    private String name;
    private int ID;
    private String brand;
    private int doses;
    private int dosage;
    private int recovery;
    private int doseinterval;

    public VaccineDTO(String name, int ID, String brand ,int doses,int dosage, int recovery, int doseinterval) {

        this.name = name;
        this.ID = ID;
        this.brand = brand;
        this.doses = doses;
        this.dosage = dosage;
        this.recovery = recovery;
        this.doseinterval = doseinterval;
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

    @Override
    public String toString() {
        return "\n" +
                "Vaccine Name: " + name + "\n" +
                "Vaccine brand: " + brand + "\n"
                ;
    }
}

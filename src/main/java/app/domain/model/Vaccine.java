package app.domain.model;

import org.junit.platform.commons.util.StringUtils;

public class Vaccine {


    private String name;
    private int ID;
    private int doses;
    private int recovery;
    private int doseinterval;

    public Vaccine(String name, int ID, int doses, int recovery, int doseinterval){
        checkRules(name,ID,doses,recovery,doseinterval);
        this.name = name;
        this.ID = ID;
        this.doses = doses;
        this.recovery = recovery;
        this.doseinterval = doseinterval;
    }
    public void checkRules(String name,int ID, int doses, int recovery, int doseinterval){
        if (StringUtils.isBlank(name)|StringUtils.isBlank(Integer.toString(ID))|StringUtils.isBlank(Integer.toString(doses))|StringUtils.isBlank(Integer.toString(recovery))|StringUtils.isBlank(Integer.toString(doseinterval)))
            throw new IllegalArgumentException("Arguments cannot be blank.");
    }

    public String toString() {
        return "\n\nInfo: " + "\n" +
                "Vaccine name: " + name + "\n" +
                "Vaccine ID: " + ID + "\n" +
                "Number of doses: " + doses + "\n" +
                "Recovery days: " + recovery + "\n" +
                "Days between doses: " + doseinterval + "\n\n";
    }
}

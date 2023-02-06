package app.domain.model.US16;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CenterData {
    private List<Registo> registos;
    private final String format = "M/d/yyyy H:mm";

    public CenterData() {
        this.registos = new ArrayList<>();
    }

    public Registo createRegisto(String snsUserNumber,
                                 String vaccineName,
                                 String doseNumber,
                                 String lotNumber,
                                 String scheduledDateTime,
                                 String arrivalDateTime,
                                 String administrationDateTime,
                                 String leavingDateTime){

        return new Registo(
                snsUserNumber,
                vaccineName,
                doseNumber,
                lotNumber,
                DateParser.parseDate(scheduledDateTime, format),
                DateParser.parseDate(arrivalDateTime, format),
                DateParser.parseDate(administrationDateTime, format),
                DateParser.parseDate(leavingDateTime, format)
        );
    }

    public void addRegisto(Registo registo){
        validateRegisto(registo);
        this.registos.add(registo);
    }

    public void validateRegisto(Registo registo) {
        if(registo == null){
            this.registos = new ArrayList<>();
            throw new IllegalArgumentException("Registo cannot be null\nDiscarding file...");
        }

        if(getRegistos().contains(registo)){
            this.registos = new ArrayList<>();
            throw new IllegalArgumentException("Registo already exists\nDiscarding file...");
        }

    }

    public List<Registo> getRegistos() {
        return registos;
    }
}

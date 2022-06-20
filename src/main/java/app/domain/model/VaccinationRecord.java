package app.domain.model;
import app.controller.App;
import app.domain.Store.VaccinationCenterStore;
import app.domain.model.Company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The type Vaccination record.
 */
public class VaccinationRecord extends TimerTask {

    private Company company;

    public VaccinationRecord(Company company) {
        this.company = company;
    }

    public VaccinationRecord() {
        this(App.getInstance().getCompany());
    }

    /**
     * Main.
     */
    public void run() {
        try {
            // Conseguir data
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            // Criar ficheiro
            FileWriter myWriter = new FileWriter(formatter.format(calendar.getTime())+" - Vaccination Report.csv");
            // Enquanto existirem centros de vacinação, escrever nome do centro com número de pessoas vacinadas nesse dia.
            List<VaccinationCenter> vaccinationCenters = this.company.getVaccinationCenterStore().getVaccinationCenters();

            if (vaccinationCenters.size()>0) {
                myWriter.write(formatter.format(calendar.getTime()));
                myWriter.write("\n");
                Map<VaccinationCenter, Integer> vaccinationCenterHashMap = new HashMap<>();
                for (VaccinationCenter v: vaccinationCenters) {
                    vaccinationCenterHashMap.put(v,this.company.getWaitingRoomStore().vaccinationsperCenter(v));
                }

                for(Map.Entry<VaccinationCenter, Integer> v : vaccinationCenterHashMap.entrySet()) {
                    myWriter.write("\nName: "+v.getKey().getName());
                    myWriter.write("\nPatients vaccinated today: "+v.getValue());
                    myWriter.write("\n");
                }

            } else {
                myWriter.write("\nThere are no vaccination centers registered");
                System.out.println("No vaccination centers registered");
            }
            myWriter.flush();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

}

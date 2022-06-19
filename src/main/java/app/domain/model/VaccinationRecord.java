package app.domain.model;
import app.domain.Store.CounterStore;
import app.domain.Store.VaccinationCenterStore;
import app.domain.model.Company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * The type Vaccination record.
 */
public class VaccinationRecord {
    /**
     * Main.
     */
    public static void main() {
        try {
            // Conseguir data
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            // Criar ficheiro
            FileWriter myWriter = new FileWriter(formatter.format(calendar.getTime())+" - Vaccination Report.csv");

            // Enquanto existirem centros de vacinação, escrever nome do centro com número de pessoas vacinadas nesse dia.

            List<VaccinationCenter> vaccinationCenters = new VaccinationCenterStore().getVaccinationCenters();


            if (vaccinationCenters.size()>0) {
                myWriter.write(formatter.format(calendar.getTime()));
                myWriter.write("\n");

                System.out.println(vaccinationCenters);
            } else {
                myWriter.write("\nThere are no vaccination centers registered");
                System.out.println("No vaccination centers registered");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

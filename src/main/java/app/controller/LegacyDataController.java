package app.controller;

import app.domain.model.Company;
import app.domain.model.LegacyData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LegacyDataController {
    private Company company;
    private List<LegacyData> legacyDataList;
    public LegacyDataController(Company company) {
        this.company = company;
        this.legacyDataList = new ArrayList<>();}
    public LegacyDataController() {this(App.getInstance().getCompany());}
    public void createLegacyDataList(String SNSNumber, String VaccineName, String Dose, String LotNumber, Calendar ScheduleDateTime, Calendar ArrivalDateTime, Calendar AdministrationDateTime, Calendar LeavingTime) {
        this.legacyDataList.add(this.company.getLegacyDataStore().createLegacyData(SNSNumber, VaccineName, Dose, LotNumber, ScheduleDateTime, ArrivalDateTime, AdministrationDateTime, LeavingTime));
    }
    public void saveLegacyDataList() {
        for (LegacyData legacyData : this.legacyDataList) {
            boolean a = this.company.getLegacyDataStore().addLegacyData(legacyData);
            if (a) {
                System.out.println("\nLegacy Data" + "\n" + "SNS Number: " + legacyData.getSNSNumber() + "\n" + "Vaccine Name: " + legacyData.getVaccineName() + "\n" + "Dose: " + legacyData.getDose() + "\n" + "Lot Number: " + legacyData.getLotNumber() + "\n" + "Schedule Date Time: " + legacyData.getScheduleDateTime() + "\n" + "Arrival Date Time: " + legacyData.getArrivalDateTime() + "\n" + "Administration Date Time: " + legacyData.getAdministrationDateTime() + "\n" + "Leaving Time: " + legacyData.getLeavingTime() + "\n");
            }
        }
    }
}

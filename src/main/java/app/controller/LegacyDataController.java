package app.controller;

import app.domain.model.Company;
import app.domain.model.LegacyData;
import app.domain.shared.CommonMethods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The type Legacy data controller.
 */
public class LegacyDataController {
    private Company company;
    private List<LegacyData> legacyDataList = new ArrayList<>();

    /**
     * Instantiates a new Legacy data controller.
     *
     * @param company the company
     */
    public LegacyDataController(Company company) {
        this.company = company;
        this.legacyDataList = new ArrayList<>();}

    /**
     * Instantiates a new Legacy data controller.
     */
    public LegacyDataController() {this(App.getInstance().getCompany());}

    /**
     * Create legacy data list.
     *
     * @param SNSNumber              the sns number
     * @param VaccineName            the vaccine name
     * @param Dose                   the dose
     * @param LotNumber              the lot number
     * @param ScheduleDateTime       the schedule date time
     * @param ArrivalDateTime        the arrival date time
     * @param AdministrationDateTime the administration date time
     * @param LeavingTime            the leaving time
     */
    public void createLegacyDataList(String SNSNumber, String VaccineName, String Dose, String LotNumber, Calendar ScheduleDateTime, Calendar ArrivalDateTime, Calendar AdministrationDateTime, Calendar LeavingTime) {
        this.legacyDataList.add(this.company.getLegacyDataStore().createLegacyData(SNSNumber, VaccineName, Dose, LotNumber, ScheduleDateTime, ArrivalDateTime, AdministrationDateTime, LeavingTime));
    }

    /**
     * Save legacy data list.
     */
    public void saveLegacyDataList() throws ParseException {
        for (LegacyData legacyData : this.legacyDataList) {
            boolean a = this.company.getLegacyDataStore().addLegacyData(legacyData);
            if (a) {
                for(int i =0; i <this.legacyDataList.size(); i++){
                    SimpleDateFormat form = new SimpleDateFormat("MM/dd/yyyy hh:mm");
                    Date date1 = this.legacyDataList.get(i).getScheduleDateTime().getTime();
                    Date date2 = this.legacyDataList.get(i).getArrivalDateTime().getTime();
                    Date date3 = this.legacyDataList.get(i).getAdministrationDateTime().getTime();
                    Date date4 = this.legacyDataList.get(i).getLeavingTime().getTime();
                    System.out.println("\nLegacy Data"+ " SNS Number: " + legacyDataList.get(i).getSNSNumber() + " Vaccine Name: " + legacyDataList.get(i).getVaccineName() + " Dose: " + legacyDataList.get(i).getDose() + " Lot Number: " + legacyDataList.get(i).getLotNumber() + " Schedule Date Time: " + date1 + " Arrival Date Time: " + date2 + " Administration Date Time: " + date3 + " Leaving Time: " + date4 + "\n");
                }
                }
            }
                 CommonMethods.serializeStore(this.company.getLegacyDataStore().getLegacyDataList(),"data\\legacyData.dat");
        }
public void printLegacyDataList(List<LegacyData> arr){
    for(int i =0; i < arr.size(); i++){
        SimpleDateFormat form = new SimpleDateFormat("MM/dd/yyyy hh:mm");
        Date date1 = arr.get(i).getScheduleDateTime().getTime();
        Date date2 = arr.get(i).getArrivalDateTime().getTime();
        Date date3 = arr.get(i).getAdministrationDateTime().getTime();
        Date date4 = arr.get(i).getLeavingTime().getTime();
        System.out.println("\nLegacy Data"+ " SNS Number: " + arr.get(i).getSNSNumber() + " Vaccine Name: " + arr.get(i).getVaccineName() + " Dose: " + arr.get(i).getDose() + " Lot Number: " + arr.get(i).getLotNumber() + " Schedule Date Time: " + date1 + " Arrival Date Time: " + date2 + " Administration Date Time: " + date3 + " Leaving Time: " + date4 + "\n");
    }
}
    /**
     * Gets legacy data list.
     *
     * @return the legacy data list
     */
    public List <LegacyData> getLegacyDataList() {
        return this.company.getLegacyDataStore().getLegacyDataList();
    }
}

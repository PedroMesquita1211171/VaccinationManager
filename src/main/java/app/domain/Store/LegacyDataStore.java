package app.domain.Store;

import app.controller.LegacyDataController;
import app.domain.model.LegacyData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LegacyDataStore {
    private List<LegacyData> legacyDataList;
    public LegacyDataStore() {
        this.legacyDataList = new ArrayList<>();
    }
    public List<LegacyData> getLegacyDataList() {
        return legacyDataList;
    }
    public boolean addLegacyData(LegacyData legacyData) {
        if(validateLegacyData(legacyData)){
            this.legacyDataList.add(legacyData);
            return true;
        }
        return false;
    }
    public boolean validateLegacyData(LegacyData legacyData) {
        if(legacyData == null)return false;
        if(getLegacyDataList().contains(legacyData)) return false;
        for (LegacyData other : getLegacyDataList()) {
            if(other.getSNSNumber().equals(legacyData.getSNSNumber())||other.getLotNumber().equals(legacyData.getLotNumber())||other.getAdministrationDateTime().equals(legacyData.getAdministrationDateTime())|| other.getArrivalDateTime().equals(legacyData.getArrivalDateTime())||other.getScheduleDateTime().equals(legacyData.getScheduleDateTime())||other.getDose().equals(legacyData.getDose())||other.getLeavingTime().equals(legacyData.getLeavingTime())||other.getVaccineName().equals(legacyData.getVaccineName())) return false;
        }return true;
}
public LegacyData createLegacyData(String SNSNumber, String VaccineName, String Dose, String LotNumber, Calendar ScheduleDateTime, Calendar ArrivalDateTime, Calendar AdministrationDateTime, Calendar LeavingTime) {
    return new LegacyData(SNSNumber, VaccineName, Dose, LotNumber, ScheduleDateTime, ArrivalDateTime, AdministrationDateTime, LeavingTime);
}
}

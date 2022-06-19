package app.domain.Store;

import app.controller.LegacyDataController;
import app.domain.model.LegacyData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The type Legacy data store.
 */
public class LegacyDataStore {
    private List<LegacyData> legacyDataList;

    /**
     * Instantiates a new Legacy data store.
     */
    public LegacyDataStore() {
        this.legacyDataList = new ArrayList<>();
    }

    /**
     * Gets legacy data list.
     *
     * @return the legacy data list
     */
    public List<LegacyData> getLegacyDataList() {
        return legacyDataList;
    }

    /**
     * Add legacy data boolean.
     *
     * @param legacyData the legacy data
     * @return the boolean
     */
    public boolean addLegacyData(LegacyData legacyData) {
        if(validateLegacyData(legacyData)){
            this.legacyDataList.add(legacyData);
            return true;
        }
        return false;
    }

    /**
     * Validate legacy data boolean.
     *
     * @param legacyData the legacy data
     * @return the boolean
     */
    public boolean validateLegacyData(LegacyData legacyData) {
        if(legacyData == null)return false;
        if(getLegacyDataList().contains(legacyData)) return false;
        return true;
}

    /**
     * Create legacy data legacy data.
     *
     * @param SNSNumber              the sns number
     * @param VaccineName            the vaccine name
     * @param Dose                   the dose
     * @param LotNumber              the lot number
     * @param ScheduleDateTime       the schedule date time
     * @param ArrivalDateTime        the arrival date time
     * @param AdministrationDateTime the administration date time
     * @param LeavingTime            the leaving time
     * @return the legacy data
     */
    public LegacyData createLegacyData(String SNSNumber, String VaccineName, String Dose, String LotNumber, Calendar ScheduleDateTime, Calendar ArrivalDateTime, Calendar AdministrationDateTime, Calendar LeavingTime) {
    return new LegacyData(SNSNumber, VaccineName, Dose, LotNumber, ScheduleDateTime, ArrivalDateTime, AdministrationDateTime, LeavingTime);
}
}

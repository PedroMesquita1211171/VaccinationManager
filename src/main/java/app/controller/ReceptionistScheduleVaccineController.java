package app.controller;


import app.domain.model.Company;
import app.domain.model.SNSUser;
import app.domain.model.ScheduleVaccine;
import app.DTO.Mappers.VaccinationCenterMapper;
import app.DTO.Mappers.VaccineMapper;
import app.DTO.VaccinationCenterDTO;
import app.DTO.VaccineDTO;

import java.util.Date;
import java.util.List;

/**
 * The type Receptionist schedule vaccine controller.
 */
public class ReceptionistScheduleVaccineController {

    private final Company company;
    private ScheduleVaccine scheduleVaccine;


    /**
     * Instantiates a new Receptionist schedule vaccine controller.
     */
    public ReceptionistScheduleVaccineController(){this(App.getInstance().getCompany());}

    /**
     * Instantiates a new Receptionist schedule vaccine controller.
     *
     * @param company the company
     */
    public ReceptionistScheduleVaccineController(Company company){
        this.company = App.getInstance().getCompany();
        this.scheduleVaccine = null;
    }

    /**
     * Create schedule boolean.
     *
     * @param scheduleDate  the schedule date
     * @param scheduleHour  the schedule hour
     * @param snsUserID     the sns user id
     * @param centerAddress the center address
     * @param vaccineName   the vaccine name
     * @return the boolean
     */
    public boolean createSchedule(Date scheduleDate, Date scheduleHour, String snsUserID, String centerAddress, String vaccineName){
        try{
            this.scheduleVaccine = this.company.getScheduleVaccineStore().createScheduleVaccine(scheduleDate,scheduleHour, snsUserID, centerAddress, vaccineName);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }

        return this.company.getScheduleVaccineStore().validateScheduleVaccine(this.scheduleVaccine);
    }


    /**
     * Save schedule boolean.
     *
     * @return the boolean
     */
    public boolean saveSchedule(){
        return this.company.getScheduleVaccineStore().saveSchedule(this.scheduleVaccine);
    }

    /**
     * Vac center list list.
     *
     * @return the list
     */
    public List<VaccinationCenterDTO> vacCenterList(){
        return VaccinationCenterMapper.toDTOList(this.company.getVaccinationCenterStore().getVaccinationCenterList());
    }

    /**
     * Vaccine list list.
     *
     * @return the list
     */
    public List<VaccineDTO> vaccineList(){
        return VaccineMapper.toDTOList(this.company.getVaccineStore().getVaccineList());
    }

    /**
     * Gets user list.
     *
     * @return the user list
     */
    public List<SNSUser> getUserList() {
        return company.getSNSUserStore().getSNSUserList();
    }
}

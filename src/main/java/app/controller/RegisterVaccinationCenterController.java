package app.controller;

import app.DTO.EmployeeDTO;
import app.DTO.Mappers.EmployeeMapper;
import app.DTO.Mappers.VaccinationCenterMapper;
import app.DTO.VaccinationCenterDTO;
import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.model.VaccinationCenter;
import app.domain.model.VaccinationCenterDependencies.Tempo;
import app.domain.shared.CommonMethods;

import java.util.List;

/**
 * The type Register vaccination center controller.
 */
public class RegisterVaccinationCenterController {

    private Company company;
    private VaccinationCenter vaccinationCenter;

    /**
     * Instantiates a new Register vaccination center controller.
     *
     * @param company the company
     */
    public RegisterVaccinationCenterController(Company company) {
        this.company = company;
    }

    /**
     * Instantiates a new Register vaccination center controller.
     */
    public RegisterVaccinationCenterController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Create vaccination center boolean.
     *
     * @param name           the name
     * @param address        the address
     * @param emailAddress   the email address
     * @param phoneNumber    the phone number
     * @param faxNumber      the fax number
     * @param websiteAddress the website address
     * @param openingHours   the opening hours
     * @param closingHours   the closing hours
     * @param slotDuration   the slot duration
     * @param maxVaccines    the max vaccines
     * @param coordinatorDTO the coordinator dto
     * @param ages           the ages
     * @param ars            the ars
     * @param region         the region
     * @return the boolean
     */
    public boolean createVaccinationCenter(String name, String address, String emailAddress, String phoneNumber, String faxNumber, String websiteAddress, Tempo openingHours, Tempo closingHours, int slotDuration, int maxVaccines, EmployeeDTO coordinatorDTO, String ages, String ars, String region) {
        //healthcare Center
        this.vaccinationCenter = this.company.getVaccinationCenterStore().createVaccinationCenter(name, address, emailAddress, phoneNumber, faxNumber, websiteAddress, openingHours, closingHours, slotDuration, maxVaccines, EmployeeMapper.toEntity(coordinatorDTO), ages, ars, region);

        return this.company.getVaccinationCenterStore().validateVaccinationCenter(this.vaccinationCenter);
    }

    /**
     * Create vaccination center boolean.
     *
     * @param name           the name
     * @param address        the address
     * @param emailAddress   the email address
     * @param phoneNumber    the phone number
     * @param faxNumber      the fax number
     * @param websiteAddress the website address
     * @param openingHours   the opening hours
     * @param closingHours   the closing hours
     * @param slotDuration   the slot duration
     * @param maxVaccines    the max vaccines
     * @param coordinatorDTO the coordinator dto
     * @return the boolean
     */
    public boolean createVaccinationCenter(String name, String address, String emailAddress, String phoneNumber, String faxNumber, String websiteAddress, Tempo openingHours, Tempo closingHours, int slotDuration, int maxVaccines, EmployeeDTO coordinatorDTO) {
       //Mass community center
        this.vaccinationCenter = this.company.getVaccinationCenterStore().createVaccinationCenter(name, address, emailAddress, phoneNumber, faxNumber, websiteAddress, openingHours, closingHours, slotDuration, maxVaccines,EmployeeMapper.toEntity(coordinatorDTO));

        return this.company.getVaccinationCenterStore().validateVaccinationCenter(this.vaccinationCenter);
    }

    /**
     * Save vaccination center boolean.
     *
     * @return the boolean
     */
    public boolean saveVaccinationCenter() {
        boolean a = this.company.getVaccinationCenterStore().addVaccinationCenter(this.vaccinationCenter);
        CommonMethods.serializeStore(this.company.getVaccinationCenterStore().getVaccinationCenters(),"data\\VaccinationCenter.dat");
        return a;
    }

    /**
     * Center coordinators list list.
     *
     * @return the list
     */
    public List<EmployeeDTO> centerCoordinatorsList() {
        return EmployeeMapper.toDTOList(this.company.getEmployeeStore().getCenterCoordinatorList());
    }

    /**
     * Gets vaccination center.
     *
     * @return the vaccination center
     */
    public VaccinationCenterDTO getVaccinationCenter() {
        return VaccinationCenterMapper.toDTO(this.vaccinationCenter);
    }

}

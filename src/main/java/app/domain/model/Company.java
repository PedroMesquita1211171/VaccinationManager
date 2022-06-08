package app.domain.model;

import app.domain.Store.*;
import pt.isep.lei.esoft.auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

/**
 * The type Company.
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;
    private SNSUserStore snsUserStore;
    private EmployeeStore employeeStore;
    private VaccineTypeStore vaccineTypeStore;
    private VaccineStore vaccineStore;
    private VaccinationCenterStore vaccinationCenterStore;
    private ScheduleStore scheduleStore;
    private WaitingRoomStore waitingRoomStore;

    /**
     * Instantiates a new Company.
     *
     * @param designation the designation
     */
    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.snsUserStore = new SNSUserStore();
        this.employeeStore = new EmployeeStore();
        this.vaccineTypeStore = new VaccineTypeStore();
        this.vaccineStore = new VaccineStore();
        this.vaccinationCenterStore = new VaccinationCenterStore();
        this.scheduleStore = new ScheduleStore();
        this.waitingRoomStore = new WaitingRoomStore();
    }

    /**
     * Gets designation.
     *
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Gets auth facade.
     *
     * @return the auth facade
     */
    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    /**
     * Gets sns user store.
     *
     * @return the sns user store
     */
    public SNSUserStore getSNSUserStore() {
        return snsUserStore;
    }

    /**
     * Gets employee store.
     *
     * @return the employee store
     */
    public EmployeeStore getEmployeeStore() {
        return employeeStore;
    }

    /**
     * Gets vaccine type store.
     *
     * @return the vaccine type store
     */
    public VaccineTypeStore getVaccineTypeStore() {
        return vaccineTypeStore;
    }

    /**
     * Gets vaccine store.
     *
     * @return the vaccine store
     */
    public VaccineStore getVaccineStore() { return vaccineStore; }

    /**
     * Gets vaccination center store.
     *
     * @return the vaccination center store
     */
    public VaccinationCenterStore getVaccinationCenterStore() {
        return vaccinationCenterStore;
    }

    /**
     * Gets schedule store.
     *
     * @return the schedule store
     */
    public ScheduleStore getScheduleStore() {
        return scheduleStore;
    }

    /**
     * Gets waiting room store.
     *
     * @return the waiting room store
     */
    public WaitingRoomStore getWaitingRoomStore() {
        return waitingRoomStore;
    }

}

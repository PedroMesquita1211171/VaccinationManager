package app.domain.model;

import app.domain.Store.*;
import pt.isep.lei.esoft.auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

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
    private AdverseReactionStore adverseReactionStore;
    private VaccinationStore vaccinationStore;
    private LegacyDataStore legacyDataStore;

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
        this.snsUserStore = new SNSUserStore(); // a
        this.employeeStore = new EmployeeStore(); // a
        this.vaccineTypeStore = new VaccineTypeStore(); // a
        this.vaccineStore = new VaccineStore(); //
        this.vaccinationCenterStore = new VaccinationCenterStore(); //
        this.scheduleStore = new ScheduleStore(); //
        this.waitingRoomStore = new WaitingRoomStore(); //
        this.adverseReactionStore = new AdverseReactionStore(); //
        this.vaccinationStore = new VaccinationStore(); //
        this.legacyDataStore = new LegacyDataStore();
        //de-serialize the stores
        try {
            setSNSUserStore();
            setEmployeeStore();
            setVaccineTypeStore();
            setVaccineStore();
            setVaccinationCenterStore();
            setScheduleStore();
            setWaitingRoomStore();
            setAdverseReactionStore();
            setVaccinationStore();
            setLegacyDataStore();
        } catch(Exception e){}
    }

    private void setLegacyDataStore() {
        try {
            FileInputStream fis = new FileInputStream("data\\legacyData.dat");ObjectInputStream ois = new ObjectInputStream(fis);
            getLegacyDataStore().setLegacyDataList((List<LegacyData>) ois.readObject());
        } catch (Exception e) {
        }
    }

    private void setVaccinationStore() {
        try {
            FileInputStream inputStream = new FileInputStream("data\\vaccination.dat");ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            getVaccinationStore().setVaccinationList((List<Vaccination>) objectInputStream.readObject());
        } catch (Exception e) {

        }
    }

    private void setAdverseReactionStore() {
        try {
            FileInputStream inputStream = new FileInputStream("data\\AdverseReaction.dat");ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            getAdverseReactionStore().setStore((List<AdverseReaction>) objectInputStream.readObject());
        } catch (Exception e) {

        }
    }

    private void setWaitingRoomStore() {
        try {
            FileInputStream in = new FileInputStream("data\\WaitingRoom.dat");ObjectInputStream inputStream = new ObjectInputStream(in);
            getWaitingRoomStore().setWaitingRoomList((List<WaitingRoom>) inputStream.readObject());
        } catch (Exception e) {
        }
    }

    private void setScheduleStore() {
        try {
            FileInputStream inputStream = new FileInputStream("data\\Schedule.dat");ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            getScheduleStore().setScheduleList((List<Schedule>) objectInputStream.readObject());
        } catch (Exception e) {
        }
    }

    private void setVaccinationCenterStore() {
        try {
            FileInputStream fis = new FileInputStream("data\\VaccinationCenter.dat"); ObjectInputStream ois = new ObjectInputStream(fis);
            getVaccinationCenterStore().setVaccinationCenterList((List<VaccinationCenter>) ois.readObject());
        } catch (Exception e) {
        }
    }

    private void setVaccineStore() {
        try {
            FileInputStream inputStream = new FileInputStream("data\\vaccines.dat"); ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            getVaccineStore().setVaccines((List<Vaccine>) objectInputStream.readObject());
        } catch (Exception e) {
        }
    }

    private void setVaccineTypeStore() {
        try  {
            FileInputStream in = new FileInputStream("data\\vaccineType.dat");ObjectInputStream inputStream = new ObjectInputStream(in);
            getVaccineTypeStore().setVaccineTypes((List<VaccineType>) inputStream.readObject());
        } catch (Exception e) {
        }
    }

    private void setSNSUserStore() {
        try {
            FileInputStream input = new FileInputStream("data\\SNSUser.dat"); ObjectInputStream in = new ObjectInputStream(input);
            List<SNSUser> userList = new ArrayList<>((List<SNSUser>) in.readObject());
            getSNSUserStore().setSNSUserList(userList);
        }catch (Exception e){
            e.getLocalizedMessage();
        }
    }

    private void setEmployeeStore(){
        try {
            FileInputStream input = new FileInputStream("data\\Employee.dat"); ObjectInputStream in = new ObjectInputStream(input);
            List<Employee> empList = new ArrayList<>((List<Employee>) in.readObject());
            getEmployeeStore().setEmployeeList(empList);
        }catch (Exception e){
            e.getLocalizedMessage();
        }
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

    /**
     * Gets adverse reaction store.
     *
     * @return the adverse reaction store
     */
    public AdverseReactionStore getAdverseReactionStore() {
        return adverseReactionStore;
    }

    /**
     * Gets vaccination store.
     *
     * @return the vaccination store
     */
    public VaccinationStore getVaccinationStore() {
        return vaccinationStore;
    }

    /**
     * Gets legacy data store.
     *
     * @return the legacy data store
     */
    public LegacyDataStore getLegacyDataStore() {
        return legacyDataStore;
    }

}

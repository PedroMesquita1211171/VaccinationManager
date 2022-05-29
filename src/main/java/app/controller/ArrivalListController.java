package app.controller;
import app.domain.model.Company;
import app.domain.model.SNSUser;
import app.domain.model.VaccinationCenter;
import app.domain.model.WaitingRoom;
import java.util.List;

/**
 * The type Arrival list controller.
 */
public class ArrivalListController {
    private final Company company;

    /**
     * Instantiates a new Arrival list controller.
     */
    public ArrivalListController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Instantiates a new Arrival list controller.
     *
     * @param company the company
     */
    public ArrivalListController(Company company){
        this.company = company;
    }

    /**
     * Arrival list.
     *
     * @return the list
     */
    public List<WaitingRoom> arrival() {
        return this.company.getWaitingRoomStore().getWaitingRoom();
    }

    /**
     * Get center list.
     *
     * @return the list
     */
    public List<VaccinationCenter> getCenter(){
        return this.company.getVaccinationCenterStore().getVaccinationCenterList();
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public List<SNSUser> getUsers() {
        return this.company.getSNSUserStore().getSNSUserList();
    }
}

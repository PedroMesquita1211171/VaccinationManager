package app.controller;

import app.DTO.Mappers.VaccinationCenterMapper;
import app.DTO.Mappers.WaitingRoomMapper;
import app.DTO.VaccinationCenterDTO;
import app.DTO.WaitingRoomDTO;
import app.domain.model.Company;
import app.domain.model.Vaccine;
import app.domain.model.WaitingRoom;

import java.util.List;

/**
 * The type List sns users in waiting room controller.
 */
public class ListSNSUsersInWaitingRoomController {

    private Company company;

    /**
     * Instantiates a new List sns users in waiting room controller.
     */
    public ListSNSUsersInWaitingRoomController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Instantiates a new List sns users in waiting room controller.
     *
     * @param company the company
     */
    public ListSNSUsersInWaitingRoomController(Company company){
        this.company = company;
    }

    /**
     * Gets waiting room users.
     *
     * @param vc the vc
     * @return the waiting room users
     */
    public List<WaitingRoomDTO> getWaitingRoomUsers(VaccinationCenterDTO vc) {
        return WaitingRoomMapper.toDTOList(this.company.getWaitingRoomStore().getWaitingRoomListOfAVaccinationCenter(vc));
    }

    /**
     * Gets vaccination centers.
     *
     * @return the vaccination centers
     */
    public List<VaccinationCenterDTO> getVaccinationCenters() {
        return VaccinationCenterMapper.toDTOList(this.company.getVaccinationCenterStore().getVaccinationCenters());
    }
}

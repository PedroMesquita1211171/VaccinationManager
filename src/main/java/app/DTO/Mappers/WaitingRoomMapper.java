package app.DTO.Mappers;

import app.DTO.WaitingRoomDTO;
import app.domain.model.WaitingRoom;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Waiting room mapper.
 */
public class WaitingRoomMapper {

    /**
     * To dto waiting room dto.
     *
     * @param wt the wt
     * @return the waiting room dto
     */
    public static WaitingRoomDTO toDTO(WaitingRoom wt){
        return new WaitingRoomDTO(wt.getVaccinationCenter(),wt.getSchedule(),wt.getArrivalHour());
    }

    /**
     * To entity waiting room.
     *
     * @param wtDTO the wt dto
     * @return the waiting room
     */
    public static WaitingRoom toEntity(WaitingRoomDTO wtDTO){
        return new WaitingRoom(wtDTO.getVaccinationCenter(), wtDTO.getSchedule(), wtDTO.getArrivalHour());
    }

    /**
     * To dto list list.
     *
     * @param wtList the wt list
     * @return the list
     */
    public static List<WaitingRoomDTO> toDTOList(List<WaitingRoom> wtList){
        List<WaitingRoomDTO> wtListDTO = new ArrayList<>();

        for ( WaitingRoom wt : wtList ) {
            wtListDTO.add(toDTO(wt));
        }

        return wtListDTO;
    }

    /**
     * To entity list list.
     *
     * @param wtListDTO the wt list dto
     * @return the list
     */
    public static List<WaitingRoom> toEntityList(List<WaitingRoomDTO> wtListDTO){
        List<WaitingRoom> wtList = new ArrayList<>();

        for ( WaitingRoomDTO wtDTO : wtListDTO ) {
            wtList.add(toEntity(wtDTO));
        }

        return wtList;
    }

}

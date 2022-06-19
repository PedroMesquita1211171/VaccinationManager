package app.DTO.Mappers;

import app.DTO.AdverseReactionDTO;
import app.domain.model.AdverseReaction;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Adverse reaction mapper.
 */
public class AdverseReactionMapper {
    /**
     * To dto adverse reaction dto.
     *
     * @param ar the ar
     * @return the adverse reaction dto
     */
    public static AdverseReactionDTO toDTO(AdverseReaction ar){
        return new AdverseReactionDTO(ar.getSnsu(),ar.getARText(),ar.getVc());
    }

    /**
     * To entity adverse reaction.
     *
     * @param arDTO the ar dto
     * @return the adverse reaction
     */
    public static AdverseReaction toEntity(AdverseReactionDTO arDTO){
        return new AdverseReaction(arDTO.getSnsu(), arDTO.getARText(),arDTO.getVc());
    }

    /**
     * To dto list list.
     *
     * @param arList the ar list
     * @return the list
     */
    public static List<AdverseReactionDTO> toDTOList(List<AdverseReaction> arList){
        List<AdverseReactionDTO> arDTOList = new ArrayList<>();
        for (AdverseReaction ar : arList) {
            arDTOList.add(toDTO(ar));
        }
        return arDTOList;
    }

    /**
     * To entity list list.
     *
     * @param arDTOList the ar dto list
     * @return the list
     */
    public static List<AdverseReaction> toEntityList(List<AdverseReactionDTO> arDTOList){
        List<AdverseReaction> arList = new ArrayList<>();
        for (AdverseReactionDTO arDTO : arDTOList) {
            arList.add(toEntity(arDTO));
        }
        return arList;
    }
}

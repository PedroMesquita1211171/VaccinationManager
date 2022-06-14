package app.DTO.Mappers;

import app.DTO.AdverseReactionDTO;
import app.domain.model.AdverseReaction;

import java.util.ArrayList;
import java.util.List;

public class AdverseReactionMapper {
    public static AdverseReactionDTO toDTO(AdverseReaction ar){
        return new AdverseReactionDTO(ar.getSnsu(),ar.getARText());
    }

    public static AdverseReaction toEntity(AdverseReactionDTO arDTO){
        return new AdverseReaction(arDTO.getSnsu(), arDTO.getARText());
    }

    public static List<AdverseReactionDTO> toDTOList(List<AdverseReaction> arList){
        List<AdverseReactionDTO> arDTOList = new ArrayList<>();
        for (AdverseReaction ar : arList) {
            arDTOList.add(toDTO(ar));
        }
        return arDTOList;
    }

    public static List<AdverseReaction> toEntityList(List<AdverseReactionDTO> arDTOList){
        List<AdverseReaction> arList = new ArrayList<>();
        for (AdverseReactionDTO arDTO : arDTOList) {
            arList.add(toEntity(arDTO));
        }
        return arList;
    }
}

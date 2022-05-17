package app.DTO.Mappers;

import app.DTO.SNSUserDTO;
import app.domain.model.SNSUser;

import java.util.ArrayList;
import java.util.List;

public class SNSUserMapper {

    public static SNSUserDTO toDTO(SNSUser snsu) {
        return new SNSUserDTO(snsu.getName(), snsu.getAddress(), snsu.getPhoneNumber(), snsu.getEmail(), snsu.getBirthDate(), snsu.getSNSNumber(), snsu.getCitizenCardNumber());
    }

    public static List<SNSUserDTO> toDTOList(List<SNSUser> snsus) {
        List<SNSUserDTO> snsusDTO = new ArrayList<>();
        for (SNSUser snsu : snsus) {
            snsusDTO.add(toDTO(snsu));
        }
        return snsusDTO;
    }

}

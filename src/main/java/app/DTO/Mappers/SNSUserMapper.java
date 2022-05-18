package app.DTO.Mappers;

import app.DTO.SNSUserDTO;
import app.domain.model.SNSUser;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Sns user mapper.
 *
 * @author Henrique Pinto - 1211201
 */
public class SNSUserMapper {

    /**
     * To dto sns user.
     *
     * @param snsu the snsu
     * @return the sns user dto
     */
    public static SNSUserDTO toDTO(SNSUser snsu) {
        return new SNSUserDTO(snsu.getName(), snsu.getAddress(), snsu.getPhoneNumber(), snsu.getEmail(), snsu.getBirthDate(), snsu.getSNSNumber(), snsu.getCitizenCardNumber());
    }

    /**
     * To dto list.
     *
     * @param snsus the SNS Users list
     * @return snsusDTO the SNS Users DTO list
     */
    public static List<SNSUserDTO> toDTOList(List<SNSUser> snsus) {
        List<SNSUserDTO> snsusDTO = new ArrayList<>();
        for (SNSUser snsu : snsus) {
            snsusDTO.add(toDTO(snsu));
        }
        return snsusDTO;
    }

}

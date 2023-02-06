package app.domain.model.US16;

import java.util.List;
import java.util.stream.Collectors;

public class RegistoMapper {
    public static RegistoDTO mapToDTO(Registo registo) {
        return new RegistoDTO(registo.getSnsUserNumber(),
                registo.getVaccineName(),
                registo.getDoseNumber(),
                registo.getLotNumber(),
                registo.getScheduledDateTime(),
                registo.getArrivalDateTime(),
                registo.getAdministrationDateTime(),
                registo.getLeavingDateTime());
    }

    public static Registo mapToDomain(RegistoDTO registoDTO) {
        return new Registo(registoDTO.getSnsUserNumber(),
                registoDTO.getVaccineName(),
                registoDTO.getDoseNumber(),
                registoDTO.getLotNumber(),
                registoDTO.getScheduledDateTime(),
                registoDTO.getArrivalDateTime(),
                registoDTO.getAdministrationDateTime(),
                registoDTO.getLeavingDateTime());
    }

    public static List<RegistoDTO> mapToDTO(List<Registo> registoList) {
        return registoList.stream().map(RegistoMapper::mapToDTO).collect(Collectors.toList());
    }

    public static List<Registo> mapToDomain(List<RegistoDTO> registoDTOList) {
        return registoDTOList.stream().map(RegistoMapper::mapToDomain).collect(Collectors.toList());
    }
}

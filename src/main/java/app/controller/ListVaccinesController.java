package app.controller;

import app.DTO.Mappers.VaccineMapper;
import app.DTO.VaccineDTO;
import app.domain.model.Company;

import java.util.List;

public class ListVaccinesController {

    private Company company;

    public ListVaccinesController(Company company) {
        this.company = company;
    }

    public ListVaccinesController() {
          this(App.getInstance().getCompany());
    }

    public List<VaccineDTO> getVaccines() {
        return VaccineMapper.toDTOList(this.company.getVaccineStore().getVaccineList());
    }


}

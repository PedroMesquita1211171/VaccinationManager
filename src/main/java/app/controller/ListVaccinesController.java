package app.controller;

import app.DTO.Mappers.VaccineMapper;
import app.DTO.VaccineDTO;
import app.domain.model.Company;

import java.util.List;

/**
 * The type List vaccines controller.
 */
public class ListVaccinesController {

    private Company company;

    /**
     * Instantiates a new List vaccines controller.
     *
     * @param company the company
     */
    public ListVaccinesController(Company company) {
        this.company = company;
    }

    /**
     * Instantiates a new List vaccines controller.
     */
    public ListVaccinesController() {
          this(App.getInstance().getCompany());
    }

    /**
     * Gets vaccines.
     *
     * @return the vaccines
     */
    public List<VaccineDTO> getVaccines() {
        return VaccineMapper.toDTOList(this.company.getVaccineStore().getVaccineList());
    }


}

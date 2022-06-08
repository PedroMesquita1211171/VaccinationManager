package app.controller;

import app.DTO.Mappers.VaccineMapper;
import app.DTO.Mappers.VaccineTypeMapper;
import app.DTO.VaccineDTO;
import app.DTO.VaccineTypeDTO;
import app.domain.model.Company;
import app.domain.model.Vaccine;
import app.domain.model.VaccineDependencies.AdministrationProcess;
import app.domain.model.VaccineDependencies.AgeGroup;
import app.domain.model.VaccineType;

import java.util.List;

public class SpecifyNewVaccineController {

    private Company company;
    private VaccineType vt;
    private Vaccine vac;


    public SpecifyNewVaccineController(Company company) {
        this.company = company;
    }

    public SpecifyNewVaccineController(){
        this(App.getInstance().getCompany());
    }

    public boolean createVaccine(VaccineTypeDTO vaccineTypeDTO, String brand, String lotNumber,List<AdministrationProcess> admList){

        vt = VaccineTypeMapper.toEntity(vaccineTypeDTO);
        this.vac = this.company.getVaccineStore().createVaccine(brand,lotNumber,admList,vt);

        return this.company.getVaccineStore().validateVaccine(this.vac);
    }

    public boolean saveVaccine(){
        return this.company.getVaccineStore().addVaccine(this.vac);
    }

    public List<VaccineTypeDTO> getVaccineTypes(){
        return VaccineTypeMapper.toDTOList(this.company.getVaccineTypeStore().getVaccineTypeList());
    }

    public VaccineDTO getVaccine(){
        return VaccineMapper.toDTO(this.vac);
    }


}

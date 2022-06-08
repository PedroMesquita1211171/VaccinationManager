package app.ui.console;

import app.DTO.VaccineDTO;
import app.controller.ListVaccinesController;

import java.util.List;

public class ListVaccinesUI implements Runnable{

    private ListVaccinesController ctrl;


    public ListVaccinesUI() {
       this.ctrl = new ListVaccinesController();
    }


    @Override
    public void run() {
        ListAllVaccines(ctrl.getVaccines());
    }


    public void ListAllVaccines(List<VaccineDTO> vaccines){
        for (VaccineDTO v: vaccines) {
            System.out.println(v);
        }
    }
}

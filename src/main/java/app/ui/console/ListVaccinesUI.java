package app.ui.console;

import app.DTO.VaccineDTO;
import app.controller.ListVaccinesController;

import java.util.List;

/**
 * The type List vaccines ui.
 */
public class ListVaccinesUI implements Runnable{

    private ListVaccinesController ctrl;


    /**
     * Instantiates a new List vaccines ui.
     */
    public ListVaccinesUI() {
       this.ctrl = new ListVaccinesController();
    }


    @Override
    public void run() {
        ListAllVaccines(ctrl.getVaccines());
    }


    /**
     * List all vaccines.
     *
     * @param vaccines the vaccines
     */
    public void ListAllVaccines(List<VaccineDTO> vaccines){
        for (VaccineDTO v: vaccines) {
            System.out.println(v);
        }
    }
}

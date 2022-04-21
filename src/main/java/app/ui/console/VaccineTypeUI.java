package app.ui.console;

import app.VaccineRelated.VaccineType;
import app.controller.SpecifyNewVaccineTypeController;
import app.ui.console.utils.Utils;

public class VaccineTypeUI {

    public VaccineTypeUI(String code, String designation, String whoId) {
        SpecifyNewVaccineTypeController controller = new SpecifyNewVaccineTypeController();
        controller.createVaccineType(code, designation, whoId);

        if(true){
            if(controller.saveVaccineType()) {
                System.out.println("Vaccine Type saved successfully");
            }
        }
    }

}

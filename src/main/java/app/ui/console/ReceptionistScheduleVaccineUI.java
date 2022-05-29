package app.ui.console;

import app.DTO.VaccinationCenterDTO;
import app.DTO.VaccineDTO;
import app.controller.App;
import app.controller.ReceptionistScheduleVaccineController;
import app.domain.model.SNSUser;
import app.ui.console.utils.Utils;
import app.domain.model.Company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * The type Receptionist schedule vaccine ui.
 */
public class ReceptionistScheduleVaccineUI implements Runnable{
    private final ReceptionistScheduleVaccineController ctrl;
    private final Company company;
    /**
     * The Hour format.
     */
    SimpleDateFormat hourFormat;


    /**
     * Instantiates a new Receptionist schedule vaccine ui.
     */
    public ReceptionistScheduleVaccineUI(){
        ctrl = new ReceptionistScheduleVaccineController();
        this.company = App.getInstance().getCompany();
        hourFormat = new SimpleDateFormat("HH:mm");
    }
    @Override
    public void run() {

        try{
            int snsUserNumber = Utils.readIntegerFromConsole("SNS User Number :");
            SNSUser user = this.getUser(snsUserNumber);

            System.out.println("");

            //certo
            System.out.println("############## Vaccination Centers ############## \n");
            VaccinationCenterDTO centerDTO = getVaccinationCenter();
            //

            //certo
            System.out.println("");
            System.out.println("############## Vaccines ############## \n");
            VaccineDTO vaccineDTO = getVaccine();
            //

            Date schedulingDate = Utils.readDateFromConsole("Insert the Schedule Date: (DD/MM/YYYY)");
            Date schedulingHour = hourFormat.parse(Utils.readLineFromConsole("Insert the Schedule Time: (HH:MM)"));

            Date opH = hourFormat.parse(centerDTO.getOpeningHours()) ;
            Date clH = hourFormat.parse(centerDTO.getClosingHours());
            if(!(schedulingHour.compareTo(opH) == 1 && schedulingHour.compareTo(clH)== -1)){
                throw new IllegalArgumentException("Invalid Hour, returning to main menu.\nInterrupting saving process.");
            }





            if (ctrl.createSchedule(schedulingDate,schedulingHour, user.getSNSNumber(), centerDTO.getAddress(), vaccineDTO.getName())) {
                String confirmation = Utils.readLineFromConsole("Do you want to confirm your schedule?(Type yes to confirm)");
                if(confirmation.equalsIgnoreCase("yes")){
                    if(ctrl.saveSchedule()){
                        System.out.println("Schedule saved successfully!\nReturning to main menu.\n");
                    }
                }else{
                    System.out.println("Schedule not saved!\nReturning to main menu.\n");
                }
            }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println("Invalid time");;
        }catch (IndexOutOfBoundsException e){
            System.out.println("Invalid option!\nReturning to main menu");
        }


    }

    /**
     * Check date boolean.
     *
     * @param scheduleDate the schedule date
     * @return the boolean
     */
    public boolean checkDate(Date scheduleDate) {
        Calendar systemTime = Calendar.getInstance();
        Calendar scheduling = Calendar.getInstance();

        scheduling.setTime(scheduleDate);
        systemTime.add(Calendar.MINUTE, 1440);
        if (scheduling.compareTo(systemTime) > 0) {
            System.out.println(" Authorized Date. \n");
            return true;
        }
        System.out.println("Invalid Date. \n");
        return false;
    }

    /**
     * Gets user.
     *
     * @param snsUserNumber the sns user number
     * @return the user
     */
    public SNSUser getUser(int snsUserNumber) {
        for(int i = 0; i < this.ctrl.getUserList().size(); ++i) {
            SNSUser aux = (SNSUser)this.ctrl.getUserList().get(i);
            if (Integer.parseInt(aux.getSNSNumber()) == snsUserNumber) {
                return aux;
            }
        }
        throw new IllegalArgumentException("User Not Found, please register the user first before scheduling! \n");
    }

    /**
     * Gets vaccine.
     *
     * @return the vaccine
     */
    public VaccineDTO getVaccine() {
        if (isVaccineStoreEmpty()) {
            int option;
            do {
                int contador = 0;
                for (int i = 0; i < ctrl.vaccineList().size(); i++) {
                    System.out.println(contador + " - " + ctrl.vaccineList().get(i) + "\n");
                    contador++;
                }
                option = Utils.readIntegerFromConsole("Choose a Vaccine:");
            } while (option < 0 || option > ctrl.vaccineList().size());
            return ctrl.vaccineList().get(option);
        }
        return null;
    }

    /**
     * Check same cc boolean.
     *
     * @param user the user
     * @param cC   the c c
     * @return the boolean
     */
    public boolean checkSameCC(SNSUser user,String cC) {
        for (int i = 0; i < company.getSNSUserStore().getSNSUserList().size(); i++) {
            String numberAux = company.getSNSUserStore().getSNSUserList().get(i).getCitizenCardNumber();
            if (numberAux.equals(cC)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a vaccinationCenterDTO to be able to use the object
     *
     * @return vaccinationcenterdto not null
     */
    public VaccinationCenterDTO getVaccinationCenter() {
        if (isVaccinationCenterEmpty()) {
            int option;
            do {
                int contador = 0;
                for (int i = 0; i < ctrl.vacCenterList().size(); i++) {
                    System.out.println(contador + " - " + ctrl.vacCenterList().get(i) + "\n");
                    contador++;
                }
                option = Utils.readIntegerFromConsole("Choose a Vaccination Center:");
            } while (option < 0 || option > ctrl.vacCenterList().size());
            return ctrl.vacCenterList().get(option);
        }
        return null;
    }

    /**
     * Used to check if the array is empty before starting the UI and getting user stuck into menus
     *
     * @return false for empty, true otherwise.
     */
    public boolean isVaccinationCenterEmpty() {
        if (ctrl.vacCenterList().isEmpty()) {
            System.out.println("-> INFO <- There Isn't Available Centers to Show!");
            return false;
        }
        return true;
    }

    /**
     * Used to check if the array is empty before starting the UI and getting user stuck into menus
     *
     * @return false for empty, true otherwise.
     */
    public boolean isVaccineStoreEmpty() {
        if (ctrl.vacCenterList().isEmpty()) {
            System.out.println("-> INFO <- There Aren't Available Any Vaccines At The Moment|");
            return false;
        }
        return true;
    }
}

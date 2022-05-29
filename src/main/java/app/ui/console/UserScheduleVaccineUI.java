package app.ui.console;

import app.DTO.VaccinationCenterDTO;
import app.DTO.VaccineDTO;
import app.controller.App;
import app.controller.UserScheduleVaccineController;
import app.domain.model.SNSUser;
import app.ui.console.utils.Utils;
import app.domain.model.Company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserScheduleVaccineUI implements Runnable{



    private final UserScheduleVaccineController ctrl;
    private final Company company;
    SimpleDateFormat hourFormat;


    public UserScheduleVaccineUI(){
        ctrl = new UserScheduleVaccineController();
        this.company = App.getInstance().getCompany();
        hourFormat = new SimpleDateFormat("HH:mm");
    }
    @Override
    public void run() {

        try{
            SNSUser user = ctrl.userLogin();

                        String snsUserNumber = user.getCitizenCardNumber();

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
                                        Date schedulingHour = Utils.readDateFromConsole("Insert the Schedule Time: (HH:MM)");


                        Date opH = hourFormat.parse(centerDTO.getOpeningHours()) ;
                        Date clH = hourFormat.parse(centerDTO.getClosingHours());
                        if(!(schedulingHour.compareTo(opH) == 1 && schedulingHour.compareTo(clH)== -1)){
                            throw new IllegalArgumentException("Invalid Hour, returning to main menu.\nInterrupting saving process.");
                        }




                                                    if (ctrl.createSchedule(schedulingDate,schedulingHour, user.getSNSNumber(), centerDTO.getAddress(), vaccineDTO.getName())) {
                                                        String confirmation = Utils.readLineFromConsole("Do you want to confirm your schedule?(Type yes/y to confirm)");
                                                        if(confirmation.equalsIgnoreCase("yes")||confirmation.equalsIgnoreCase("y")){
                                                            if(ctrl.saveSchedule()){
                                                                System.out.println("Schedule saved successfully!\nReturning to the main menu.\n");
                                                            }
                                                        }
                                                    }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch (ParseException e) {
                                 System.out.println("Error in Center Hour.");
                             }




                            }

    public boolean checkDate(Date scheduleDate) {
        Calendar systemTime = Calendar.getInstance();
        Calendar scheduling = Calendar.getInstance();

        scheduling.setTime(scheduleDate);
        systemTime.add(Calendar.MINUTE, 1440);
        if (scheduling.compareTo(systemTime) > 0) {
            System.out.println(" Authorized Date. \n");
            return true;
        }
        System.out.println("Inavlid Date. \n");
        return false;
    }

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

package app.ui.console;

import app.DTO.VaccinationCenterDTO;
import app.DTO.VaccineDTO;
import app.controller.App;
import app.controller.UserScheduleVaccineController;
import app.domain.model.Company;
import app.domain.model.SNSUser;
import app.ui.console.utils.Utils;

import java.util.Calendar;
import java.util.Date;

public class ScheduleVaccineUI implements Runnable{



    private final UserScheduleVaccineController ctrl;

    private final Company company;


    public ScheduleVaccineUserUI() {
        this.ctrl = new UserScheduleVaccineController();
        this.company = App.getInstance().getCompany();
    }

    public ScheduleVaccineUI(){
        ctrl = new UserScheduleVaccineController();
    }
    @Override
    public void run() {
        SNSUser user = findUser();
        if (user != null) {
            String snsUserNumber = user.getCitizenCardNumber();
            if (checkSameCC(user, snsUserNumber)) {
                System.out.println("");
                System.out.println("############## Vaccination Centers ############## \n");
                VaccinationCenterDTO centerDTO = getVaccinationCenter();
                if (centerDTO != null) {
                    System.out.println("");
                    System.out.println("############## Vaccines ############## \n");
                    VaccineDTO vaccineDTO = getVaccine();
                    if (vaccineDTO != null) {
                        if (ctrl.checkForDuplicateSchedule(vaccineDTO.getName(), snsUserNumber)) {
                            int doseNumber = Utils.readIntegerFromConsole("How Many Doses Had Before?");
                                Date schedulingDate = Utils.readDateFromConsole("Insert the Schedule Date: (DD/MM/YYYY)");
                                if (ctrl.checkScheduleDateAndCenterAndVaccine(schedulingDate, centerDTO.getAddress(), vaccineDTO.getName())) {
                                    if (ctrl.scheduleVaccineWithEntries(user.getEmail(), snsUserNumber, centerDTO.getAddress(), vaccineDTO.getName(), schedulingDate, centerDTO.getSlotDuration(), centerDTO.getMaxVaccinesPerSlot(), centerDTO.getOpeningHours(), centerDTO.getClosingHours())) {
                                        System.out.println("\n-> INFO <- All the Scheduling Information Was Sent To Your Email!");
                                        System.out.println("\n-> INFO <- Vaccine Scheduled SuccessFully! Going to Main Menu..\n");
                                    }
                                } else {
                                    if (checkDate(schedulingDate))
                                        if (ctrl.checkCenterCapacity(schedulingDate, centerDTO)) {
                                            if (ctrl(schedulingDate, vaccineDTO, user, centerDTO)) {
                                                System.out.println(("\n-> INFO <- All the Scheduling Information Was Sent To Your Email!");
                                                System.out.println("\n-> INFO <- Vaccine Scheduled SuccessFully! Going to Main Menu..\n ");
                                                for (int i = 0; i < ctrl.getScheduleList().size(); i++) {
                                                    System.out.println(ctrl.getScheduleList().get(i) + "\n");
                                                }
                                            }
                                        }
                                }
                            }

                        }
                    }
                }
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

    /**
     * Used to swipe the array and find the user with the snsUserNumber
     *
     * @return if the user is found
     */
    public SNSUser findUser() {
        return ctrl.userLogin();
    }

    /**
     * Checks if the user is scheduling only for himself
     * @param user that will schedule
     * @param citizenCardNumber final
     * @return
     */
    public boolean checkSameCC(SNSUser user,String cC) {
        for (int i = 0; i < company.getSNSUserStore().getSNSUserList().size(); i++) {
            String numberAux = company.getSNSUserStore().getSNSUserList().get(i).getCitizenCardNumber();
            if (numberAux == cC) {
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
                for (int i = 0; i < ctrl.getCenterList().size(); i++) {
                    System.out.println(contador + " - " + ctrl.getCenterList().get(i) + "\n");
                    contador++;
                }
                option = Utils.readIntegerFromConsole("Choose a Vaccination Center:");
            } while (option < 0 || option > ctrl.getCenterList().size());
            return ctrl.getCenterList().get(option);
        }
        return null;
    }

    /**
     * Used to check if the array is empty before starting the UI and getting user stuck into menus
     *
     * @return false for empty, true otherwise.
     */
    public boolean isVaccinationCenterEmpty() {
        if (ctrl.getCenterList().isEmpty()) {
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
        if (ctrl.getVaccineList().isEmpty()) {
            System.out.println("-> INFO <- There Aren't Available Any Vaccines At The Moment|");
            return false;
        }
        return true;
    }
}

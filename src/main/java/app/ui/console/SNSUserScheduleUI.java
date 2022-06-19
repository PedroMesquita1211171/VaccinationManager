package app.ui.console;

import app.DTO.SNSUserDTO;
import app.DTO.VaccinationCenterDTO;
import app.DTO.VaccineDTO;
import app.controller.ScheduleController;
import app.domain.model.ScheduleDependencies.Data;
import app.domain.model.VaccinationCenterDependencies.TimeSlot;
import app.domain.model.VaccineDependencies.AdministrationProcess;
import app.ui.console.utils.Utils;

import java.time.LocalDate;
import java.util.List;

/**
 * The type Sns user schedule ui.
 */
public class SNSUserScheduleUI implements Runnable{



    private ScheduleController ctrl;

    /**
     * Instantiates a new Sns user schedule ui.
     */
    public SNSUserScheduleUI() {
        this.ctrl = new ScheduleController();
    }

    @Override
    public void run() {

        try{

            SNSUserDTO snsu = ctrl.getSNSUser();

            VaccinationCenterDTO vc = askVaccinationCenter();

            VaccineDTO vaccine = askVaccine();

            AdministrationProcess ap = vaccine.getAdministrationProcess(snsu.getAge());

            Data date = askDate();

            TimeSlot timeSlot = askTimeSlot(vc, date);

            if(ctrl.createSchedule(snsu,vc,vaccine,date,timeSlot,ap)){

                System.out.println(ctrl.getSchedule());

                String opt = askOption();
                if(opt.equalsIgnoreCase("y")||opt.equalsIgnoreCase("yes")){
                    if(ctrl.saveSchedule()){
                        System.out.println("\nSchedule saved successfully\n");
                    }else{
                        System.out.println("\nSchedule not saved\n");
                    }
                }else {
                    System.out.println("\nSchedule not saved\n");
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }




    }

    private String askOption() {
        String opt = Utils.readLineFromConsole("Do you want to save the schedule? (y/n)");
        if(opt.equalsIgnoreCase("y")||opt.equalsIgnoreCase("yes")||opt.equalsIgnoreCase("n")||opt.equalsIgnoreCase("no")){
            return opt;
        }
        return askOption();
    }

    private TimeSlot askTimeSlot(VaccinationCenterDTO vc, Data date) {
        List<TimeSlot> timeSlotList = vc.getTimeSlots();
        timeSlotList.removeIf(t -> !ctrl.slotAvailable(date, t, vc));
        int selected = Utils.showAndSelectIndex(timeSlotList, "Select a time slot");

        if(selected > -1 && selected < timeSlotList.size()) {
            return timeSlotList.get(selected);
        }

        throw new IllegalArgumentException("Invalid index");
    }

    private Data askDate() {
        int year, month, day;

         try{
             year = Utils.readIntegerFromConsole("Enter the year");
             if(year < LocalDate.now().getYear()) {
                 System.out.println("\nInvalid year\n");
                 return askDate();
             }
             month = Utils.readIntegerFromConsole("Enter the month");
             if(month < 1 || month > 12) {
                 System.out.println("\nInvalid month\n");
                 return askDate();
             }
             day = Utils.readIntegerFromConsole("Enter the day");
             if(day < 1 || day > 31) {
                 System.out.println("\nInvalid day\n");
                 return askDate();
             }
         }catch (NumberFormatException e){
             System.out.println("Invalid date");
             return askDate();
         }

        return new Data(year,month,day);
    }

    private VaccineDTO askVaccine() {
        List<VaccineDTO> vaccineList = ctrl.getVaccines();
        int selected = Utils.showAndSelectIndex(vaccineList, "Select a vaccine");
        if(selected > -1 && selected < vaccineList.size()) {
            return vaccineList.get(selected);
        }
        throw new IllegalArgumentException("Invalid index");
    }

    private VaccinationCenterDTO askVaccinationCenter() {
        List<VaccinationCenterDTO> vcList = ctrl.getVaccinationCenters();
        int selected = Utils.showAndSelectIndex(vcList, "Select a vaccination center");
        if(selected > -1 && selected < vcList.size()) {
            return vcList.get(selected);
        }
        throw new IllegalArgumentException("Invalid index");
    }
}

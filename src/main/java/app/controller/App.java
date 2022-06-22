package app.controller;

import app.domain.model.*;
import app.domain.model.VaccinationCenterDependencies.Tempo;
import app.domain.model.VaccineDependencies.AdministrationProcess;
import app.domain.model.VaccineDependencies.AgeGroup;
import app.domain.shared.Constants;
import app.ui.console.utils.Generators;
import app.ui.gui.Utils.Scheduler;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The type App.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class App {

    private Company company;
    private AuthFacade authFacade;

    private App()
    {
        Properties props = getProperties();
        this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        this.authFacade = this.company.getAuthFacade();
        bootstrap();
    }

    /**
     * Gets company.
     *
     * @return the company
     */
    public Company getCompany()
    {
        return this.company;
    }


    /**
     * Gets current user session.
     *
     * @return the current user session
     */
    public UserSession getCurrentUserSession()
    {
        return this.authFacade.getCurrentUserSession();
    }

    /**
     * Do log in boolean.
     *
     * @param email the email
     * @param pwd   the pwd
     * @return the boolean
     */
    public boolean doLogin(String email, String pwd)
    {
        return this.authFacade.doLogin(email,pwd).isLoggedIn();
    }

    /**
     * Do logout.
     */
    public void doLogout()
    {
        this.authFacade.doLogout();
    }

    private Properties getProperties()
    {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "DGS/SNS");


        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        }
        catch(IOException ignored)
        {

        }
        return props;
    }


    private void bootstrap()
    {

        //bootstrap of an example date(18 yo)
        Date date = null;
        String birthDay = "10-02-2003";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = sdf.parse(birthDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //Roles to be bootstrapped
        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_RECEPTIONIST,Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserRole(Constants.ROLE_NURSE,Constants.ROLE_NURSE);
        this.authFacade.addUserRole(Constants.ROLE_CENTER_COORDINATOR,Constants.ROLE_CENTER_COORDINATOR);
        this.authFacade.addUserRole(Constants.ROLE_SNSUSER,Constants.ROLE_SNSUSER);

        //Users to be bootstrapped(examples)
        this.authFacade.addUserWithRole("Main Administrator", "admin@lei.sem2.pt", "123456",Constants.ROLE_ADMIN);
                   //add a receptionist
        this.authFacade.addUserWithRole("Main Receptionist", "recep@lei.sem2.pt", "123456",Constants.ROLE_RECEPTIONIST);
        this.company.getEmployeeStore().addEmployee(new Employee("John Doe", "recep@lei.sem2.pt", "Example Address Recep", "910022449","11223344",Constants.ROLE_RECEPTIONIST, Generators.generateEmployeeID()));
                  //add a Center Coordinator
        this.authFacade.addUserWithRole("Main Center Coordinator", "ccord@lei.sem2.pt", "123456",Constants.ROLE_CENTER_COORDINATOR);
        Employee Ccord = new Employee("Jane Doe", "ccord@lei.sem2.pt", "Example Address CCord", "910022450","11223345",Constants.ROLE_CENTER_COORDINATOR, Generators.generateEmployeeID());
        this.company.getEmployeeStore().addEmployee(Ccord);
                  //add a SNS User
        this.authFacade.addUserWithRole("Main SNS User", "snsu@lei.sem2.pt", "123456",Constants.ROLE_SNSUSER);
        this.company.getSNSUserStore().addSNSUser(new SNSUser("Example", "Example Address", "Male", "999888333", "snsu@lei.sem2.pt", date, "111333555", "14161810"));
                 //add a nurse
        this.authFacade.addUserWithRole("Main Nurse","nurse@lei.sem2.pt","123456",Constants.ROLE_NURSE);
        this.company.getEmployeeStore().addEmployee(new Employee("Jessica Doe", "nurse@lei.sem2.pt", "Example Address Nurse", "910022451","11223346",Constants.ROLE_NURSE, Generators.generateEmployeeID()));
          //add a Vaccine Type and a vaccine
        VaccineType vt = new VaccineType("15543","Covid-19","Toxoid");
        this.company.getVaccineTypeStore().addVaccineType(vt);
        List<AdministrationProcess> processes = new ArrayList<>();
        processes.add(new AdministrationProcess(new AgeGroup(13,16),2,30.0,15));
        processes.add(new AdministrationProcess(new AgeGroup(17,25),2,40.5,15));
        this.company.getVaccineStore().addVaccine(new Vaccine("Pfizer", "123321",processes,vt));
           //add a Vaccination Center
        this.company.getVaccinationCenterStore().addVaccinationCenter(new VaccinationCenter("Example Center", "Example Address", "centerExample@lei.sem2.pt","992233445","233666777","https://www.google.com/?gws_rd=ssl",new Tempo(8,30),new Tempo(21,30),30,2,Ccord));




    }



    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static App getInstance()
    {
        if(singleton == null)
        {
            synchronized(App.class)
            {
                singleton = new App();
            }
        }
        return singleton;
    }

    public String getTimerHours(){
        return this.getProperties().getProperty(Constants.PARAMS_REPORT_HOUR);
    }
}

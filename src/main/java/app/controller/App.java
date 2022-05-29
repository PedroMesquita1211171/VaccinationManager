package app.controller;

import app.domain.model.Company;
import app.domain.model.SNSUser;
import app.domain.model.VaccinationCenter;
import app.domain.model.Vaccine;
import app.domain.shared.Constants;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
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

    public Company getCompany()
    {
        return this.company;
    }


    public UserSession getCurrentUserSession()
    {
        return this.authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String pwd)
    {
        return this.authFacade.doLogin(email,pwd).isLoggedIn();
    }

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
        catch(IOException ex)
        {

        }
        return props;
    }


    private void bootstrap()
    {
        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_RECEPTIONIST,Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserRole(Constants.ROLE_NURSE,Constants.ROLE_NURSE);
        this.authFacade.addUserRole(Constants.ROLE_CENTER_CORDINATOR,Constants.ROLE_CENTER_CORDINATOR);
        this.authFacade.addUserRole(Constants.ROLE_SNSUSER,Constants.ROLE_SNSUSER);

        this.authFacade.addUserWithRole("Main Administrator", "admin@lei.sem2.pt", "123456",Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("Main Receptionist","ola@gmail.com","123456",Constants.ROLE_RECEPTIONIST);
        //register sns user
        this.authFacade.addUserWithRole("Pedro","pedro@gmail.com","123456",Constants.ROLE_SNSUSER);
        this.company.getSNSUserStore().getSNSUserList().add(new SNSUser("Pedro","Rua x","Male","999999999","pedro@gmail.com",Constants.date,"123456789","10102020"));
        //register center
        this.company.getVaccinationCenterStore().getVaccinationCenterList().add(new VaccinationCenter("rua 1","vaccenter1@gmail.com","999999999","111111111","http://www.example.com/index.html","08:00","22:00",10,10,"José"));
        this.company.getVaccinationCenterStore().getVaccinationCenterList().add(new VaccinationCenter("rua 2","vaccenter2@gmail.com","911111111","222222222","http://www.example.com/index.html","09:00","21:00",11,11,"João","Norte","É soft :("));
        //register vaccine
        this.company.getVaccineStore().getVaccineList().add(new Vaccine("Test",1,"Testing",1,1,1,1));
    }

    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;
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
}

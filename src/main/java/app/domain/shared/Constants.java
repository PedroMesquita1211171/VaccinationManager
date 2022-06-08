package app.domain.shared;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Constants {
    public static final String ROLE_ADMIN = "ADMINISTRATOR";
    public static final String ROLE_RECEPTIONIST = "RECEPTIONIST";
    public static final String ROLE_NURSE = "NURSE";
    public static final String ROLE_CENTER_COORDINATOR = "CENTER_COORDINATOR";
    public static final String ROLE_SNSUSER = "SNSUSER";

    public final static String ARS_BY_DEFAULT = "Undefined";
    public final static String AGES_BY_DEFAULT = "Undefined";

    public static final String GENDER_BY_DEFAULT = "Other";

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static Date date;

    static {
        try {
            date =sdf.parse("23/02/2000");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public static SimpleDateFormat sdf2 = new SimpleDateFormat("HH:MM");
    public static Date hour;

    static {
        try {
            hour =sdf2.parse("11:00");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String PARAMS_FILENAME = "config.properties";
    public static final String PARAMS_COMPANY_DESIGNATION = "Company.Designation";
}

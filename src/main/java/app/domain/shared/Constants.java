package app.domain.shared;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Constants.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Constants {
    /**
     * The constant ROLE_ADMIN.
     */
    public static final String ROLE_ADMIN = "ADMINISTRATOR";
    /**
     * The constant ROLE_RECEPTIONIST.
     */
    public static final String ROLE_RECEPTIONIST = "RECEPTIONIST";
    /**
     * The constant ROLE_NURSE.
     */
    public static final String ROLE_NURSE = "NURSE";
    /**
     * The constant ROLE_CENTER_COORDINATOR.
     */
    public static final String ROLE_CENTER_COORDINATOR = "CENTER_COORDINATOR";
    /**
     * The constant ROLE_SNSUSER.
     */
    public static final String ROLE_SNSUSER = "SNSUSER";

    /**
     * The constant ARS_BY_DEFAULT.
     */
    public final static String ARS_BY_DEFAULT = "Undefined";
    /**
     * The constant AGES_BY_DEFAULT.
     */
    public final static String AGES_BY_DEFAULT = "Undefined";

    /**
     * The constant GENDER_BY_DEFAULT.
     */
    public static final String GENDER_BY_DEFAULT = "Other";

    /**
     * The constant sdf.
     */
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * The constant date.
     */
    public static Date date;

    static {
        try {
            date =sdf.parse("23/02/2000");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * The constant sdf2.
     */
    public static SimpleDateFormat sdf2 = new SimpleDateFormat("HH:MM");
    /**
     * The constant hour.
     */
    public static Date hour;

    static {
        try {
            hour =sdf2.parse("11:00");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * The constant PARAMS_FILENAME.
     */
    public static final String PARAMS_FILENAME = "config.properties";
    /**
     * The constant PARAMS_COMPANY_DESIGNATION.
     */
    public static final String PARAMS_COMPANY_DESIGNATION = "Company.Designation";
}

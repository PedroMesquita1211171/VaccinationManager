package app.domain.model;

import app.domain.shared.Constants;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

/**
 * The type Vaccination center.
 */
public class VaccinationCenter {
    private String address;
    private String emailAddress;
    private String phoneNumber;
    private String faxNumber;
    private String websiteAddress;
    private String openingHours;
    private String closingHours;
    private int slotDuration;
    private int maxVaccines;
    private String coordinator;
    private String ages;
    private String ars;
    private String typeOfCenter;



    /**
     * Instanciates a new Vaccination Center object
     *
     * @param address        VaccinationCenter's address
     * @param emailAddress   VaccinationCenter's email address
     * @param phoneNumber    VaccinationCenter's phone number
     * @param faxNumber      VaccinationCenter's fax number
     * @param websiteAddress VaccinationCenter's website adress
     * @param openingHours   VaccineCenter's opening hours
     * @param closingHours   VaccinationCenter's closing hours
     * @param slotDuration   VaccinationCenter's slot duration
     * @param maxVaccines    VaccinationCenter's max vaccines
     * @param coordinator    VaccinationCenter's coordinator
     */
    public VaccinationCenter(String address, String emailAddress, String phoneNumber, String faxNumber, String websiteAddress, String openingHours, String closingHours, int slotDuration, int maxVaccines, String coordinator) {
        checkAddress(address);
        checkEmailAddress(emailAddress);
        checkPhoneNumber(phoneNumber);
        checkFaxNumber(faxNumber);
        checkWebsiteAddress(websiteAddress);
        checkOpeningHours(openingHours);
        checkClosingHours(closingHours);
        checkSlotDuration(slotDuration);
        checkMaxVaccines(maxVaccines);
        checkCoordinator(coordinator);

        this.address = address;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.websiteAddress = websiteAddress;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.slotDuration = slotDuration;
        this.maxVaccines = maxVaccines;
        this.coordinator = coordinator;
        this.ages = Constants.AGES_BY_DEFAULT;
        this.ars = Constants.ARS_BY_DEFAULT;
        this.typeOfCenter = "Mass Community Vaccination Center";
    }

    /**
     * Instantiates a new Vaccination center.
     *
     * @param address        the address
     * @param emailAddress   the email address
     * @param phoneNumber    the phone number
     * @param faxNumber      the fax number
     * @param websiteAddress the website address
     * @param openingHours   the opening hours
     * @param closingHours   the closing hours
     * @param slotDuration   the slot duration
     * @param maxVaccines    the max vaccines
     * @param coordinator    the coordinator
     * @param ages           the ages
     * @param ars            the ars
     */
    public VaccinationCenter(String address, String emailAddress, String phoneNumber, String faxNumber, String websiteAddress, String openingHours, String closingHours, int slotDuration, int maxVaccines, String coordinator, String ages, String ars) {
        checkAddress(address);
        checkEmailAddress(emailAddress);
        checkPhoneNumber(phoneNumber);
        checkFaxNumber(faxNumber);
        checkWebsiteAddress(websiteAddress);
        checkOpeningHours(openingHours);
        checkClosingHours(closingHours);
        checkSlotDuration(slotDuration);
        checkMaxVaccines(maxVaccines);
        checkCoordinator(coordinator);
        checkAges(ages);
        checkArs(ars);

        this.address = address;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.websiteAddress = websiteAddress;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.slotDuration = slotDuration;
        this.maxVaccines = maxVaccines;
        this.coordinator = coordinator;
        this.ages = ages;
        this.ars = ars;
        this.typeOfCenter = "Healthcare center";
    }

    /**
     * Checks if VaccinationCenter parameters are valid.
     */
    private void checkAddress(String address) {
        if (address == null ||address.isEmpty())
            throw new IllegalArgumentException("Address can't be null or empty!");
        if (address.length() > 50)
            throw new IllegalArgumentException("Address can't have more than 50 characters!");
        if (address.length()<3)
            throw new IllegalArgumentException("Address can´t have less than 3 characters!");
    }

    private void checkEmailAddress(String emailAddress) {
        if (emailAddress == null || emailAddress.isEmpty())
            throw new IllegalArgumentException("Email address can't be null or empty!");
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (!pattern.matcher(emailAddress).matches()) {
            throw new IllegalArgumentException("Email Is Not Valid!");

        }
    }

    private void checkPhoneNumber(String phoneNumber) {
        if (phoneNumber == null||phoneNumber.isEmpty())
            throw new IllegalArgumentException("Phone number can't be null or empty!");
        if(phoneNumber.length()!=9)
            throw new IllegalArgumentException("Phone number has to have 9 numbers!");
    }
    private void checkFaxNumber(String faxNumber){
        if (faxNumber== null || faxNumber.isEmpty())
            throw new IllegalArgumentException("Fax number can't be null or empty!");
        if (faxNumber.length()!=9)
            throw new IllegalArgumentException("Fax number has to have 9 numbers!");
    }
    private void checkWebsiteAddress(String websiteAddress) {
        if (websiteAddress== null|| websiteAddress.isEmpty())
            throw new IllegalArgumentException("Website address can't be null or empty!");
        try {
            URL u = new URL(websiteAddress);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Website address is invalid!");
        }
    }
    private void checkOpeningHours(String openingHours){
        if (openingHours== null|| openingHours.isEmpty())
            throw new IllegalArgumentException("Opening Hours can't be null or empty");
        if (openingHours.length() != 5)
            throw new IllegalArgumentException("Invalid format for opening hours! Try XX:XX.");
    }
    private void checkClosingHours(String closingHours){
        if (closingHours== null|| closingHours.isEmpty())
            throw new IllegalArgumentException("Closing hours can't be null or empty");
        if (closingHours.length() != 5)
            throw new IllegalArgumentException("Invalid format for closing hours! Try XX:XX.");
    }
    private void checkSlotDuration (int slotDuration){
        if (slotDuration==0)
            throw new IllegalArgumentException("Slot duration cant be 0!");
        if (slotDuration<0)
            throw new IllegalArgumentException("Slot duration cant be negative!");
    }
    private void checkMaxVaccines(int maxVaccines){
        if (maxVaccines==0)
            throw new IllegalArgumentException("Max vaccines cant be 0!");
        if (maxVaccines<0)
            throw new IllegalArgumentException("Max vaccines cant be negative!");
    }
    private void checkCoordinator(String coordinator){
        if (coordinator==null|| coordinator.isEmpty())
            throw new IllegalArgumentException("Coordinator can't be null or empty");
    }
    private void checkAges(String ages){
        if(ages==null|| ages.isEmpty())
            throw new IllegalArgumentException("AGES can't be null or empty");
    }
    private void checkArs(String ars) {
        if (ars == null || ars.isEmpty())
            throw new IllegalArgumentException("ARS can't be null or empty");
    }
    /**
     *Returns the Vaccination Center object as a String
     * @return Vaccination center as a String
     */

    @Override
    public String toString() {
        return "\n\nAddress: " + address + "\n" +
                "Email: " + emailAddress + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Fax Number: " + faxNumber + "\n" +
                "Website address: " + websiteAddress + "\n" +
                "Opening hours: " + openingHours + "\n" +
                "Closing hours: " + closingHours + "\n" +
                "Slot duration: " + slotDuration + "\n" +
                "Max vaccines: " + maxVaccines + "\n" +
                "Coordinator: " + coordinator + "\n" +
                "AGES: " + ages + "\n" +
                "ARS: " + ars + "\n" +
                "Type of center: " + typeOfCenter + "\n\n";

    }

    /**
     * Gets Vaccination Center fax number.
     *
     * @return the fax number
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Gets Vaccination Center email.
     *
     * @return the email
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Gets Vaccination Center address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets Vaccination Center phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets Vaccination Center website address.
     *
     * @return the website address
     */
    public String getWebsiteAddress() {
        return websiteAddress;
    }

    /**
     * Gets Vaccination Center opening hours.
     *
     * @return the opening hours
     */
    public String getOpeningHours() {
        return openingHours;
    }

    /**
     * Gets Vaccination Center closing hours.
     *
     * @return the closing hours
     */
    public String getClosingHours() {
        return closingHours;
    }

    /**
     * Gets Vaccination Center slot duration.
     *
     * @return the slot duration
     */
    public int getSlotDuration() {
        return slotDuration;
    }

    /**
     * Gets Vaccination Center max vaccines.
     *
     * @return the max vaccines
     */
    public int getMaxVaccines() {
        return maxVaccines;
    }

    /**
     * Gets Vaccination Center coordinator.
     *
     * @return the coordinator
     */
    public String getCoordinator() {
        return coordinator;
    }

    /**
     * Get ages string.
     *
     * @return the string
     */
    public String getAges(){return ages;}

    /**
     * Get ars string.
     *
     * @return the string
     */
    public String getArs(){return ars;}

    /**
     * Get type of center string.
     *
     * @return the string
     */
    public String getTypeOfCenter(){return typeOfCenter;}



}

package app.domain.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

public class VaccineCenter {
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

    /**
     * Instanciates a new VaccineCenter object
     *
     * @param emailAddress   VaccineCenter's email address
     * @param address        VaccineCenter's address
     * @param phoneNumber    VaccineCenter's phone number
     * @param faxNumber      VaccineCenter's fax number
     * @param websiteAddress VaccineCenter's website adress
     * @param openingHours   VaccineCenter's opening hours
     * @param closingHours   VaccineCenter's closing hours
     * @param slotDuration   VaccineCenter's slot duration
     * @param maxVaccines    VaccineCenter's max vaccines
     * @param coordinator    VaccineCenter's coordinator
     */
    public VaccineCenter(String address, String emailAddress, String phoneNumber, String faxNumber, String websiteAddress, String openingHours, String closingHours, int slotDuration, int maxVaccines, String coordinator) {
        checkAdress(address);
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
    }

    /**
     * Checks if VaccineCenter parameters are valid.
     */
    private void checkAdress(String address) {
        if (address == null)
            throw new IllegalArgumentException("Address can't be null!");
        if (address.isEmpty())
            throw new IllegalArgumentException("Address can´t be empty!");
        if (address.length() > 50)
            throw new IllegalArgumentException("Address Can't Have More Than 50 Characters");
    }

    private void checkEmailAddress(String emailAddress) {
        if (emailAddress == null || emailAddress.isEmpty())
            throw new IllegalArgumentException("Email address can't be null or empty!");
        if (emailAddress.length() > 320)
            throw new IllegalArgumentException("Email address can't have more than 320 characters!");
        if (emailAddress.length() < 3)
            throw new IllegalArgumentException("Email address can't have less than 3 characters!");
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (!pattern.matcher(emailAddress).matches()) {
            throw new IllegalArgumentException("Email Is Not Valid!");

        }
    }

    private void checkPhoneNumber(String phoneNumber) {
        if (phoneNumber == null)
            throw new IllegalArgumentException("Phone number can't be null!");
        if (phoneNumber.isEmpty())
            throw new IllegalArgumentException("Phone number can't be empty!");
        if(phoneNumber.length()<9)
            throw new IllegalArgumentException("Phone number has to have 9 numbers!");
    }
    private void checkFaxNumber(String faxNumber){
        if (faxNumber== null || faxNumber.isEmpty())
            throw new IllegalArgumentException("Fax number can't be null or empty!");
        if (faxNumber.length()<9)
            throw new IllegalArgumentException("Fax number has to have 9 numbers!");
    }
    private void checkWebsiteAddress(String websiteAddress) {
        if (websiteAddress== null|| websiteAddress.isEmpty())
            throw new IllegalArgumentException("Website address can't be null or empty");
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
            throw new IllegalArgumentException("Invalid opening hours!");
    }
    private void checkClosingHours(String closingHours){
        if (closingHours== null|| closingHours.isEmpty())
            throw new IllegalArgumentException("Closing hours can't be null or empty");
        if (closingHours.length() != 5)
            throw new IllegalArgumentException("Invalid closing hours!");
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
    /**
     *Returns the Vaccine Center object as a String
     * @return Vaccinecenter as a String
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
                "Coordinator: " + coordinator + "\n\n";

    }

    /**
     * Gets Vaccine Center fax number.
     *
     * @return the fax Nnumber
     */

    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Gets Vaccine Center email.
     *
     * @return the email
     */

    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Gets Vaccine Center address.
     *
     * @return the address
     */

    public String getAddress() {
        return address;
    }

    /**
     * Gets Vaccine Center phone number.
     *
     * @return the phone number
     */

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets Vaccine Center website address.
     *
     * @return the website address
     */

    public String getWebsiteAddress() {
        return websiteAddress;
    }

    /**
     * Gets Vaccine Center opening hours.
     *
     * @return the opening hours
     */

    public String getOpeningHours() {
        return openingHours;
    }

    /**
     * Gets Vaccine Center closing hours.
     *
     * @return the closing hours
     */

    public String getClosingHours() {
        return closingHours;
    }

    /**
     * Gets Vaccine Center slot duration.
     *
     * @return the slot duration
     */

    public int getSlotDuration() {
        return slotDuration;
    }

    /**
     * Gets Vaccine Center max vaccines.
     *
     * @return the max vaccines
     */

    public int getMaxVaccines() {
        return maxVaccines;
    }

    /**
     * Gets Vaccine Center coordinator.
     *
     * @return the coordinator
     */

    public String getCoordinator() {
        return coordinator;
    }



}

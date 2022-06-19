package app.domain.model;

import app.domain.model.VaccinationCenterDependencies.Tempo;
import app.domain.model.VaccinationCenterDependencies.TimeSlot;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * The type Vaccination center.
 */
public class VaccinationCenter implements Serializable {

    private String name;
    private String address;
    private String emailAddress;
    private String phoneNumber;
    private String faxNumber;
    private String websiteAddress;
    private Tempo openingHours;
    private Tempo closingHours;
    private int slotDuration;
    private int maxVaccines;
    private Employee coordinator;
    private String ages;
    private String ars;
    private String typeOfCenter;
    private List<TimeSlot> timeSlots;
    private String region;

    /**
     * Instantiates a new Vaccination center.
     *
     * @param name           the name
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
     * @param region         the region
     */
    public VaccinationCenter(String name, String address, String emailAddress, String phoneNumber, String faxNumber, String websiteAddress, Tempo openingHours, Tempo closingHours, int slotDuration, int maxVaccines, Employee coordinator, String ages, String ars, String region) {
        checkName(name);
        checkAddress(address);
        checkEmailAddress(emailAddress);
        checkPhoneNumber(phoneNumber);
        checkFaxNumber(faxNumber);
        checkWebsiteAddress(websiteAddress);
        checkOpeningHours(openingHours);
        checkClosingHours(closingHours);
        checkSlotDuration(slotDuration);
        checkCoordinator(coordinator);
        checkAges(ages);
        checkArs(ars);
        checkRegion(region);
        checkMaxVaccines(maxVaccines);
        //pode ter em comum?
        this.name = name; //sim
        this.address = address; //nao
        this.emailAddress = emailAddress; //nao
        this.phoneNumber = phoneNumber; //nao
        this.faxNumber = faxNumber; //nao
        this.websiteAddress = websiteAddress; //nao
        this.openingHours = openingHours; //sim
        this.closingHours = closingHours; //sim
        this.slotDuration = slotDuration; //sim
        this.maxVaccines = maxVaccines; //sim
        this.coordinator = coordinator; //nao
        this.ages = ages; //sim
        this.ars = ars; //sim
        this.typeOfCenter = "HealthCare Center";
        this.region = region; //nao
        this.timeSlots = setTimeSlots(openingHours, closingHours, slotDuration);
    }

    /**
     * Instantiates a new Vaccination center.
     *
     * @param name           the name
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
     */
    public VaccinationCenter(String name, String address, String emailAddress, String phoneNumber, String faxNumber, String websiteAddress, Tempo openingHours, Tempo closingHours, int slotDuration, int maxVaccines, Employee coordinator) {
        checkName(name);
        checkAddress(address);
        checkEmailAddress(emailAddress);
        checkPhoneNumber(phoneNumber);
        checkFaxNumber(faxNumber);
        checkWebsiteAddress(websiteAddress);
        checkOpeningHours(openingHours);
        checkClosingHours(closingHours);
        checkSlotDuration(slotDuration);
        checkCoordinator(coordinator);
        checkMaxVaccines(maxVaccines);
        this.name = name; //sim
        this.address = address; //nao
        this.emailAddress = emailAddress; //nao
        this.phoneNumber = phoneNumber; //nao
        this.faxNumber = faxNumber; //nao
        this.websiteAddress = websiteAddress; //nao
        this.openingHours = openingHours; //sim
        this.closingHours = closingHours; //sim
        this.slotDuration = slotDuration; //sim
        this.maxVaccines = maxVaccines; //sim
        this.coordinator = coordinator; //nao
        this.ages = "Undefined";
        this.ars = "Undefined";
        this.typeOfCenter = "Mass Community Vaccination Center";
        this.region = "Undefined";
        this.timeSlots = setTimeSlots(openingHours, closingHours, slotDuration);
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets email address.
     *
     * @param emailAddress the email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets fax number.
     *
     * @return the fax number
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Sets fax number.
     *
     * @param faxNumber the fax number
     */
    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    /**
     * Gets website address.
     *
     * @return the website address
     */
    public String getWebsiteAddress() {
        return websiteAddress;
    }

    /**
     * Sets website address.
     *
     * @param websiteAddress the website address
     */
    public void setWebsiteAddress(String websiteAddress) {
        this.websiteAddress = websiteAddress;
    }

    /**
     * Gets opening hours.
     *
     * @return the opening hours
     */
    public Tempo getOpeningHours() {
        return openingHours;
    }

    /**
     * Sets opening hours.
     *
     * @param openingHours the opening hours
     */
    public void setOpeningHours(Tempo openingHours) {
        this.openingHours = openingHours;
    }

    /**
     * Gets closing hours.
     *
     * @return the closing hours
     */
    public Tempo getClosingHours() {
        return closingHours;
    }

    /**
     * Sets closing hours.
     *
     * @param closingHours the closing hours
     */
    public void setClosingHours(Tempo closingHours) {
        this.closingHours = closingHours;
    }

    /**
     * Gets slot duration.
     *
     * @return the slot duration
     */
    public int getSlotDuration() {
        return slotDuration;
    }

    /**
     * Sets slot duration.
     *
     * @param slotDuration the slot duration
     */
    public void setSlotDuration(int slotDuration) {
        this.slotDuration = slotDuration;
    }

    /**
     * Gets max vaccines.
     *
     * @return the max vaccines
     */
    public int getMaxVaccines() {
        return maxVaccines;
    }

    /**
     * Sets max vaccines.
     *
     * @param maxVaccines the max vaccines
     */
    public void setMaxVaccines(int maxVaccines) {
        this.maxVaccines = maxVaccines;
    }

    /**
     * Gets coordinator.
     *
     * @return the coordinator
     */
    public Employee getCoordinator() {
        return coordinator;
    }

    /**
     * Sets coordinator.
     *
     * @param coordinator the coordinator
     */
    public void setCoordinator(Employee coordinator) {
        this.coordinator = coordinator;
    }

    /**
     * Gets ages.
     *
     * @return the ages
     */
    public String getAges() {
        return ages;
    }

    /**
     * Sets ages.
     *
     * @param ages the ages
     */
    public void setAges(String ages) {
        this.ages = ages;
    }

    /**
     * Gets ars.
     *
     * @return the ars
     */
    public String getArs() {
        return ars;
    }

    /**
     * Sets ars.
     *
     * @param ars the ars
     */
    public void setArs(String ars) {
        this.ars = ars;
    }

    /**
     * Gets type of center.
     *
     * @return the type of center
     */
    public String getTypeOfCenter() {
        return typeOfCenter;
    }

    /**
     * Sets type of center.
     *
     * @param typeOfCenter the type of center
     */
    public void setTypeOfCenter(String typeOfCenter) {
        this.typeOfCenter = typeOfCenter;
    }

    /**
     * Gets time slots.
     *
     * @return the time slots
     */
    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    /**
     * Sets time slots.
     *
     * @param timeSlots the time slots
     */
    public void setTimeSlots(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    /**
     * Gets region.
     *
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets region.
     *
     * @param region the region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Sets time slots.
     *
     * @param openingHours the opening hours
     * @param closingHours the closing hours
     * @param slotDuration the slot duration
     * @return the time slots
     */
    public List<TimeSlot> setTimeSlots(Tempo openingHours, Tempo closingHours, int slotDuration) {
        List<TimeSlot> timeSlots = new ArrayList<>();
        //inicia ambos os tempos como cópia do objeto opening hours
        Tempo inicioSlot = new Tempo(openingHours);
        Tempo fimSlot = new Tempo(inicioSlot);
        //incrementa o tempo inicial com o slot duration
        fimSlot.somaMinutos(slotDuration);

        timeSlots.add(new TimeSlot(new Tempo(inicioSlot), new Tempo(fimSlot)));

        while (inicioSlot.compareTo(closingHours) <= 0) {


            inicioSlot.somaMinutos(slotDuration);
            fimSlot.somaMinutos(slotDuration);

            if (inicioSlot.compareTo(closingHours) <= 0 && fimSlot.compareTo(closingHours) <= 0) {
                timeSlots.add(new TimeSlot(new Tempo(inicioSlot), new Tempo(fimSlot)));
            }

        }

        return timeSlots;
    }

    private void checkName (String name){
        if (name==null||name.isEmpty())
            throw new IllegalArgumentException("Name can't be null or empty!");
        if (name.length()<3 )
            throw new IllegalArgumentException("Name can't have less than 3 characters");
        if (name.length()> 50)
            throw new IllegalArgumentException("Name can't have more than 50 characters!");
    }

    private void checkAddress(String address) {
        if (address == null || address.isEmpty())
            throw new IllegalArgumentException("Address can't be null or empty!");
        if (address.length() > 50)
            throw new IllegalArgumentException("Address can't have more than 50 characters!");
        if (address.length() < 3)
            throw new IllegalArgumentException("Address can't have less than 3 characters!");
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
        if(!(phoneNumber.charAt(0) == '9'))
            throw new IllegalArgumentException("Phone number has to start with a 9!");
    }

    private void checkFaxNumber(String faxNumber){
        if (faxNumber== null || faxNumber.isEmpty())
            throw new IllegalArgumentException("Fax number can't be null or empty!");
        if (faxNumber.length()!=9 && faxNumber.charAt(0)!='2')
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

    private void checkOpeningHours(Tempo openingHours){
        if(openingHours.equals(null))
            throw new IllegalArgumentException("Opening Hours can't be null or empty!");
    }

    private void checkClosingHours(Tempo closingHours){
        if(closingHours.equals(null))
            throw new IllegalArgumentException("Closing Hours can't be null or empty!");
    }

    private void checkSlotDuration(int slotDuration){
        if(slotDuration<0||slotDuration>60) throw new IllegalArgumentException("Slot duration can't be less than 0 or more than 60 minutes!");
    }

    private void checkMaxVaccines(int maxVaccines){
        if (maxVaccines==0)
            throw new IllegalArgumentException("Max vaccines can't be 0!");
        if (maxVaccines<0)
            throw new IllegalArgumentException("Max vaccines can't be negative!");
    }

    private void checkCoordinator(Employee Coordinator){
        if(Coordinator.equals(null))
            throw new IllegalArgumentException("Coordinator can't be null!");
    }

    private void checkAges(String ages){
        if(ages==null|| ages.isEmpty())
            throw new IllegalArgumentException("AGES can't be null or empty");
    }

    private void checkArs(String ars) {
        if (ars == null || ars.isEmpty())
            throw new IllegalArgumentException("ARS can't be null or empty");
    }

    private void checkRegion(String region){
        if (region==null||region.isEmpty())
            throw new IllegalArgumentException("Region can't be null or empty!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaccinationCenter that = (VaccinationCenter) o;
        return Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(faxNumber, that.faxNumber) && Objects.equals(websiteAddress, that.websiteAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, emailAddress, phoneNumber, faxNumber, websiteAddress);
    }
}

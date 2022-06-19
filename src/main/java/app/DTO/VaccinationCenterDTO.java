package app.DTO;

import app.domain.model.Employee;
import app.domain.model.VaccinationCenterDependencies.Tempo;
import app.domain.model.VaccinationCenterDependencies.TimeSlot;

import java.io.Serializable;
import java.util.List;

/**
 * The type Vaccination center dto.
 */
public class VaccinationCenterDTO implements Serializable {

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
     * Instantiates a new Vaccination center dto.
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
     * @param timeSlots      the time slots
     * @param region         the region
     */
    public VaccinationCenterDTO(String name, String address, String emailAddress, String phoneNumber, String faxNumber, String websiteAddress, Tempo openingHours, Tempo closingHours, int slotDuration, int maxVaccines, Employee coordinator, String ages, String ars, List<TimeSlot> timeSlots, String region) {
        this.name = name;
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
        this.typeOfCenter = "Health Care Center";
        this.timeSlots = timeSlots;
        this.region = region;
    }

    /**
     * Instantiates a new Vaccination center dto.
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
     * @param timeSlots      the time slots
     */
    public VaccinationCenterDTO(String name, String address, String emailAddress, String phoneNumber, String faxNumber, String websiteAddress, Tempo openingHours, Tempo closingHours, int slotDuration, int maxVaccines, Employee coordinator, List<TimeSlot> timeSlots){
        this.name = name;
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
        this.timeSlots = timeSlots;
        this.typeOfCenter = "Mass Community Vaccination Center";
        this.ages = "Undefined";
        this.ars = "Undefined";
        this.region = "Undefined";
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
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
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
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
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
     * Gets website address.
     *
     * @return the website address
     */
    public String getWebsiteAddress() {
        return websiteAddress;
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
     * Gets closing hours.
     *
     * @return the closing hours
     */
    public Tempo getClosingHours() {
        return closingHours;
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
     * Gets max vaccines.
     *
     * @return the max vaccines
     */
    public int getMaxVaccines() {
        return maxVaccines;
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
     * Gets ages.
     *
     * @return the ages
     */
    public String getAges() {
        return ages;
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
     * Gets type of center.
     *
     * @return the type of center
     */
    public String getTypeOfCenter() {
        return typeOfCenter;
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
     * Gets region.
     *
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        if(this.typeOfCenter.equals("Mass Community Vaccination Center")){

            return
                    "Name: " + this.name + "\n" +
                            "Address: " + this.address + "\n" +
                            "E-mail: " + this.emailAddress + "\n" +
                            "Phone Number: " + this.phoneNumber + "\n" +
                            "Fax Number: " + this.faxNumber + "\n" +
                            "Website Address: " + this.websiteAddress + "\n" +
                            "Opening Hours: " + this.openingHours + "\n" +
                            "Closing Hours: " + this.closingHours + "\n" +
                            "Slot Duration: " + this.slotDuration + "\n" +
                            "Max Vaccines per Slot: " + this.maxVaccines + "\n" +
                            "Coordinator: " + this.coordinator.getName() + "\n" +
                            "Type Of Center: " + this.typeOfCenter + "\n" +
                            "Time Slots: " + this.timeSlots + "\n"
                    ;

        }else if(this.typeOfCenter.equals("Health Care Center")){

            return
                    "Name: " + this.name + "\n" +
                            "Address: " + this.address + "\n" +
                            "E-mail: " + this.emailAddress + "\n" +
                            "Phone Number: " + this.phoneNumber + "\n" +
                            "Fax Number: " + this.faxNumber + "\n" +
                            "Website Address: " + this.websiteAddress + "\n" +
                            "Opening Hours: " + this.openingHours + "\n" +
                            "Closing Hours: " + this.closingHours + "\n" +
                            "Slot Duration: " + this.slotDuration + "\n" +
                            "Max Vaccines per Slot: " + this.maxVaccines + "\n" +
                            "Coordinator: " + this.coordinator.getName() + "\n" +
                            "AGES: " + this.ages + "\n" +
                            "ARS: " + this.ars + "\n" +
                            "Type Of Center: " + this.typeOfCenter + "\n" +
                            "Time Slots: " + this.timeSlots + "\n" +
                            "Region: " + this.region + "\n"
                    ;

        }else return null;
    }
}


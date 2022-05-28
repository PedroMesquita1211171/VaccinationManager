package app.DTO;

import app.domain.shared.Constants;

public class VaccinationCenterDTO {

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

    public VaccinationCenterDTO(String address, String emailAddress, String phoneNumber, String faxNumber, String websiteAddress, String openingHours, String closingHours, int slotDuration, int maxVaccines, String coordinator, String ages, String ars) {
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

    public String getFaxNumber() {
        return faxNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWebsiteAddress() {
        return websiteAddress;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public String getClosingHours() {
        return closingHours;
    }

    public int getSlotDuration() {
        return slotDuration;
    }

    public int getMaxVaccines() {
        return maxVaccines;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public String getAges() {
        return ages;
    }

    public String getArs() {
        return ars;
    }

    public String getTypeOfCenter() {
        return typeOfCenter;
    }


    @Override
    public String toString() {
        return
                        "Email: " + emailAddress + "\n" +
                        "Address: " + address + "\n" +
                        "Phone Number: " + phoneNumber + "\n" +
                        "Fax Number:" + faxNumber+ "\n"+
                        "Website address:" + websiteAddress+ "\n"+
                        "Opening hours:"+ openingHours+ "\n"+
                        "Closing hours:"+ closingHours+ "\n"+
                        "Slot duration:"+ maxVaccines+ "\n"+
                        "Coordinator:"+ coordinator+ "\n"+
                        "Ages:"+ ages+ "\n"+
                        "Ars:"+ ars+ "\n"+
                        "Type of center:"+ typeOfCenter+ "\n";
    }
}


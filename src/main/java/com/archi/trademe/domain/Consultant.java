package com.archi.trademe.domain;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public final class Consultant {

    private final String id;
    private String firstname;
    private String lastname;
    private String modality;
    private Double averageDailyRate;
    private List<String> fieldsOfExpertise;
    private List<String> availabilities;

    public Consultant() {
        this.id = UUID.randomUUID().toString();
    }

    public Consultant(String firstname, String lastname, String modality, Double averageDailyRate, List<String> fieldsOfExpertise, List<String> availabilities) {
        this.id = UUID.randomUUID().toString();
        this.firstname = firstname;
        this.lastname = lastname;
        this.modality = modality;
        this.averageDailyRate = averageDailyRate;
        this.fieldsOfExpertise = fieldsOfExpertise;
        this.availabilities = availabilities;
    }
    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public List<String> getFieldsOfExpertise() {
        return fieldsOfExpertise;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFieldsOfExpertise(List<String> fieldsOfExpertise) {
        this.fieldsOfExpertise = fieldsOfExpertise;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public Double getAverageDailyRate() {
        return averageDailyRate;
    }

    public void setAverageDailyRate(Double averageDailyRate) {
        this.averageDailyRate = averageDailyRate;
    }

    public List<String> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<String> availabilities) {
        this.availabilities = availabilities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultant consultant = (Consultant) o;
        return Objects.equals(id, consultant.id);
    }

    @Override
    public String toString() {
        return "Consultant {" +
                "id = '" + id + '\'' +
                ", firstname = '" + firstname + '\'' +
                ", lastname = '" + lastname + '\'' +
                ", modality = '" + modality + '\'' +
                ", averageDailyRate = " + averageDailyRate +
                ", fieldsOfExpertise = " + fieldsOfExpertise +
                ", availabilities = " + availabilities +
                '}';
    }
}

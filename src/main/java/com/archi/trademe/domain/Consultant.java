package com.archi.trademe.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

public final class Consultant {

    private final UUID id;
    private String firstname;
    private String lastname;
    private String modality;
    private Double averageDailyRate;
    private List<String> fieldsOfExpertise;
    private List<String> availabilities;

    public Consultant() {
        this.id = UUID.randomUUID();
    }

    public Consultant(String firstname, String lastname, String modality, Double averageDailyRate, List<String> fieldsOfExpertise, List<String> availabilities) {
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.modality = modality;
        this.averageDailyRate = averageDailyRate;
        this.fieldsOfExpertise = fieldsOfExpertise;
        this.availabilities = availabilities;
    }

    /**
     * The consultant must have at least one fields of expertise
     * @return true if fields of expertise is empty
     */
    @JsonIgnore
    public boolean isFieldsOfExpertiseInvalid() {
        return this.fieldsOfExpertise.isEmpty();
    }

    /**
     * The consultant must have valid availability
     * @return the invalid availability
     */
    @JsonIgnore
    public String isAvailabilitiesValid() {
        List<String> availabilities = Stream.of(Availabilities.values())
                .map(Enum::name)
                .map(String::toLowerCase)
                .toList();

        for (String availability : this.availabilities) {
            if (!availabilities.contains(availability.toLowerCase())) {
                return availability;
            }
        }
        return null;
    }

    /**
     * The consultant must have a valid modality
     * @return true if modality isn't valid
     */
    @JsonIgnore
    public boolean isModalityInvalid() {
        List<String> modalities = Stream.of(Modalities.values())
                .map(Enum::name)
                .map(String::toLowerCase)
                .toList();

        return !modalities.contains(this.modality.toLowerCase());
    }

    public UUID getId() {
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

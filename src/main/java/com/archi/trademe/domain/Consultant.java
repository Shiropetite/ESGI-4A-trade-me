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

    public Consultant(UUID id, Consultant consultant) {
        this.id = id;
        this.firstname = consultant.firstname;
        this.lastname = consultant.lastname;
        this.modality = consultant.modality;
        this.averageDailyRate = consultant.averageDailyRate;
        this.fieldsOfExpertise = consultant.fieldsOfExpertise;
        this.availabilities = consultant.availabilities;
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

    public List<String> getFieldsOfExpertise() {
        return fieldsOfExpertise;
    }

    public String getModality() {
        return modality;
    }

    public List<String> getAvailabilities() {
        return availabilities;
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

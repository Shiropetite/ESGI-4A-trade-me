package com.archi.trademe.domain;

import java.util.List;

public final class Consultant {

    private final String id;
    private String firstname;
    private String lastname;
    private List<String> fieldsOfExpertise; // Domaines d'expertise
    // private List<String> disponibities;

    public Consultant(String id, String firstname, String lastname, List<String> domains) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.fieldsOfExpertise = domains;
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

}

package com.archi.trademe.domain;

import java.util.List;
import java.util.Objects;

public final class Consultant {

    private final String id;
    private String firstname;
    private String lastname;

    private List<String> domains; // Domaines d'expertises

    public Consultant(String id, String firstname, String lastname, List<String> domains) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.domains = domains;
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

    public List<String> getDomains() {
        return domains;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultant that = (Consultant) o;
        return Objects.equals(id, that.id) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(domains, that.domains);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, domains);
    }
}

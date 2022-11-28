package com.archi.trademe.application.port.in;

import java.util.List;

public class UpdateConsultantCommand {

    public final String firstname;
    public final String lastname;
    public final List<String> domains;

    public UpdateConsultantCommand(String firstname, String lastname, List<String> domains) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.domains = domains;
    }
}

package com.archi.trademe.adapter.out;

import com.archi.trademe.application.port.out.ConsultantRepository;
import com.archi.trademe.domain.Consultant;

import java.util.HashMap;
import java.util.Map;

public class InMemoryConsultantRepository implements ConsultantRepository {

    private final Map<String, Consultant> registry = new HashMap<>();

    public Consultant findById(String id) { return registry.get(id); }

    public void save(Consultant newConsultant) {
        registry.put(newConsultant.getId(), newConsultant);
    }

    @Override
    public void update(String id, Consultant newConsultant) {
        Consultant currentConsultant = this.findById(id);

        currentConsultant.setFirstname(newConsultant.getFirstname());
        currentConsultant.setLastname(newConsultant.getLastname());
        currentConsultant.setDomains(newConsultant.getDomains());

        this.save(newConsultant);
    }
}

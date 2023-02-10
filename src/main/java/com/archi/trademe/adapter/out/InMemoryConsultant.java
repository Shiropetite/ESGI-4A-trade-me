package com.archi.trademe.adapter.out;

import com.archi.trademe.domain.Consultant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryConsultant {

    private static InMemoryConsultant instance;
    private final Map<String, Consultant> registry = new HashMap<>();

    private InMemoryConsultant() {}

    public static InMemoryConsultant getInstance() {
        if (instance == null) {
            instance = new InMemoryConsultant();
        }
        return instance;
    }

    public List<Consultant> getAll() { return new ArrayList<>(registry.values()); }

    public Consultant findById(String id) { return registry.get(id); }

    public void save(Consultant newConsultant) {
        registry.put(newConsultant.getId(), newConsultant);
    }

}

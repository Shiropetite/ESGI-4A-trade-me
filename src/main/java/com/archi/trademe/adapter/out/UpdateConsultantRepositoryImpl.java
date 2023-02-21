package com.archi.trademe.adapter.out;

import com.archi.trademe.application.port.out.UpdateConsultantRepository;
import com.archi.trademe.domain.Consultant;

import java.util.UUID;

public class UpdateConsultantRepositoryImpl implements UpdateConsultantRepository {

    @Override
    public Consultant save(Consultant newConsultant) {
        InMemoryConsultant.getInstance().save(newConsultant);
        return newConsultant;
    }

    @Override
    public Consultant findById(UUID id) {
        return InMemoryConsultant.getInstance().findById(id);
    }

}

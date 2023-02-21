package com.archi.trademe.adapter.out;

import com.archi.trademe.application.port.out.CreateConsultantRepository;
import com.archi.trademe.domain.Consultant;

public class CreateConsultantRepositoryImpl implements CreateConsultantRepository {

    @Override
    public Consultant save(Consultant newConsultant) {
        InMemoryConsultant.getInstance().save(newConsultant);
        return InMemoryConsultant.getInstance().findById(newConsultant.getId());
    }

}

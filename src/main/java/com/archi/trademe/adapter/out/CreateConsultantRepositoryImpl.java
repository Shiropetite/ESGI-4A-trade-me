package com.archi.trademe.adapter.out;

import com.archi.trademe.application.port.out.CreateConsultantRepository;
import com.archi.trademe.domain.Consultant;

public class CreateConsultantRepositoryImpl implements CreateConsultantRepository {

    @Override
    public void create(Consultant newConsultant) {
        InMemoryConsultant.getInstance().save(newConsultant);
    }

}

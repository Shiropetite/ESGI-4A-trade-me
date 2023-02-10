package com.archi.trademe.adapter.out;

import com.archi.trademe.application.port.out.UpdateConsultantRepository;
import com.archi.trademe.domain.Consultant;

public class UpdateConsultantRepositoryImpl implements UpdateConsultantRepository {

    @Override
    public void update(String id, Consultant newConsultant) {
        Consultant currentConsultant = InMemoryConsultant.getInstance().findById(id);

        currentConsultant.setFirstname(newConsultant.getFirstname());
        currentConsultant.setLastname(newConsultant.getLastname());
        currentConsultant.setFieldsOfExpertise(newConsultant.getFieldsOfExpertise());

        InMemoryConsultant.getInstance().save(newConsultant);
    }

}

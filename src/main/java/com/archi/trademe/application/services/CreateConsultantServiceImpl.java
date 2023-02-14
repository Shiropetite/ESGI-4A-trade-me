package com.archi.trademe.application.services;

import com.archi.trademe.application.signals.NotificationSender;
import com.archi.trademe.application.port.in.CreateConsultantService;
import com.archi.trademe.application.port.out.CreateConsultantRepository;
import com.archi.trademe.domain.Consultant;
import org.springframework.stereotype.Service;

@Service
public class CreateConsultantServiceImpl implements CreateConsultantService {

    private final CreateConsultantRepository repository;

    public CreateConsultantServiceImpl(CreateConsultantRepository repository) { this.repository = repository; }

    public Consultant create(Consultant consultant) {
        // Consultants have to have at least one field of expertise
        if (consultant.getFieldsOfExpertise().size() == 0) {
            NotificationSender.getInstance().raise("ERR - Consultant don't have any field of expertises");
            throw new RuntimeException("Consultant don't have any field of expertises");
        }
        var consultantCreated = repository.create(consultant);
        NotificationSender.getInstance().raise("INFO - Consultant has been correctly created : " + consultantCreated);
        return consultantCreated;
    }

}

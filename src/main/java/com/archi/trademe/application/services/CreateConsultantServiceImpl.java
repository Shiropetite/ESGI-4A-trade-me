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

        if (consultant.isFieldsOfExpertiseInvalid()) {
            var message = "Consultant does not have any fields of expertise";
            NotificationSender.getInstance().raise("ERR - " + message);
            throw new RuntimeException(message);
        }

        var invalidAvailability = consultant.isAvailabilitiesValid();
        if (invalidAvailability != null) {
            var message = "The availability : " + invalidAvailability + " is not valid";
            NotificationSender.getInstance().raise("ERR - " + message);
            throw new RuntimeException(message);
        }

        if (consultant.isModalityInvalid()) {
            var message = "The modality : " + consultant.getModality() + " is not valid";
            NotificationSender.getInstance().raise("ERR - " + message);
            throw new RuntimeException(message);
        }

        var consultantCreated = repository.save(consultant);
        NotificationSender.getInstance().raise("INFO - Consultant has been correctly created : " + consultantCreated);
        return consultantCreated;
    }

}

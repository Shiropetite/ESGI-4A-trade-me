package com.archi.trademe.application.services;

import com.archi.trademe.application.signals.NotificationSender;
import com.archi.trademe.application.port.in.UpdateConsultantService;
import com.archi.trademe.application.port.out.UpdateConsultantRepository;
import com.archi.trademe.domain.Consultant;
import org.springframework.stereotype.Service;

@Service
public class UpdateConsultantServiceImpl implements UpdateConsultantService {

    private final UpdateConsultantRepository consultantRepository;

    public UpdateConsultantServiceImpl(UpdateConsultantRepository consultantRepository) {
        this.consultantRepository = consultantRepository;
    }

    public Consultant update(String id, Consultant consultant) {

        if (consultant.isFieldsOfExpertiseInvalid()) {
            var message = "Consultant doesn't have any fields of expertise";
            NotificationSender.getInstance().raise("ERR - " + message);
            throw new RuntimeException(message);
        }

        var invalidAvailability = consultant.isAvailabilitiesValid();
        if (invalidAvailability != null) {
            var message = "The availability : " + invalidAvailability + " isn't valid";
            NotificationSender.getInstance().raise("ERR - " + message);
            throw new RuntimeException(message);
        }

        if (consultant.isModalityInvalid()) {
            var message = "The modality : " + consultant.getModality() + " isn't valid";
            NotificationSender.getInstance( ).raise("ERR - " + message);
            throw new RuntimeException(message);
        }

        consultantRepository.update(id, consultant);
        NotificationSender.getInstance().raise("INFO - Consultant has been correctly updated : " + consultant);
        return consultant;
    }

}

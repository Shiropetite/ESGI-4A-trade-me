package com.archi.trademe.application.services;

import com.archi.trademe.application.signals.NotificationSender;
import com.archi.trademe.application.port.in.UpdateConsultantService;
import com.archi.trademe.application.port.out.UpdateConsultantRepository;
import com.archi.trademe.domain.Consultant;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateConsultantServiceImpl implements UpdateConsultantService {

    private final UpdateConsultantRepository repository;

    public UpdateConsultantServiceImpl(UpdateConsultantRepository consultantRepository) {
        this.repository = consultantRepository;
    }

    public Consultant update(String id, Consultant consultant) {

        var consultantDB = this.repository.findById(UUID.fromString(id));

        if (consultantDB == null) {
            var message = "Consultant with id : " + id + " does not exist" ;
            NotificationSender.getInstance().raise("ERR - " + message);
            throw new RuntimeException(message);
        }

        var consultantToCreate = new Consultant(UUID.fromString(id), consultant);

        if (consultantToCreate.isFieldsOfExpertiseInvalid()) {
            var message = "Consultant does not have any fields of expertise";
            NotificationSender.getInstance().raise("ERR - " + message);
            throw new RuntimeException(message);
        }

        var invalidAvailability = consultantToCreate.isAvailabilitiesValid();
        if (invalidAvailability != null) {
            var message = "The availability : " + invalidAvailability + " is not valid";
            NotificationSender.getInstance().raise("ERR - " + message);
            throw new RuntimeException(message);
        }

        if (consultantToCreate.isModalityInvalid()) {
            var message = "The modality : " + consultantToCreate.getModality() + " is not valid";
            NotificationSender.getInstance( ).raise("ERR - " + message);
            throw new RuntimeException(message);
        }

        var saveConsultant = repository.save(consultantToCreate);
        NotificationSender.getInstance().raise("INFO - Consultant has been correctly updated : " + saveConsultant);
        return saveConsultant;
    }

}

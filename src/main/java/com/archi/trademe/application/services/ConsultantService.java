package com.archi.trademe.application.services;

import com.archi.trademe.application.port.in.UpdateConsultantCommand;
import com.archi.trademe.application.port.out.ConsultantRepository;
import com.archi.trademe.domain.Consultant;
import org.springframework.stereotype.Service;

@Service
public class ConsultantService {

    private final ConsultantRepository consultantRepository;

    public ConsultantService(ConsultantRepository consultantRepository) {
        this.consultantRepository = consultantRepository;
    }

    public void update(String id, UpdateConsultantCommand updateConsultantCommand) {
        consultantRepository.update(
                id,
                new Consultant(
                        id,
                        updateConsultantCommand.firstname,
                        updateConsultantCommand.lastname,
                        updateConsultantCommand.domains
                        ));
    }

}

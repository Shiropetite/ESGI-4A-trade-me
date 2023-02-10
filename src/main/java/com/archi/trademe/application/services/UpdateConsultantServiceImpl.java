package com.archi.trademe.application.services;

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

    public void update(String id, Consultant consultant) {
        consultantRepository.update(id, consultant);
    }

}

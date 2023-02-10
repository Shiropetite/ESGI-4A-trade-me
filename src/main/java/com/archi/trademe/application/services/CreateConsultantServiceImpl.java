package com.archi.trademe.application.services;

import com.archi.trademe.application.port.in.CreateConsultantService;
import com.archi.trademe.application.port.out.CreateConsultantRepository;
import com.archi.trademe.domain.Consultant;
import org.springframework.stereotype.Service;

@Service
public class CreateConsultantServiceImpl implements CreateConsultantService {

    private final CreateConsultantRepository repository;

    public CreateConsultantServiceImpl(CreateConsultantRepository repository) {
        this.repository = repository;
    }

    public void create(Consultant consultant) {
        repository.create(consultant);
    }

}

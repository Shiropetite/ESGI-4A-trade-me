package com.archi.trademe.application.services;

import com.archi.trademe.application.signals.NotificationSender;
import com.archi.trademe.application.port.in.SearchConsultantService;
import com.archi.trademe.application.port.out.SearchConsultantRepository;
import com.archi.trademe.domain.Consultant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchConsultantServiceImpl implements SearchConsultantService {

    private final SearchConsultantRepository repository;

    public SearchConsultantServiceImpl(SearchConsultantRepository repository) { this.repository = repository; }

    public List<Consultant> search(String fieldOfExpertise, String modality, String availability) {
        var consultants = repository.search(fieldOfExpertise, modality, availability);
        NotificationSender.getInstance().raise("INFO: Search consultant result : " + consultants);
        return consultants;
    }

}

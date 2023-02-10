package com.archi.trademe.application.services;

import com.archi.trademe.application.port.in.SearchConsultantService;
import com.archi.trademe.application.port.out.SearchConsultantRepository;
import com.archi.trademe.domain.Consultant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchConsultantServiceImpl implements SearchConsultantService {

    private final SearchConsultantRepository repository;

    public SearchConsultantServiceImpl(SearchConsultantRepository repository) {
        this.repository = repository;
    }

    public List<Consultant> search() {
        return repository.search();
    }

}

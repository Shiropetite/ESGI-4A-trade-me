package com.archi.trademe.adapter.out;

import com.archi.trademe.application.port.out.SearchConsultantRepository;
import com.archi.trademe.domain.Consultant;

import java.util.List;

public class SearchConsultantRepositoryImpl implements SearchConsultantRepository {

    @Override
    public List<Consultant> search() {
        return InMemoryConsultant.getInstance().getAll();
    }

}

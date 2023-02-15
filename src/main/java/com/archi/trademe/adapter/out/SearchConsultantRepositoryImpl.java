package com.archi.trademe.adapter.out;

import com.archi.trademe.application.port.out.SearchConsultantRepository;
import com.archi.trademe.domain.Consultant;

import java.util.List;

public class SearchConsultantRepositoryImpl implements SearchConsultantRepository {

    @Override
    public List<Consultant> search(String fieldOfExpertise, String modality, String availability) {
        var consultants = InMemoryConsultant.getInstance().getAll();

        if (fieldOfExpertise != null) {
            consultants = consultants.stream().filter(consultant -> consultant.getFieldsOfExpertise().contains(fieldOfExpertise)).toList();
        }

        if (modality != null) {
            consultants = consultants.stream().filter(consultant -> consultant.getModality().equalsIgnoreCase(modality)).toList();
        }

        if (availability != null) {
            consultants = consultants.stream().filter(consultant -> consultant.getAvailabilities().contains(availability)).toList();
        }

        return consultants;
    }

}

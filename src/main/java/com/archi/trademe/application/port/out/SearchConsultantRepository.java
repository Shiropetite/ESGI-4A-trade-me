package com.archi.trademe.application.port.out;

import com.archi.trademe.domain.Consultant;

import java.util.List;

public interface SearchConsultantRepository {

    List<Consultant> search(String fieldOfExpertise, String modality, String availability);

}

package com.archi.trademe.application.port.out;

import com.archi.trademe.domain.Consultant;

import java.util.UUID;

public interface UpdateConsultantRepository {

    Consultant save(Consultant newConsultant);

    Consultant findById(UUID id);

}

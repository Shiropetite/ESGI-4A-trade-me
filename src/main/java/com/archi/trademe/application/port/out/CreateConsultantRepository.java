package com.archi.trademe.application.port.out;

import com.archi.trademe.domain.Consultant;

public interface CreateConsultantRepository {

    Consultant save(Consultant newConsultant);

}

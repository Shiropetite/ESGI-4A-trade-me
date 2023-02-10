package com.archi.trademe.application.port.out;

import com.archi.trademe.domain.Consultant;

public interface UpdateConsultantRepository {

    void update(String id, Consultant newConsultant);

}

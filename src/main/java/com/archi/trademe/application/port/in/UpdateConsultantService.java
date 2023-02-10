package com.archi.trademe.application.port.in;

import com.archi.trademe.domain.Consultant;

public interface UpdateConsultantService {

    void update(String id, Consultant consultant);

}

package com.archi.trademe.application.port.in;

import com.archi.trademe.domain.Consultant;

public interface UpdateConsultantService {

    Consultant update(String id, Consultant consultant);

}

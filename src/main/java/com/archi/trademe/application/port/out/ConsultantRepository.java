package com.archi.trademe.application.port.out;

import com.archi.trademe.domain.Consultant;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultantRepository {

    void update(String id, Consultant newConsultant);

}

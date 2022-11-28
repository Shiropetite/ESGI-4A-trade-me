package com.archi.trademe.adapter.in;

import com.archi.trademe.application.port.in.UpdateConsultantCommand;
import com.archi.trademe.application.services.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consultants")
public class ConsultantController {

    public final ConsultantService consultantService;

    @Autowired
    public ConsultantController(ConsultantService consultantService) {
        this.consultantService = consultantService;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody UpdateConsultantRequest updateConsultantRequest) {
        this.consultantService.update(
            id,
            new UpdateConsultantCommand(
                updateConsultantRequest.firstname,
                updateConsultantRequest.lastname,
                updateConsultantRequest.domains
            ));
    }

}

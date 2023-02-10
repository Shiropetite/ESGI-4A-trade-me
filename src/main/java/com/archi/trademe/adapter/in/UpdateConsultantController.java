package com.archi.trademe.adapter.in;

import com.archi.trademe.application.port.in.UpdateConsultantService;
import com.archi.trademe.domain.Consultant;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultants")
public class UpdateConsultantController {

    private final UpdateConsultantService service;

    public UpdateConsultantController(UpdateConsultantService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Consultant modifiedConsultant) {
        this.service.update(id, modifiedConsultant);
    }

}

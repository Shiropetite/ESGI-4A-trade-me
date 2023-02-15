package com.archi.trademe.adapter.in;

import com.archi.trademe.application.port.in.UpdateConsultantService;
import com.archi.trademe.domain.Consultant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultants")
public class UpdateConsultantController {

    private final UpdateConsultantService service;

    public UpdateConsultantController(UpdateConsultantService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody Consultant modifiedConsultant) {
        try {
            var consultantCreated = this.service.update(id, modifiedConsultant);
            return ResponseEntity.ok().body(consultantCreated);
        }
        catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

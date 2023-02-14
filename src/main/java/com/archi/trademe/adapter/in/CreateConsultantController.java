package com.archi.trademe.adapter.in;

import com.archi.trademe.application.port.in.CreateConsultantService;
import com.archi.trademe.domain.Consultant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/consultants")
public class CreateConsultantController {

    private final CreateConsultantService service;

    public CreateConsultantController(CreateConsultantService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Consultant consultant) {
        try {
            var consultantCreated = this.service.create(consultant);
            var location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(consultantCreated.getId())
                    .toUri();
            return ResponseEntity.created(location).body(consultantCreated);
        }
        catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

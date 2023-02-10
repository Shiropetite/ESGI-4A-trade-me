package com.archi.trademe.adapter.in;

import com.archi.trademe.application.port.in.CreateConsultantService;
import com.archi.trademe.domain.Consultant;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultants")
public class CreateConsultantController {

    private final CreateConsultantService service;

    public CreateConsultantController(CreateConsultantService service) {
        this.service = service;
    }

    @PostMapping
    public void create(@RequestBody Consultant consultant) {
        this.service.create(consultant);
    }

}

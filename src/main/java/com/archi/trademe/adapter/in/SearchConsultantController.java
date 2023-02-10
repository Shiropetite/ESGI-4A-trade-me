package com.archi.trademe.adapter.in;

import com.archi.trademe.application.port.in.SearchConsultantService;
import com.archi.trademe.domain.Consultant;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultants")
public class SearchConsultantController {

    private final SearchConsultantService service;

    public SearchConsultantController(SearchConsultantService service) {
        this.service = service;
    }

    @GetMapping
    public List<Consultant> search() {
        return this.service.search();
    }

}

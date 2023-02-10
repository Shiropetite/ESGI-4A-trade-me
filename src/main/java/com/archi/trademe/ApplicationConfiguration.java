package com.archi.trademe;

import com.archi.trademe.adapter.out.CreateConsultantRepositoryImpl;
import com.archi.trademe.adapter.out.SearchConsultantRepositoryImpl;
import com.archi.trademe.adapter.out.UpdateConsultantRepositoryImpl;
import com.archi.trademe.application.port.out.CreateConsultantRepository;
import com.archi.trademe.application.port.out.SearchConsultantRepository;
import com.archi.trademe.application.port.out.UpdateConsultantRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    CreateConsultantRepository create() {
        return new CreateConsultantRepositoryImpl();
    }

    @Bean
    UpdateConsultantRepository update() {
        return new UpdateConsultantRepositoryImpl();
    }

    @Bean
    SearchConsultantRepository search() { return new SearchConsultantRepositoryImpl(); }

}

package com.gapperdan.hsvmr.configuration;

import com.gapperdan.hsvmr.service.CountryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories({"com.gapperdan.hsvmr.repository"})
@ComponentScan(basePackages = "com.gapperdan.hsvmr")
public class AppConfig {
    @Bean
    public CountryServiceImpl getCountryService() { return new CountryServiceImpl(); }
}

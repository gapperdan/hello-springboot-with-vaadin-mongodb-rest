package com.gapperdan.hsvmr.service;

import com.gapperdan.hsvmr.domain.Country;
import com.gapperdan.hsvmr.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }
}

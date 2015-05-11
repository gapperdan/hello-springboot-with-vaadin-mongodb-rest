package com.gapperdan.hsvmr.repository;

import com.gapperdan.hsvmr.domain.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CountryRepository extends MongoRepository<Country, Integer> {

    public List<Country> findAll();

}

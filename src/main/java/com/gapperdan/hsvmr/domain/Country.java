package com.gapperdan.hsvmr.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "countries")
public class Country {

    private String name;
    private String code;
    private String capital;
    private int population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}

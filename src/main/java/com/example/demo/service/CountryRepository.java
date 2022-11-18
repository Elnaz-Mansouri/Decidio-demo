package com.example.demo.service;

import com.example.demo.dto.Country;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CountryRepository {
    private final List<Country> countries;

    public CountryRepository() {
        countries = new ArrayList<>();
        countries.add(new Country("AUT", "Austria", "Europe"));
        countries.add(new Country("DEU", "Germany", "Europe"));
        countries.add(new Country("USA", "US", "North America"));
        countries.add(new Country("AUS", "Australia", "Australia"));
        countries.add(new Country("CHN", "China", "Asia"));
        countries.add(new Country("IRN", "Iran", "Asia"));
    }

    public List<Country> getAll() {
        return countries;
    }

    public Country getCountryByCode(String code) {
        return countries.stream().filter(country -> country.getCode().equalsIgnoreCase(code)).findFirst().get();
    }

    public List<Country> getCountryByRegion(String region) {
        return countries.stream().filter(country -> country.getRegion().equalsIgnoreCase(region)).toList();
    }
}

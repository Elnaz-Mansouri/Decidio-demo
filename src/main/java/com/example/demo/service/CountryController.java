package com.example.demo.service;

import com.example.demo.dto.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/countries")
@Validated
public class CountryController {

    private final CountryRepository repository;

    @GetMapping()
    public List<Country> getAll() {
        return repository.getAll();
    }

    @GetMapping("/code/{code}")
    public Country getCountryByCode(@PathVariable @Pattern(regexp = "[a-zA-Z]{3}", message = "Invalid Code")
                                    @NotBlank String code) {
        return repository.getCountryByCode(code);
    }

    @GetMapping("/regions/{region}")
    public List<Country> getCountryByRegion(@PathVariable @NotBlank String region) {
        return repository.getCountryByRegion(region);
    }


}

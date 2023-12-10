package com.example.wintersport.controller;

import com.example.wintersport.repository.CountryRepository;
import com.example.wintersport.response.CountryResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/country")
@CrossOrigin
public class CountryController {
    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public List<CountryResponse> getAllCountries() {
        return this.countryRepository.findAll().stream().map(CountryResponse::new).collect(Collectors.toList());
    }
}

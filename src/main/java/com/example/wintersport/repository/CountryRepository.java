package com.example.wintersport.repository;

import com.example.wintersport.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findAll();
    Optional<Country> findByName(String name);
}

package com.github.GeovannedeSousaSilva.citiesapi.countries.repository;

import com.github.GeovannedeSousaSilva.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}

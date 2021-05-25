package com.github.GeovannedeSousaSilva.citiesapi.countries;

import com.github.GeovannedeSousaSilva.citiesapi.countries.Country;
import com.github.GeovannedeSousaSilva.citiesapi.countries.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/countries")

public class CountryResource {

    private CountryRepository repository;

    public CountryResource(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Country> countries(Pageable page){
        return repository.findAll(page);

    }
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<Country> optinal = repository.findById(id);

        if(optinal.isPresent()){

            return ResponseEntity.ok().body(optinal.get());
        }else {
            return ResponseEntity.notFound().build();

        }




    }

}

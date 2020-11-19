package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class World {
    private final Set<Continent> continents = new HashSet<>();

    public void addContinent(Continent continent){
        continents.add(continent);
    }

    public BigDecimal getPeopleQuantity(){
        Set<Country> countries = continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .collect(Collectors.toSet());
        return countries.stream()
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, country) -> sum = sum.add(country));
    }
}

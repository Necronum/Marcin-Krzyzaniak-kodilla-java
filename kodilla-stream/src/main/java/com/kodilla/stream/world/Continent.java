package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Set;

public class Continent {
    private final String continent;
    private final Set<Country> countries = new HashSet<>();

    public Continent(String continent) {
        this.continent = continent;
    }

    public String getContinent() {
        return continent;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void addCountry(Country country){
        countries.add(country);
    }
}

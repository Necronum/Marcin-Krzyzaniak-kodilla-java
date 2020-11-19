package com.kodilla.stream.world;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity(){
        //Given
        Country spain = new Country("Spain", new BigDecimal("46754778"));
        Country italy = new Country("Italy", new BigDecimal("60461826"));
        Country france = new Country("France", new BigDecimal("65273511"));
        Country china = new Country("China", new BigDecimal("1439323776"));
        Country india = new Country("India", new BigDecimal("1380004385"));
        Country usa = new Country("United States of America", new BigDecimal("331002651"));
        Country brazil = new Country("Brazil", new BigDecimal("212559417"));
        Country mexico = new Country("Mexico", new BigDecimal("128932753"));
        Continent nAmerica = new Continent("North America");
        Continent sAmerica = new Continent("South America");
        Continent europe = new Continent("Europe");
        Continent asia = new Continent("Asia");
        World world = new World();

        //When
        //North America population
        nAmerica.addCountry(usa);
        nAmerica.addCountry(mexico);
        //South America population
        sAmerica.addCountry(brazil);
        //Europe population
        europe.addCountry(spain);
        europe.addCountry(italy);
        europe.addCountry(france);
        //Asia population
        asia.addCountry(china);
        asia.addCountry(india);
        //World population
        world.addContinent(nAmerica);
        world.addContinent(sAmerica);
        world.addContinent(europe);
        world.addContinent(asia);

        BigDecimal population = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPopulation = new BigDecimal("3664313097");
        assertEquals(expectedPopulation, population);
    }
}

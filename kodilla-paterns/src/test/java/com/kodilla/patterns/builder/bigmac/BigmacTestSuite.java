package com.kodilla.patterns.builder.bigmac;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder(){
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("with sesame")
                .sauce("normal")
                .ingredient("lettuce")
                .burgers(2)
                .ingredient("cheese")
                .ingredient("onion")
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        assertEquals(3, howManyIngredients);
        assertEquals("with sesame", bigmac.getBun());
        assertEquals("normal", bigmac.getSauce());
        assertEquals(2, bigmac.getBurgers(), 0);
    }

    @Test
    void testBigMacIngredients(){
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("without sesame")
                .sauce("barbecue")
                .burgers(1)
                .ingredient("cheese")
                .ingredient("onion")
                .ingredient("mushroom")
                .ingredient("prawn")
                .build();
        System.out.println(bigmac);
        System.out.println(bigmac.getIngredients());
        //When
        List<String> ingredients = bigmac.getIngredients();
        //Then
        assertEquals(ingredients, bigmac.getIngredients());
        System.out.println(bigmac.getIngredients().contains("onion"));
        assertEquals("barbecue", bigmac.getSauce());
    }

    @Test
    void testBigMacWithoutIngredients(){
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("without sesame")
                .sauce("normal")
                .burgers(1)
                .build();
        System.out.println(bigmac);
        //When
        List<String> ingredients = bigmac.getIngredients();
        //Then
        assertTrue(ingredients.isEmpty());
    }
}

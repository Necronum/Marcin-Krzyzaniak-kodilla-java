package com.kodilla.patterns.strategy.social;

import static org.junit.jupiter.api.Assertions.*;

import com.kodilla.patterns.strategy.social.media.TwitterPublisher;
import org.junit.jupiter.api.Test;

public class UserTestSuite {
    @Test
    void testDefaultSharingStrategies(){
        //Given
        User jack = new Millenials("Jack Black");
        User zanny = new YGeneration("Zanny Xarsh");
        User tifa = new ZGeneration("Tifa L");

        //When
        String jackShare = jack.media();
        System.out.println("Jack " + jackShare);
        String zannyShare = zanny.media();
        System.out.println("Zanny " + zannyShare);
        String tifaShare = tifa.media();
        System.out.println("Tifa " + tifaShare);

        //Then
        assertEquals("shared on facebook", jackShare);
        assertEquals("shared on twitter", zannyShare);
        assertEquals("shared on snapchat", tifaShare);
    }

    @Test
    void testIndividualSharingStrategy(){
        //Given
        User barbara = new Millenials("Barbara M");

        //When
        String barbaraShare = barbara.media();
        System.out.println("Barbara " + barbaraShare);
        barbara.setSocialPublisher(new TwitterPublisher());
        barbaraShare = barbara.media();
        System.out.println("Barbara now " + barbaraShare);

        //Then
        assertEquals("shared on twitter", barbaraShare);
    }
}

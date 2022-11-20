package org.example.planets;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PlanetsTestHamcrest {
    private final Planets planets = new Planets();
    @Test
    void testAgeInputValidityTest () {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            planets.getAgeOnPlanet("test", "merkury");
        });
        String expectedMessage = "Age should be a number";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void testPlanetInputValidityTest () {
        Exception exception = assertThrows(IOException.class, () -> {
            planets.getAgeOnPlanet("100000", "test");
        });
        String expectedMessage = "Wrong planet name";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void testPlanetAgePositive () throws IOException {
        assertEquals(planets.getAgeOnPlanet("10000000000", "merkury"), "1315.70");
        assertEquals(planets.getAgeOnPlanet("10000000000", "wenus"), "515.09");
        assertEquals(planets.getAgeOnPlanet("10000000000", "ziemia"), "316.88");
        assertEquals(planets.getAgeOnPlanet("10000000000", "mars"), "168.48");
        assertEquals(planets.getAgeOnPlanet("10000000000", "jowisz"), "26.71");
        assertEquals(planets.getAgeOnPlanet("10000000000", "saturn"), "10.76");
        assertEquals(planets.getAgeOnPlanet("10000000000", "uran"), "3.77");
        assertEquals(planets.getAgeOnPlanet("10000000000", "neptun"), "1.92");
    }
    @Test
    void testPlanetInputCaseSensitivity () throws IOException {
        assertEquals(planets.getAgeOnPlanet("10000000000", "Jowisz"), "26.71");
        assertEquals(planets.getAgeOnPlanet("10000000000", "jOwISz"), "26.71");
        assertEquals(planets.getAgeOnPlanet("10000000000", "JOWISZ"), "26.71");
    }
    @Test
    void testWrongPlanetAge () throws IOException {
        assertNotEquals(planets.getAgeOnPlanet("10000000000", "merkury"), "15.0");
        assertNotEquals(planets.getAgeOnPlanet("10000000000", "wenus"), "15.09");
        assertNotEquals(planets.getAgeOnPlanet("10000000000", "ziemia"), "16.88");
        assertNotEquals(planets.getAgeOnPlanet("10000000000", "mars"), "68.48");
        assertNotEquals(planets.getAgeOnPlanet("10000000000", "jowisz"), "6.71");
        assertNotEquals(planets.getAgeOnPlanet("10000000000", "saturn"), "0.76");
        assertNotEquals(planets.getAgeOnPlanet("10000000000", "uran"), "1.77");
        assertNotEquals(planets.getAgeOnPlanet("10000000000", "neptun"), "0.92");
    }
}

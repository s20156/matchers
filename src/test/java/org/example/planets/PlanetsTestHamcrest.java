package org.example.planets;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class PlanetsTestHamcrest {
    private final Planets planets = new Planets();

    @Test
    void testMercuryAgePostive () throws IOException {
        assertThat(planets.getAgeOnPlanet("10000000000", "merkury"), is("1315.70"));
    }
    @Test
    void testVenusAgePositive () throws IOException {
        assertThat(planets.getAgeOnPlanet("10000000000", "wenus"), is("515.09"));
    }

    @Test
    void testEarthAgePositive () throws IOException  {
        assertThat(planets.getAgeOnPlanet("10000000000", "ziemia"), is("316.88"));
    }

    @Test
    void testEarthAgePositiveConvertToDouble () throws IOException {
        assertThat(new Double(planets.getAgeOnPlanet("10000000000", "ziemia")), is(316.88));
    }

    @Test
    void testJupyterAgeWrong () throws IOException {
        assertThat(planets.getAgeOnPlanet("10000000", "jowisz"), not("350.23"));
    }

    @Test
    void testIsPositiveNumeric () throws IOException {
        assertThat(new Double(planets.getAgeOnPlanet("100000000", "uran")), greaterThan(0.0));
    }

    @Test
    void testIsCloseToValue () throws IOException {
        assertThat(new Double(planets.getAgeOnPlanet("10000000000", "ziemia")), closeTo(317.0, 0.5));
    }

    @Test
    void testValueInRange () throws IOException {
        assertThat(new Double(planets.getAgeOnPlanet("10000000000", "neptun")), allOf(notNullValue(), greaterThan(0.0), lessThan(100000.0)));
    }
}

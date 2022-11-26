package org.example.planets;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.assertj.core.api.Assertions.*;


public class PlanetsTestAssertJ {
    Planets planets = new Planets();
    @Test
    void testMercuryAgePositive () throws IOException {
        assertThat(planets.getAgeOnPlanet("10000000000", "merkury")).isEqualTo("1315.70");
    }
    @Test
    void testVenusAgePositive () throws IOException {
        assertThat(planets.getAgeOnPlanet("10000000000", "wenus")).isEqualTo("515.09");
    }
    @Test
    void testEarthAgePositive () throws IOException  {
        assertThat(planets.getAgeOnPlanet("10000000000", "ziemia")).isEqualTo("316.88");
    }
    @Test
    void testEarthAgePositiveConvertToDouble () throws IOException {
        assertThat(new Double(planets.getAgeOnPlanet("10000000000", "ziemia"))).isEqualTo(316.88);
    }
    @Test
    void testJupyterAgeWrong () throws IOException {
        assertThat(planets.getAgeOnPlanet("10000000", "jowisz")).isNotEqualTo("350.23");
    }
    @Test
    void testIsPositiveNumeric () throws IOException {
        assertThat(new Double(planets.getAgeOnPlanet("100000000", "uran"))).isGreaterThan(0.0);
    }
    @Test
    void testThrowsExceptionOnWrongPlanet () {
        assertThatExceptionOfType(IOException.class).isThrownBy(() -> { planets.getAgeOnPlanet("1000", "pluton"); })
                .withMessage("\"Wrong planet name\"")
                .withNoCause();
    }
    @Test
    void testThrowsExceptionOnNonNumericAge () {
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {planets.getAgeOnPlanet("test", "test");})
                .withMessage("Age should be a number")
                .withNoCause();
    }
    @Test
    void testValueInRange() throws IOException {
        assertThat(new Double(planets.getAgeOnPlanet("10000000000", "neptun")))
                .isGreaterThan(0.0)
                .isLessThan(10000.0);
    }
    @Test
    void testValueCloseTo() throws IOException {
        assertThat(new Double(planets.getAgeOnPlanet("10000000000", "ziemia")))
                .isCloseTo(317.0, Percentage.withPercentage(0.5));
    }
}

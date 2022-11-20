package org.example.planets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;

class Planets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String age = br.readLine();
        String planet = br.readLine();
        System.out.println(planet);
        System.out.println(getAgeOnPlanet(age, planet));
    }

    public static String getAgeOnPlanet (String age, String planetName) throws IOException {
        long numericAge = 0;
        double planetAge = 0.0;
        String planet = planetName.toLowerCase();
        try {
            numericAge = Long.parseLong(age);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("Age should be a number");
        }
        HashMap<String, Double> planets = new HashMap<String, Double>();
        planets.put("merkury", 0.2408467);
        planets.put("wenus", 0.61519726);
        planets.put("ziemia", 1.0000000);
        planets.put("mars", 1.8808158);
        planets.put("jowisz", 11.862615);
        planets.put("saturn", 29.447498);
        planets.put("uran", 84.016846);
        planets.put("neptun", 164.79132);

        try {
            planetAge = planets.get(planet);
        } catch (Exception exc) {
            throw new IOException("Wrong planet name");
        }
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format((double)numericAge / 31557600 / planetAge);
    }
}
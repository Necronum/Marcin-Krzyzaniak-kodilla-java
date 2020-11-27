package com.kodilla.exception.test;

public class FlightMain {
    public static void main(String[] args) {
        Flight flight = new Flight("Berlin", "Madryt");
        RouteFinder routeFinder = new RouteFinder();

        try {
            routeFinder.findFLight(flight);
        } catch(RouteNotFoundException e) {
            System.out.println(e);
        }
    }
}

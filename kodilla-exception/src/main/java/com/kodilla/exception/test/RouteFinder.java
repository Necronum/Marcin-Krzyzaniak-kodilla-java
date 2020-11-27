package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class RouteFinder {
    public void findFLight(Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> routeCheck = new HashMap<>();
        routeCheck.put("Warszawa", true);
        routeCheck.put("Poznan", false);
        routeCheck.put("Berlin", true);
        routeCheck.put("Londyn", false);

        if(routeCheck.containsKey(flight.getArrivalAirport())){
            System.out.println("Flight from: " + flight.getDepartureAirport() + " to: " + flight.getArrivalAirport()
            + " can be made");
        } else {
            throw new RouteNotFoundException("There is no airport in " + flight.getArrivalAirport());
        }
    }
}

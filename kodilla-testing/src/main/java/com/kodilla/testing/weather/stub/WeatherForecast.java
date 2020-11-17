package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private final Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double getAverage(){
        double average = 0;
        for (Map.Entry<String, Double> entry : temperatures.getTemperatures().entrySet()){
            average += entry.getValue();
        }
        return (average/temperatures.getTemperatures().size());
    }

    public double getMedian(){
        double median = 0;
        List<Double> temperatureList = new ArrayList<>();
        for (Map.Entry<String,Double> entry : temperatures.getTemperatures().entrySet()){
            temperatureList.add(entry.getValue());
        }
        Collections.sort(temperatureList);
        int listSize = temperatureList.size()/2;
        if(temperatureList.size() %2 == 0){
            median = ((temperatureList.get(listSize)+temperatureList.get(listSize-1))/2);
        } else {
            median = temperatureList.get(listSize);
        }
        return median;
    }
}

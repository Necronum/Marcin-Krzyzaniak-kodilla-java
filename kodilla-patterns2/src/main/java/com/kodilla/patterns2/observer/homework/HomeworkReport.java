package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class HomeworkReport implements Observable {
    private final List<Observer> observers;
    private final List<String> homework;
    private final String name;

    public HomeworkReport(String name) {
        observers = new ArrayList<>();
        homework = new ArrayList<>();
        this.name = name;
    }

    public void addHomework(String message) {
        homework.add(message);
        notifyObservers();
    }

    public List<String> getHomework() {
        return homework;
    }

    public String getName() {
        return name;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}

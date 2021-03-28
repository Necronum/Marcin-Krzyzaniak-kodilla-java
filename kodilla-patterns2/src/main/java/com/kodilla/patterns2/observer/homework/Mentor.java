package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String username;
    private int updateCount;

    public Mentor(String username) {
        this.username = username;
    }

    @Override
    public void update(HomeworkReport homeworkReport) {
        System.out.println(username + ": New homework from " + homeworkReport.getName() + "\n" +
                " (total: " + homeworkReport.getHomework().size() + " homework to check)");
        updateCount++;
    }

    public String getUsername() {
        return username;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}

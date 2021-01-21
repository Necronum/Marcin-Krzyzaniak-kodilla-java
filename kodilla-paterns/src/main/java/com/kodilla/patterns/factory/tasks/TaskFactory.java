package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";
    public static final String DRIVING = "DRIVING";

    public final Tasks makeTask(final String taskClass){
        switch(taskClass){
            case PAINTING:
                return new PaintingTask("Painting fence", "brown", "fence");
            case SHOPPING:
                return new ShoppingTask("Buy apples", "apples", 10);
            case DRIVING:
                return new DrivingTask("Drive to work", "work", "bicycle");
            default:
                return null;
        }
    }
}

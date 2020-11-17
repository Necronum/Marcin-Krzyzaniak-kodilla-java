package com.kodilla.testing.shape;

import java.util.*;

public class ShapeCollector {
    private final ArrayList<Shape> shapeList;

    public ShapeCollector() {
        shapeList = new ArrayList<>();
    }

    public void addFigure(Shape shape) {
        shapeList.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (shapeList.contains(shape)) {
            shapeList.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n) {
        return shapeList.get(n);
    }

    public String showFigures() {
        StringBuilder result = new StringBuilder();
        Shape shape = null;
        for (int i = 0; i < shapeList.size(); i++) {
            if (i == shapeList.size() - 1) {
                shape = shapeList.get(i);
                result.append(shape.getShapeName());
            } else {
                shape = shapeList.get(i);
                result.append(shape.getShapeName()).append(", ");
            }
        }
        return result.toString();
    }
}

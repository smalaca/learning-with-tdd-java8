package com.smalaca.java8.interfaces.shapes;

public interface Shape {
    static String describe(Shape shape) {
        return "Area of the given shape is equal: " + shape.area() + ".";
    }

    double area();
}

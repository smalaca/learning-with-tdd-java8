package com.smalaca.java8.interfaces.shapes;

public class Square implements Shape {
    private final double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double area() {
        return sideLength * sideLength;
    }

    public String describe() {
        return Shape.describe(this);
    }
}

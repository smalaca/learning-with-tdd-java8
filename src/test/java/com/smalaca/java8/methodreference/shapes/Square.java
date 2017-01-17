package com.smalaca.java8.methodreference.shapes;

public class Square {
    private final double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double area() {
        return sideLength * sideLength;
    }

    public double calculateAreaOf(Square square) {
        return square.area();
    }

    public double sideLength() {
        return sideLength;
    }
}

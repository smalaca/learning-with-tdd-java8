package com.smalaca.java8.methodreference.calculator;

import com.smalaca.java8.methodreference.shapes.Square;
import com.smalaca.java8.methodreference.shapes.SquareFactory;

public class Calculator {
    public double calculateAreOf(Square square, Operation operation) {
        return operation.area(square);
    }

    public Square fromArea(Square square, SquareFactory factory) {
        return factory.create(square.area());
    }
}

package com.smalaca.java8.interfaces.calculator;

import com.smalaca.java8.interfaces.shapes.Shape;

public class Screen {
    public String display(Shape shape, Operation operation) {
        return operation.display(shape);
    }
}

package com.smalaca.java8.lambda;

import java.util.function.DoubleBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

class SimplyTypedBuidlingBlockTrigger {
    int use(int value, IntUnaryOperator callback) {
        return callback.applyAsInt(value);
    }

    boolean use(int value, IntPredicate callback) {
        return callback.test(value);
    }

    double use(double value1, double value2, DoubleBinaryOperator callback) {
        return callback.applyAsDouble(value1, value2);
    }

    void use(int value, IntConsumer callback) {
        callback.accept(value);
    }
}

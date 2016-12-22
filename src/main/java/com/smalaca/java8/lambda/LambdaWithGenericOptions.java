package com.smalaca.java8.lambda;

class LambdaWithGenericOptions {
    <T> T choose(T first, T second, Comparison<T> comparison) {
        return comparison.compare(first, second) ? first : second;
    }
}

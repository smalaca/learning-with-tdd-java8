package com.smalaca.java8.lambda;

class LambdaTrigger {
    private final int firstParameter;
    private final int secondParameter;
    private int result;

    LambdaTrigger(int firstParameter, int secondParameter) {
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    void process(LambdaWithInput lambda) {
        result = lambda.calculate(firstParameter, secondParameter);
    }

    void process(LambdaWithoutInput lambda) {
        result = lambda.calculate();
    }

    int received() {
        return result;
    }
}

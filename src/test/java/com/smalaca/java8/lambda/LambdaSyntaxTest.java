package com.smalaca.java8.lambda;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaSyntaxTest {
    private static final int FIRST_PARAMETER = 69;
    private static final int SECOND_PARAMETER = 13;
    private LambdaTrigger trigger = new LambdaTrigger(FIRST_PARAMETER, SECOND_PARAMETER);

    @Test
    public void shouldInvokeMethod() {
        trigger.process((int first, int second) -> { return first + second; });

        assertThat(trigger.received()).isEqualTo(82);
    }

    @Test
    public void shouldInvokeMethodWithoutDefinedTypeOfInputParameters() {
        trigger.process((first, second) -> { return first - second; });

        assertThat(trigger.received()).isEqualTo(56);
    }

    @Test
    public void shouldInvokeMethodWithoutInputParameters() {
        trigger.process(() -> 13);

        assertThat(trigger.received()).isEqualTo(13);
    }

    @Test
    public void shouldInvokeMethodWithoutReturnStatementAndBrackets() {
        trigger.process((first, second) -> first * second);

        assertThat(trigger.received()).isEqualTo(897);
    }
}

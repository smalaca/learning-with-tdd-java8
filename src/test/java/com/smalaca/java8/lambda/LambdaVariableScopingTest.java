package com.smalaca.java8.lambda;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class LambdaVariableScopingTest {
    private static final int FIRST_PARAMETER = 69;
    private static final int DUMMY_PARAMETER = -1;
    private LambdaTrigger trigger = new LambdaTrigger(FIRST_PARAMETER, DUMMY_PARAMETER);

    private int toUseInLambda = 13;

    @Test
    public void shouldModifyInstanceVariable() {
        trigger.process(first -> toUseInLambda = first);

        assertThat(toUseInLambda).isEqualTo(FIRST_PARAMETER);
    }

    @Test
    public void shouldMatchInstanceVariable() {
        trigger.process(toUseInLambda -> this.toUseInLambda = this.toUseInLambda + toUseInLambda);

        assertThat(toUseInLambda).isEqualTo(82);
    }
}

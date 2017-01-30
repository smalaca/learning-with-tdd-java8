package com.smalaca.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

public class SimplyTypedBuildingBlocksTest {
    private SimplyTypedBuidlingBlockTrigger trigger = new SimplyTypedBuidlingBlockTrigger();

    @Test
    public void shouldUseBuildInUnaryOperatorInterface() {
        IntUnaryOperator callback = x -> x + 13;

        int result = trigger.use(69, callback);

        assertThat(result).isEqualTo(82);
    }

    @Test
    public void shouldUseBuildInBinaryOperatorInterface() {
        DoubleBinaryOperator callback = (x, y) -> x + y;

        double result = trigger.use(13, 69, callback);

        assertThat(result).isEqualTo(82);
    }

    @Test
    public void shouldUseBuildInSpecifiedPredicateInterface() {
        IntPredicate callback = x -> x < 13;

        boolean result = trigger.use(69, callback);

        assertThat(result).isFalse();
    }

    @Test
    public void shouldUseBuildInSpecifiedConsumerInterface() {
        List<Integer> integers = new ArrayList<>();
        IntConsumer callback = x -> integers.add(x);

        trigger.use(69, callback);

        assertThat(integers.size()).isEqualTo(1);
        assertThat(integers.get(0)).isEqualTo(69);
    }
}

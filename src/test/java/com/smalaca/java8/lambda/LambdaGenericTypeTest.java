package com.smalaca.java8.lambda;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class LambdaGenericTypeTest {
    private static final String SEBASTIAN = "Sebastian";
    private static final String MALACA = "Malaca";
    private static final int BAD_LUCK = 13;
    private static final int HAPPY_NUMBER = 7;

    private final LambdaWithGenericOptions options = new LambdaWithGenericOptions();

    @Test
    public void shouldChooseLongerString() {
        String choice = options.choose(SEBASTIAN, MALACA, (first, second) -> first.length() >= second.length());

        assertThat(choice).isSameAs(SEBASTIAN);
    }

    @Test
    public void shouldChooseBiggerInteger() {
        Integer choice = options.choose(BAD_LUCK, HAPPY_NUMBER, (first, second) -> first > second);

        assertThat(choice).isSameAs(BAD_LUCK);
    }

    @Test
    public void shouldChooseListWithMoreElements() {
        List<String> listWithOneElement = asList(SEBASTIAN);
        List<String> listWithTwoElements = asList(SEBASTIAN, MALACA);

        List<String> choice = options.choose(listWithOneElement, listWithTwoElements, (first, second) -> first.size() >= second.size());

        assertThat(choice).isSameAs(listWithTwoElements);
    }
}

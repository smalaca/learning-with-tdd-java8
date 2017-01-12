package com.smalaca.java8.lambda.practice;

import org.junit.Test;

import static java.util.Arrays.sort;
import static org.assertj.core.api.StrictAssertions.assertThat;

public class BasicLambdaTest {
    private static final String MALACA = "Malaca";
    private static final String SEBASTIAN = "Sebastian";
    private static final String CRACOW_POLAND = "Cracow, Poland";
    private static final String LETS_TALK_ABOUT_JAVA = "Let's talk about Java";

    @Test
    public void shouldSortFromShortestToLongest() {
        String[] strings = aStringsArray();

        sort(strings, (first, second) -> first.length() - second.length());

        assertThat(strings).containsExactly(MALACA, SEBASTIAN, CRACOW_POLAND, LETS_TALK_ABOUT_JAVA);
    }

    @Test
    public void shouldSortFromLongestToShortest() {
        String[] strings = aStringsArray();

        sort(strings, (first, second) -> second.length() - first.length());

        assertThat(strings).containsExactly(LETS_TALK_ABOUT_JAVA, CRACOW_POLAND, SEBASTIAN, MALACA);
    }

    @Test
    public void shouldSortAlphabetically() {
        String[] strings = aStringsArray();

        sort(strings, (first, second) -> first.charAt(0) - second.charAt(0));

        assertThat(strings).containsExactly(CRACOW_POLAND, LETS_TALK_ABOUT_JAVA, MALACA, SEBASTIAN);
    }

    @Test
    public void shouldSortDueToExistenceOfTheLetterEInString() {
        String[] strings = aStringsArray();

        sort(strings, (first, second) -> second.contains("e") ? 1 : -1);

        assertThat(strings).containsExactly(SEBASTIAN, LETS_TALK_ABOUT_JAVA, CRACOW_POLAND, MALACA);
    }

    private String[] aStringsArray() {
        return new String[]{SEBASTIAN, MALACA, LETS_TALK_ABOUT_JAVA, CRACOW_POLAND};
    }
}

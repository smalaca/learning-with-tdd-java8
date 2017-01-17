package com.smalaca.java8.methodreference;

import com.smalaca.java8.methodreference.calculator.Calculator;
import com.smalaca.java8.methodreference.shapes.ShapeUtils;
import com.smalaca.java8.methodreference.shapes.Square;
import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class MethodReferenceTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void shouldCalculateAreaOfSquareUsingStaticMethodOfTheClass() {
        Square square = new Square(13.0);

        double result = calculator.calculateAreOf(square, ShapeUtils::area);

        assertThat(result).isEqualTo(169.0);
    }

    @Test
    public void shouldCalculateAreaOfSquareUsingInstanceMethodOfTheClass() {
        Square square = new Square(13.0);

        double result = calculator.calculateAreOf(square, Square::area);

        assertThat(result).isEqualTo(169.0);
    }

    @Test
    public void shouldCalculateAreaOfSquareUsingInstanceMethodOfTheVariable() {
        Square square = new Square(13.0);

        double result = calculator.calculateAreOf(square, square::calculateAreaOf);

        assertThat(result).isEqualTo(169.0);
    }

    @Test
    public void shouldCreateSquareUsingClassNewMethodReference() {
        Square square = new Square(13.0);

        Square result = calculator.fromArea(square, Square::new);

        assertThat(result.sideLength()).isEqualTo(169.0);
    }
}

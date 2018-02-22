package com.smalaca.java8.interfaces;

import com.smalaca.java8.interfaces.calculator.Screen;
import com.smalaca.java8.interfaces.shapes.Shape;
import com.smalaca.java8.interfaces.shapes.Square;
import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class StaticMethodTest {
    private final Screen screen = new Screen();

    @Test
    public void shouldDisplaySquareUsingStaticMethodOfTheInterface() {
        Square square = new Square(13.0);

        String result = screen.display(square, Shape::describe);

        assertThat(result).isEqualTo("Area of the given shape is equal: " + 169.0 + ".");
    }

    @Test
    public void shouldDescribeItselfUsingStaticMethodInTheImplementation() {
        String result = new Square(13.0).describe();

        assertThat(result).isEqualTo("Area of the given shape is equal: " + 169.0 + ".");
    }
}

package de.schumann_lukas.dice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DiceTest {

    private static Stream<Arguments> provideTestData(){
        return Stream.of(
            Arguments.of(6, 3.5, 0.01),
            Arguments.of(2, 1.5, 0.01),
            Arguments.of(10, 5.5, 0.01),
            Arguments.of(20, 10.5, 0.1),
            Arguments.of(50, 25.5, 0.1),
            Arguments.of(80, 40.5, 0.1),
            Arguments.of(100, 50.5, 0.1)
            );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void testGenerateDiceValue(final int maxValue, final double expected, final double delta) {
        final Dice dice = new Dice();
        final List<Integer> erg = new ArrayList<Integer>();

        final int numberOfThrows = 10000000;

        IntStream.range(0, numberOfThrows).forEach(i ->{
            erg.add(dice.generateDiceValue(maxValue));
        }
        );

        if(erg.stream().anyMatch(value -> value > maxValue)){
            fail("Value out of expected Range 1 - 6 (inc.)");
        }

        double sum = erg.stream().mapToInt(Integer::intValue).sum();
        double mean = sum/numberOfThrows;

        assertEquals(expected, mean, delta);
    }
}

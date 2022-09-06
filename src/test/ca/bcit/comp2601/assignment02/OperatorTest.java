package ca.bcit.comp2601.assignment02;

import org.hamcrest.CoreMatchers;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.BiFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class OperatorTest
{
    void testApply(final Operator operator,
                   final BiFunction<Integer, Integer, Integer> func,
                   final int numberOfIterations)
    {
        final Random random;

        random = new SecureRandom();

        assertThat(operator.apply(0, 0), equalTo(func.apply(0, 0)));
        assertThat(operator.apply(0, 1), equalTo(func.apply(0, 1)));
        assertThat(operator.apply(1, 0), equalTo(func.apply(1, 0)));
        assertThat(operator.apply(-1, 0), equalTo(func.apply(-1, 0)));
        assertThat(operator.apply(0, -1), equalTo(func.apply(0, -1)));
        assertThat(operator.apply(10, -10), equalTo(func.apply(10, -10)));
        assertThat(operator.apply(100, 98), equalTo(func.apply(100, 98)));

        for(int i = 0; i < numberOfIterations; i++)
        {
            final int a;
            final int b;
            final int expectedAnswer;
            final int actualAnswer;

            a              = random.nextInt();
            b              = random.nextInt();
            expectedAnswer = func.apply(a, b);
            actualAnswer   = operator.apply(a, b);
            assertThat(String.format("%d :: %d", a, b), actualAnswer, equalTo(expectedAnswer));
        }
    }

    protected void badApply(final Operator operator)
    {
        badApply(operator, null, 0,    "operandA cannot be null");
        badApply(operator, 0,    null, "operandB cannot be null");
        badApply(operator, null, null, "operandA cannot be null");
    }

    private void badApply(final Operator operator,
                          final Integer  operandA,
                          final Integer  operandB,
                          final String   expectedMessage)
    {
        final IllegalArgumentException ex;

        ex       = assertThrows(IllegalArgumentException.class, () -> operator.apply(operandA, operandB));
        assertThat(ex.getMessage(), CoreMatchers.equalTo(expectedMessage));
    }
}

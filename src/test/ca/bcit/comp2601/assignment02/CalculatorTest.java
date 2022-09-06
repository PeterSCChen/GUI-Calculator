package ca.bcit.comp2601.assignment02;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.BiFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest
{
    private void calculate(final String operator,
                           final BiFunction<Integer, Integer, Integer> func,
                           final int numberOfIterations)
        throws InvalidOperatorException
    {
        final Random     random;
        final Calculator calculator;

        random     = new SecureRandom();
        calculator = new Calculator();

        for(int i = 0; i < numberOfIterations; i++)
        {
            final int a;
            final int b;
            final int expectedAnswer;
            final int actualAnswer;

            a              = random.nextInt();
            b              = random.nextInt();
            expectedAnswer = func.apply(a, b);
            actualAnswer   = calculator.calculate(a, operator, b);
            assertThat(String.format("%d :: %d", a, b), actualAnswer, equalTo(expectedAnswer));
        }
    }

    @Test
    void calculateAddition()
            throws InvalidOperatorException
    {
        calculate("+",
                  Integer::sum,
                  1000);
    }

    @Test
    void subtractionAddition()
            throws InvalidOperatorException
    {
        calculate("-",
                  (a, b) -> a - b,
                  1000);
    }

    @Test
    void multiplicationAddition()
            throws InvalidOperatorException
    {
        calculate("*",
                  (a, b) -> a * b,
                  1000);
    }

    @Test
    void divisionAddition()
            throws InvalidOperatorException
    {
        calculate("/",
                  (a, b) -> b == 0 ? 0 : a / b,
                  1000);
    }

    @Test
    void badCalculate()
    {
        final Calculator calculator;

        calculator = new Calculator();
        badCalculateOperands(calculator, "+");
        badCalculateOperands(calculator, "-");
        badCalculateOperands(calculator, "*");
        badCalculateOperands(calculator, "/");

        badCalcuateOperator(calculator, "%");
        badCalcuateOperator(calculator, "hello");

        badCalculate(calculator, 0, null, 0, IllegalArgumentException.class, "operatorString cannot be null");
    }

    void badCalculateOperands(final Calculator calculator,
                              final String     operator)
    {
        badCalculate(calculator, null, operator, 0,    IllegalArgumentException.class, "operandA cannot be null");
        badCalculate(calculator, 0,    operator, null, IllegalArgumentException.class, "operandB cannot be null");
        badCalculate(calculator, null, operator, null, IllegalArgumentException.class, "operandA cannot be null");
    }

    void badCalcuateOperator(final Calculator calculator,
                             final String     operator)
    {
        badCalculate(calculator, 0, operator, 0, InvalidOperatorException.class, "Invalid operator: " + operator);
    }

    private <T extends Throwable> void badCalculate(final Calculator calculator,
                                                    final Integer    operandA,
                                                    final String     operator,
                                                    final Integer    operandB,
                                                    final Class<T>   expectedException,
                                                    final String     expectedMessage)
    {
        final T ex;

        ex       = assertThrows(expectedException, () -> calculator.calculate(operandA, operator, operandB));
        assertThat(ex.getMessage(), CoreMatchers.equalTo(expectedMessage));
    }
}
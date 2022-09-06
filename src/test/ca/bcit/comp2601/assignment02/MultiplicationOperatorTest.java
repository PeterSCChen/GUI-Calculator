package ca.bcit.comp2601.assignment02;


import org.junit.jupiter.api.Test;

class MultiplicationOperatorTest
    extends OperatorTest
{
    @org.junit.jupiter.api.Test
    void apply()
    {
        testApply(new MultiplicationOperator(), (a, b) -> a * b, 1000);
    }

    @Test
    public void badApply()
    {
        badApply(new MultiplicationOperator());
    }
}
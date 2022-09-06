package ca.bcit.comp2601.assignment02;

import org.junit.jupiter.api.Test;

class DivisionOperatorTest
    extends OperatorTest
{
    @org.junit.jupiter.api.Test
    void apply()
    {
        testApply(new DivisionOperator(), (a, b) -> b == 0 ? 0 : a / b, 1000);
    }

    @Test
    public void badApply()
    {
        badApply(new DivisionOperator());
    }
}
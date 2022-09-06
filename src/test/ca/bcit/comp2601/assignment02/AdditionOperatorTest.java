package ca.bcit.comp2601.assignment02;

import org.junit.jupiter.api.Test;

class AdditionOperatorTest
    extends OperatorTest
{
    @org.junit.jupiter.api.Test
    void apply()
    {
        testApply(new AdditionOperator(), Integer::sum, 1000);
    }

    @Test
    public void badApply()
    {
        badApply(new AdditionOperator());
    }
}

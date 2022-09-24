package ca.bcit.comp2601.assignment02;

/**
 * COMP 2601
 * class DivisionOperator used for dividing
 *
 * @author  Sichu (Peter) Chen
 * @version 1.0
 */
public class DivisionOperator
        extends AdditionOperator
{
    @Override
    protected Integer doApply(final Integer operandA,
                              final Integer operandB)
    {
        final int retVal;

        if(operandB == 0)
        {
            retVal = 0;
        }
        else
        {
            retVal = operandA / operandB;
        }

        return retVal;
    }
}

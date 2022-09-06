package ca.bcit.comp2601.assignment02;

/**
 * COMP 2601
 * class AbstractOperator
 * super class for all operators
 *
 * @author  Sichu (Peter) Chen
 * @version 1.0
 */
public abstract class AbstractOperator
    implements Operator
{
    @Override
    public final Integer apply(final Integer operandA,
                               final Integer operandB)
    {
        final Integer result;

        if(operandA == null)
        {
            throw new IllegalArgumentException("operandA cannot be null");
        }

        if(operandB == null)
        {
            throw new IllegalArgumentException("operandB cannot be null");
        }

        result = doApply(operandA, operandB);

        return result;
    }

    protected abstract Integer doApply(Integer operandA,
                                       Integer operandB);
}

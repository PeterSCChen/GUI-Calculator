package ca.bcit.comp2601.assignment02;

/**
 * COMP 2601
 * class AdditionOperator used for addition operation
 *
 * @author  Sichu (Peter) Chen
 * @version 1.0
 */
public class AdditionOperator
        extends AbstractOperator
{
    @Override
    protected Integer doApply(final Integer operandA,
                              final Integer operandB)
    {
        return operandA + operandB;
    }
}

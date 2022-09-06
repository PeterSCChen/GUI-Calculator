package ca.bcit.comp2601.assignment02;

/**
 * COMP 2601
 * class SubtractionOperator
 * performs subtraction operation
 *
 * @author  Sichu (Peter) Chen
 * @version 1.0
 */
public class SubtractionOperator
        extends AdditionOperator
{
    @Override
    protected Integer doApply(final Integer operandA,
                              final Integer operandB)
    {
        return operandA - operandB;
    }
}

package ca.bcit.comp2601.assignment02;

/**
 * COMP 2601
 * class MultiplicationOperator
 * perform multiplication calculation
 *
 * @author  Sichu (Peter) Chen
 * @version 1.0
 */
public class MultiplicationOperator
    extends AdditionOperator
{
    @Override
    protected Integer doApply(final Integer operandA,
                              final Integer operandB)
    {
        return operandA * operandB;
    }
}

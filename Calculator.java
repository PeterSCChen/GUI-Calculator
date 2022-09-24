package ca.bcit.comp2601.assignment02;

/**
 * COMP 2601
 * class Calculator
 * take in operandA, operandString, operandB
 * perform a calculation based on operandString
 *
 * @author  Sichu (Peter) Chen
 * @version 1.0
 */
public class Calculator
{
    public Integer calculate(final Integer operandA,
                             final String  operatorString,
                             final Integer operandB)
            throws InvalidOperatorException
    {
        final Operator operator;
        final Integer  result;

        if(operandA == null)
        {
            throw new IllegalArgumentException("operandA cannot be null");
        }

        if(operandB == null)
        {
            throw new IllegalArgumentException("operandB cannot be null");
        }

        if(operatorString == null)
        {
            throw new IllegalArgumentException("operatorString cannot be null");
        }

        operator = getOperator(operatorString);
        result   = operator.perform(operandA, operandB);

        return result;
    }

    private Operator getOperator(final String operatorString)
            throws InvalidOperatorException
    {
        final Operator operator;

        ExtendedOperatorFactory opFactory = new ExtendedOperatorFactory();

        operator = opFactory.getOperator(operatorString);

        return operator;
    }
}

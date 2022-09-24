package ca.bcit.comp2601.assignment02;

/**
 * COMP 2601
 * class ExponentOperator
 * performs exponent operation
 *
 * @author  Sichu (Peter) Chen
 * @version 1.0
 */
public class ExponentOperator
        extends AdditionOperator
{
    @Override
    protected Integer doApply(final Integer operandA,
                              final Integer operandB)
    {
        Integer answer = operandA;
        for(int i = 0; i < operandB; i++){
            answer *= operandA;
        }
        return answer;
    }
}

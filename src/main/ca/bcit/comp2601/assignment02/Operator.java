package ca.bcit.comp2601.assignment02;

import java.util.function.BiFunction;

/**
 * COMP 2601
 * interface operator
 * returns apply for operandA and operandB
 *
 * @author  Sichu (Peter) Chen
 * @version 1.0
 */
public interface Operator
    extends BiFunction<Integer, Integer, Integer>
{
    default Integer perform(final Integer operandA,
                            final Integer operandB)
    {
        return apply(operandA, operandB);
    }
}

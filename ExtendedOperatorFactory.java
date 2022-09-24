package ca.bcit.comp2601.assignment02;

/**
 * COMP 2601
 * class ExtendedOperatorFactory
 * generates basicOperator + any new Operators
 *
 * @author  Sichu (Peter) Chen
 * @version 1.0
 */
public class ExtendedOperatorFactory
        extends BasicOperatorFactory implements OperatorFactory
{

    @Override
    public Operator getOperator(String operandString) throws InvalidOperatorException {
        try {
            return super.getOperator(operandString);
        }
        catch(Exception e)
        {
            if(operandString.equals("^"))
            {
                return new ExponentOperator();
            }

            throw new InvalidOperatorException(operandString);
        }
    }
}

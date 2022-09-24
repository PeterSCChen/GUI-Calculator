package ca.bcit.comp2601.assignment02;

/**
 * COMP 2601
 * class BasicOperatorFactory
 * choose what to generate based on operatorSymbol
 *
 * @author  Sichu (Peter) Chen
 * @version 1.0
 */
public class BasicOperatorFactory implements OperatorFactory
{
    @Override
    public Operator getOperator(String operandString) throws InvalidOperatorException
    {
        switch(operandString){
            case "+":
                return new AdditionOperator();

            case "-":
                return new SubtractionOperator();

            case "*":
                return new MultiplicationOperator();

            case "/":
                return new DivisionOperator();

            default:
                throw new InvalidOperatorException(operandString);

        }
    }
}

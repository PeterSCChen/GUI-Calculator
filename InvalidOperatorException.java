package ca.bcit.comp2601.assignment02;

/**
 * COMP 2601
 * class InvalidOperatorException
 * throws exception when any invalid operator is used
 *
 * @author  Sichu (Peter) Chen
 * @version 1.0
 */
public class InvalidOperatorException
    extends Exception
{
    private final String operatorString;

    public InvalidOperatorException(final String str)
    {
        super("Invalid operator: " + str);

        operatorString = str;
    }

    public String getOperatorString()
    {
        return operatorString;
    }
}

package ca.bcit.comp2601.assignment02;

/**
 * COMP 2601
 * class NotAnIntegerException
 * throws exception when input is not an Integer
 *
 * @author  Sichu (Peter) Chen
 * @version 1.0
 */
public class NotAnIntegerException
    extends Exception
{
    private final String value;

    public NotAnIntegerException(final String str)
    {
        super(str + " is not an int");

        value = str;
    }

    public String getValue()
    {
        return value;
    }
}

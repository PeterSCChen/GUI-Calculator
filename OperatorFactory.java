package ca.bcit.comp2601.assignment02;

/**
 * COMP 2601
 * interface operatorFactory
 *
 * gets the operator based on operandString,
 * throws exception when invalid operator is used
 *
 * @author  Sichu (Peter) Chen
 * @version 1.0
 */
public interface OperatorFactory
{
    Operator getOperator(String operandString) throws InvalidOperatorException;
}

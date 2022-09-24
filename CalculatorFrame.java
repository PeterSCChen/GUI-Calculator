package ca.bcit.comp2601.assignment02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame
    extends JFrame
{
    private final Calculator calculator;
    private JLabel answerLabel;
    private String firstNumber;
    private String operator;

    public CalculatorFrame()
    {
        this("Calculator");
    }

    public CalculatorFrame(final String name)
    {
        this(name,
             new Calculator());
    }

    public CalculatorFrame(final String     name,
                           final Calculator calc)
    {
        super(name);

        calculator = calc;
    }

    public void init(final float widthPercent,
                     final float heightPercent)
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        position(widthPercent, heightPercent);
        setLayout(new BorderLayout());
        createAnswerArea();
        createButtonArea();
    }

    private void position(final float widthPercent,
                          final float heightPercent)
    {
        final Dimension screenSize;
        final int       width;
        final int       height;
        final int       x;
        final int       y;

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width      = (int)(screenSize.width * widthPercent);
        height     = (int)(screenSize.height * heightPercent);
        x          = (screenSize.width - width) / 2;
        y          = (screenSize.height - height) / 2;
        setBounds(x, y, width, height);
    }

    private void createAnswerArea()
    {
        answerLabel = new JLabel("0");
        add(answerLabel, BorderLayout.NORTH);
    }

    private void createButtonArea()
    {
        final JPanel buttonPanel;

        buttonPanel = new JPanel(new GridLayout(5, 3, 1, 1));
        add(buttonPanel, BorderLayout.CENTER);

        for(int i = 0; i < 10; i++)
        {
            final String buttonName;

            buttonName = Integer.toString(i);
            createAndAddButton(buttonPanel,
                               buttonName,
                               this::addNumber);
        }

        createAndAddButton(buttonPanel, "+", this::selectOperator);
        createAndAddButton(buttonPanel, "-", this::selectOperator);
        createAndAddButton(buttonPanel, "*", this::selectOperator);
        createAndAddButton(buttonPanel, "/", this::selectOperator);
        createAndAddButton(buttonPanel, "=", this::calculate);
    }

    private JButton createAndAddButton(final Container      container,
                                       final String         label,
                                       final ActionListener listener)
    {
        final JButton button;

        button = new JButton(label);
        container.add(button);

        if(listener != null)
        {
            button.addActionListener(listener);
        }

        return button;
    }

    private void addNumber(final ActionEvent event)
    {
        final String currentValueStr;
        final String newDigitStr;
        final String newValue;

        currentValueStr = answerLabel.getText();
        newDigitStr     = event.getActionCommand();

        if(currentValueStr.equals("0"))
        {
            newValue = newDigitStr;
        }
        else
        {
            newValue = currentValueStr + newDigitStr;
        }

        answerLabel.setText(newValue);
    }

    private void selectOperator(final ActionEvent event)
    {
        firstNumber = answerLabel.getText();
        operator    = event.getActionCommand();
        answerLabel.setText("0");
    }

    private void calculate(final ActionEvent event)
    {
        final String secondNumber;

        secondNumber = answerLabel.getText();

        try
        {
            final int    value;
            final String newAnswer;

            value = calculator.calculate(Integer.parseInt(firstNumber),
                                         operator,
                                         Integer.parseInt(secondNumber));
            operator  = null;
            newAnswer = Integer.toString(value);
            answerLabel.setText(newAnswer);
            firstNumber = newAnswer;
        }
        catch(final ca.bcit.comp2601.assignment02.InvalidOperatorException ex)
        {
            System.err.println("Bad operator: " + ex.getOperatorString());
            System.exit(1);
        }
    }
}

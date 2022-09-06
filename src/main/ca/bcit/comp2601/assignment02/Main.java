package ca.bcit.comp2601.assignment02;

import javax.swing.*;

public class Main
{
    public static void main(final String[] argv)
    {
        SwingUtilities.invokeLater(
                () ->
                {
                    final CalculatorFrame frame;

                    frame = new CalculatorFrame();
                    frame.init(0.25f, 0.5f);
                    frame.setVisible(true);
                });
    }
}

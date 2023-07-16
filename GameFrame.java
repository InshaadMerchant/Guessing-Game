/*
 * Inshaad Merchant 1001861293
 */
package code6_1001861293;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.util.Random;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GameFrame extends JFrame
{

    private final JLabel label1;
    private final JButton OKButton;
    private final JButton CancelButton;
    private final JTextField textField1;
    String CCName = "";
    String response = "";

    public GameFrame()
    {

        super("Welcome to my guessing game");
        setLayout(new FlowLayout());
        Random rn = new Random();
        int randomnum = rn.nextInt(4) + 1;
        switch (randomnum)
        {
            case 1:
                CCName = "Spongebob";
                break;
            case 2:
                CCName = "Patrick";
                break;
            case 3:
                CCName = "Squidward";
                break;
            case 4:
                CCName = "Mr Krabs";
                break;
            default:
                System.out.print("Something unknown happened");
        }
        Icon CC = new ImageIcon(getClass().getResource(CCName + ".jpg"));

        label1 = new JLabel();
        label1.setText("Label with text and label");
        label1.setIcon(CC);
        label1.setHorizontalTextPosition(SwingConstants.CENTER);
        label1.setVerticalTextPosition(SwingConstants.BOTTOM);
        label1.setToolTipText("Guess this character?");
        add(label1);

        EventHandler handler = new EventHandler();
        textField1 = new JTextField("Enter your answer here");
        textField1.addActionListener(handler);
        textField1.selectAll();
        add(textField1);

        OKButton = new JButton("OK");
        OKButton.addActionListener(handler);
        add(OKButton);

        CancelButton = new JButton("CANCEL");
        CancelButton.addActionListener(handler);
        add(CancelButton);
    }

    private class EventHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent event)
        {
            String str = textField1.getText();
            boolean guess = false;
            if (CCName.equalsIgnoreCase(str))
            {
                response = "Guessed Correctly!";
                guess = true;
            }
            else
            {
                response = "Guessed Incorrectly.";
            }
            if ((event.getSource() == OKButton) || (event.getSource() == textField1))
            {
                JOptionPane.showMessageDialog(null, response);
                if (guess == true)
                {
                    System.exit(0);
                }
            }
            if (event.getSource() == CancelButton)
            {
                System.exit(0);
            }
        }

    }
}

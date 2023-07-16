/*
 * Inshaad Merchant 1001861293
 */
package code6_1001861293;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
public class Password extends JFrame
{
    private final JPasswordField PasswordField;
    String userpassword = "";
    final String actualpassword = "1712";

    public Password()
    {
        super("Enter Password");
        setLayout(new FlowLayout());
        
        PasswordField = new JPasswordField(10);
        PasswordField.setEchoChar('X');
        add(PasswordField);
        EventHandler handler = new EventHandler();
        PasswordField.addActionListener(handler);
    }

    private class EventHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == PasswordField)
            {
                userpassword = event.getActionCommand();
            }
            if (userpassword.equals(actualpassword))
            {
                setVisible(false);
                GameFrame gameframe = new GameFrame();
                gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameframe.setSize(2000,2000);
                gameframe.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"The password is incorrect");
            }    
        }        
    }

}

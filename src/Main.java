import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Main {
    int n = 1;
    JLabel counterLabel;
    int creditCounter;
    Font font;
    CreditHandler click = new CreditHandler();
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        creditCounter = 0;
        createFont();
        createUI();
    }
    public void createFont(){
        font = new Font("Comic Sans MS", Font.PLAIN, 32);
    }

    public void createUI(){
        //Game window
        JFrame window = new JFrame("BingChilling Clicker Game 4000 LIMITED EDITION (WARNING: EMOTIONAL DAMAGE).exe");
        ImageIcon frameImage  = new ImageIcon(Main.class.getClassLoader().getResource("icon.png"));
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color color = new Color(204, 48, 48, 255);
        window.getContentPane().setBackground(color);
        window.setLayout(null);
        window.setIconImage(frameImage.getImage());
        //---------------------------------------------

        //Button for registering clicks
        JPanel clickerPanel = new JPanel();
        clickerPanel.setBounds(100, 200, 210, 215);
        clickerPanel.setOpaque(false);
        window.add(clickerPanel);

        ImageIcon clickerImage = new ImageIcon(Main.class.getClassLoader().getResource("smile.png"));
        JButton clickerButton = new JButton();
        clickerButton.setBorder(null);
        clickerButton.setOpaque(false);
        clickerButton.setContentAreaFilled(true);
        clickerButton.setBackground(color);
        clickerButton.setIcon(clickerImage);
        clickerButton.addActionListener(click);
        clickerPanel.add(clickerButton);
        //---------------------------------------------

        //Panel for seeing click count
        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(76, 100, 250, 100);
        counterPanel.setBackground(color);
        counterPanel.setLayout(new GridLayout(2,1));
        window.add(counterPanel);

        counterLabel = new JLabel(String.valueOf(creditCounter), SwingConstants.CENTER);
        JLabel creditLabel = new JLabel("social credits", SwingConstants.CENTER);
        counterLabel.setForeground(Color.white);
        counterLabel.setFont(font);
        creditLabel.setForeground(Color.white);
        creditLabel.setFont(font);
        counterPanel.add(counterLabel);
        counterPanel.add(creditLabel);
        //---------------------------------------------
        window.setVisible(true);
    }
    public class CreditHandler implements ActionListener {
        public void actionPerformed(ActionEvent click) {
            creditCounter += n;
            counterLabel.setText(String.valueOf(creditCounter));
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class Gamble extends JPanel{

    Game game;
    Cards cont;
    JButton gambleButton;
    JButton backButton;
    JLabel juicerLabel;
    JLabel creditsLabel;
    JLabel gcreditsLabel;
    int credits;
    int gcredits;

    Gamble(Color color, Game game)
    {
        this.game = game;
        this.setLayout(null);
        this.setBackground(color);
        this.add(createGambleButton());
        this.add(createBackButton());
        this.add(createCreditsLabel());
        this.add(createGambleCreditsLabel());
        this.add(XQCGAMBA());
    }

    private JLabel XQCGAMBA(){
        ImageIcon image = new ImageIcon(Objects.requireNonNull(Gamble.class.getClassLoader().getResource("xqcgamba.gif")));
        juicerLabel = new JLabel(image);
        juicerLabel.setBounds(200, 30, 400, 333);

        return juicerLabel;
    }
    private JLabel createCreditsLabel()
    {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Gamble.class.getClassLoader().getResourceAsStream("font.ttf")));
            creditsLabel = new JLabel("", SwingConstants.CENTER);
            creditsLabel.setFont(font.deriveFont(Font.BOLD, 20));
            creditsLabel.setBounds(100, 370, 600, 50);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        return creditsLabel;
    }

    private JLabel createGambleCreditsLabel()
    {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Gamble.class.getClassLoader().getResourceAsStream("font.ttf")));
            gcreditsLabel = new JLabel("", SwingConstants.CENTER);
            gcreditsLabel.setFont(font.deriveFont(Font.BOLD, 20));
            gcreditsLabel.setBounds(100, 380, 600, 100);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        return gcreditsLabel;
    }

    private JButton createGambleButton()
    {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Gamble.class.getClassLoader().getResourceAsStream("font.ttf")));
            gambleButton = new JButton("Flip the coin");
            gambleButton.setLayout(new BorderLayout());
            gambleButton.setFont(font.deriveFont(Font.BOLD, 16));
            gambleButton.setBackground(Color.white);
            gambleButton.setBounds(300, 470, 200, 50);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        return gambleButton;
    }

    private JButton createBackButton(){
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Gamble.class.getClassLoader().getResourceAsStream("font.ttf")));
            backButton = new JButton("Back");
            backButton.setFont(font.deriveFont(Font.BOLD, 14));
            backButton.setBackground(Color.white);
            backButton.setBounds(10, 10, 75, 50);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        return backButton;
    }

    public void run(Cards cont){
        this.cont = cont;
        BackButton backClick = new BackButton();
        backButton.addActionListener(backClick);
        GambleButton gambleClick = new GambleButton();
        gambleButton.addActionListener(gambleClick);
    }

    public class GambleButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(credits > 0) {
                String[] options = new String[] {"Heads", "Tails"};
                int x =  JOptionPane.showOptionDialog(null, "Do you want to pick heads or tails?", "Big decision",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options, options[0]);

                int rand = (int) (Math.random()*2);

                if(x == rand) {
                    JOptionPane.showMessageDialog(cont, "You just won " + gcredits + " credits!");
                    credits += gcredits;
                    gcredits = (int) (credits * 0.25);
                    setJPanel();
                }
                else {
                    JOptionPane.showMessageDialog(cont, "You just lost " + gcredits + " credits!");
                    credits -= gcredits;
                    gcredits = (int) (credits * 0.25);
                    setJPanel();
                }
            }
            else
                JOptionPane.showMessageDialog(cont, "You can't gamble yet, get more credits!");
        }
    }

    public class BackButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            game.setCreditCounter(credits);
            cont.play();
        }
    }

    void setCredits(){
        this.credits = game.getCreditCounter();
        this.gcredits = (int) (game.getCreditCounter() * 0.25);
    }

    void setJPanel(){
        creditsLabel.setText("You have " + credits + " social credits");
        gcreditsLabel.setText("Double " + gcredits + " social credits or lose them :(");
    }
}
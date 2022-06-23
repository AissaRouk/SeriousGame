import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class MainMenu extends JPanel{
    Cards cont;
    JLabel menuIcon;
    JButton playButton;
    JButton optionsButton;
    JButton exitButton;
    JLabel version;
    Game game;


    MainMenu(Color color, Game game)
    {
        this.game = game;
        this.setLayout(null);
        this.setBackground(color);
        this.add(menuIcon());
        this.add(createPlayButton());
        this.add(createOptionsButton());
        this.add(createExitButton());
        this.add(createLabel());
    }

    private JLabel menuIcon(){
        ImageIcon image = new ImageIcon(Objects.requireNonNull(MainMenu.class.getClassLoader().getResource("menuIcon.png")));
        menuIcon = new JLabel(image);
        menuIcon.setBounds(195, 20, 400, 259);
        return menuIcon;
    }

    private JButton createPlayButton()
    {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Game.class.getClassLoader().getResourceAsStream("font.ttf")));
            playButton = new JButton("PLAY GAME");
            playButton.setFont(font.deriveFont(Font.BOLD, 20));
            playButton.setBackground(Color.white);
            playButton.setLayout(new BorderLayout());
            playButton.setBounds(290, 300, 200, 50);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        return playButton;
    }

    private JButton createOptionsButton()
    {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Game.class.getClassLoader().getResourceAsStream("font.ttf")));
            optionsButton = new JButton("OPTIONS");
            optionsButton.setFont(font.deriveFont(Font.BOLD, 20));
            optionsButton.setBackground(Color.white);
            optionsButton.setLayout(new BorderLayout());
            optionsButton.setBounds(290, 375, 200, 50);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        return optionsButton;
    }

    private JButton createExitButton()
    {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Game.class.getClassLoader().getResourceAsStream("font.ttf")));
            exitButton = new JButton("EXIT");
            exitButton.setFont(font.deriveFont(Font.BOLD, 20));
            exitButton.setBackground(Color.white);
            exitButton.setLayout(new BorderLayout());
            exitButton.setBounds(290, 450, 200, 50);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        return exitButton;
    }

    private JLabel createLabel()
    {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Game.class.getClassLoader().getResourceAsStream("font.ttf")));
            version = new JLabel("Version: 1.0");
            version.setForeground(Color.white);
            version.setFont(font.deriveFont(Font.BOLD, 20));
            version.setBounds(8, 520, 200, 50);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        return version;
    }
    public void run(Cards cont){
        this.cont = cont;
        PlayButton playClick = new PlayButton();
        playButton.addActionListener(playClick);
        OptionsButton optionsClick = new OptionsButton();
        optionsButton.addActionListener(optionsClick);
        ExitButton exitClick = new ExitButton();
        exitButton.addActionListener(exitClick);


    }

    public class PlayButton implements ActionListener {
        public void actionPerformed(ActionEvent playClick) {
            cont.play();
        }
    }

    public class OptionsButton implements ActionListener {
        public void actionPerformed(ActionEvent optionsClick) {
            cont.options();
        }
    }

    public static class ExitButton implements ActionListener {
        public void actionPerformed(ActionEvent exitClick) {
            System.exit(0);
        }
    }
}

package SeriousGame.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel{
    Cards cont;
    JButton playButton;
    JButton optionsButton;
    JButton exitButton;


    MainMenu(Color color)
    {
        this.setLayout(null);
        this.setBackground(color);
        this.add(createPlayButton());
        this.add(createOptionsButton());
        this.add(createExitButton());
        this.add(createLabel());
    }

    private JButton createPlayButton()
    {
        playButton = new JButton("PLAY GAME");
        playButton.setLayout(new BorderLayout());
        playButton.setBounds(300, 300, 200, 50);
        return playButton;
    }

    private JButton createOptionsButton()
    {
        optionsButton = new JButton("OPTIONS");
        optionsButton.setLayout(new BorderLayout());
        optionsButton.setBounds(300, 375, 200, 50);
        return optionsButton;
    }

    private JButton createExitButton()
    {
        exitButton = new JButton("EXIT");
        exitButton.setLayout(new BorderLayout());
        exitButton.setBounds(300, 450, 200, 50);
        return exitButton;
    }

    private JLabel createLabel()
    {
        JLabel version = new JLabel("Version: 1.00.???");
        version.setForeground(Color.white);
        version.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        version.setBounds(10, 520, 200, 50);
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

    public class ExitButton implements ActionListener {
        public void actionPerformed(ActionEvent exitClick) {
            System.exit(0);
        }
    }
}

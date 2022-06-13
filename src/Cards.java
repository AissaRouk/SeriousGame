package SeriousGame.src;

import javax.swing.*;
import java.awt.*;

public class Cards extends JPanel {
    CardLayout cards = new CardLayout();

    Cards(MainMenu menu, Game game, Options options){
        this.setLayout(cards);
        this.add(menu, "1");
        this.add(game, "2");
        this.add(options, "3");
        cards.show(this, "1");
    }
    public void back(){
        cards.show(this, "1");
    }
    public void play(){
        cards.show(this, "2");
    }
    public void options(){
        cards.show(this, "3");
    }
}

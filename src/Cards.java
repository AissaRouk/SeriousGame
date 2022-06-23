import javax.swing.*;
import java.awt.*;

public class Cards extends JPanel {
    CardLayout cards = new CardLayout();
    Gamble gamble;

    Cards(MainMenu menu, Game game, Options options, Gamble gamble){
        this.setLayout(cards);
        this.gamble = gamble;
        this.add(menu, "1");
        this.add(game, "2");
        this.add(options, "3");
        this.add(gamble, "4");
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
    public void gamble() {
        cards.show(this, "4");
        gamble.setCredits();
        gamble.setJPanel();
    }
}

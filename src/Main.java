import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Color color = new Color(204, 48, 48);
        Game game = new Game(color);
        MainMenu menu = new MainMenu(color);
        Options options = new Options(color, menu, game);
        Cards cont = new Cards(menu, game, options);
        menu.run(cont);
        game.run(cont);
        options.run(cont);
        Window window = new Window();
        window.add(cont);

    }
}
package ui;

import logic.GameLoop;
import model.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        BeanType blue = new BeanType("Blau", Map.of(1,1, 2,2, 3,3));
        BeanType red = new BeanType("Rot", Map.of(1,1, 2,2, 3,3));

        List<Card> cards = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            cards.add(new Card(blue));
            cards.add(new Card(red));
        }

        Deck drawPile = new Deck(cards);
        Deck discardPile = new Deck(new ArrayList<>());

        Player p1 = new Player();
        Player p2 = new Player();

        List<Player> players = List.of(p1, p2);

        for (Player p : players) {
            for (int i = 0; i < 5; i++) {
                p.addCard(drawPile.draw());
            }
        }

        GameState state = new GameState(players, drawPile, discardPile);
        GameLoop.run(state);
    }
}
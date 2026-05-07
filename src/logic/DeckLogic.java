package logic;

import model.*;

import java.util.Collections;
import java.util.List;

public class DeckLogic {

    public static Card drawCard(GameState state) {

        Deck drawPile = state.getDrawPile();

        if (drawPile.isEmpty()) {

            Deck discard = state.getDiscardPile();

            if (discard.isEmpty()) {
                return null;
            }

            List<Card> newCards = discard.getCards();
            Collections.shuffle(newCards);

            state.setDrawPile(new Deck(newCards));
            state.setDiscardPile(new Deck(new java.util.ArrayList<>()));

            state.incrementReshuffle();
            System.out.println("Reshuffles: " + state.getReshuffleCount());
        }

        return state.getDrawPile().draw();
    }
}
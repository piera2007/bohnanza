package logic;

import model.*;

import java.util.List;

public class HarvestLogic {

    public static int harvestField(GameState state, Player player, BeanField field) {

        if (field.size() == 0) {
            throw new RuntimeException("Feld ist leer!");
        }

        int amount = field.size();
        BeanType type = field.getType();

        int coins = type.getCoins(amount);

        List<Card> harvested = field.harvest();

        player.addCoins(coins);

        Deck discard = state.getDiscardPile();

        for (int i = coins; i < harvested.size(); i++) {
            discard.add(harvested.get(i));
        }

        return coins;
    }
}
package logic;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class TradeLogic {

    public static List<Card> revealTradeCards(GameState state) {
        List<Card> tableCards = new ArrayList<>();

        Deck drawPile = state.getDrawPile();

        for (int i = 0; i < 2; i++) {
            if (!drawPile.isEmpty()) {
                tableCards.add(drawPile.draw());
            }
        }

        return tableCards;
    }

    public static void takeTradeCards(Player player, List<Card> tableCards) {
        for (Card c : tableCards) {
            player.addCard(c);
        }
        tableCards.clear();
    }

    public static void plantTradeCards(GameState state, Player player, List<Card> cards) {

        for (Card card : cards) {

            boolean planted = false;

            for (BeanField field : player.getFields()) {
                if (field.canPlant(card)) {
                    field.plant(card);
                    planted = true;
                    break;
                }
            }

            if (!planted) {

                BeanField fieldToHarvest = player.getFields().get(0);

                HarvestLogic.harvestField(state, player, fieldToHarvest);

                fieldToHarvest.plant(card);
            }
        }

        cards.clear();
    }
}
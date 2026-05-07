package logic;

import model.*;

public class GameLogic {

    public static void plantFirstCard(Player player, GameState state) {

        if (player.getHand().isEmpty()) {
            throw new RuntimeException("Keine Karten auf der Hand!");
        }

        Card card = player.removeFirstCard();

        for (BeanField field : player.getFields()) {
            if (field.canPlant(card)) {
                field.plant(card);
                return;
            }
        }

        BeanField fieldToHarvest = player.getFields().get(0);

        HarvestLogic.harvestField(state, player, fieldToHarvest);

        fieldToHarvest.plant(card);
    }
}
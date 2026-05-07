package logic;

import model.*;

public class FieldLogic {

    public static void buyThirdField(Player player) {

        if (player.getFields().size() >= 3) {
            throw new RuntimeException("Spieler hat bereits 3 Felder!");
        }

        if (player.getCoins() < 3) {
            throw new RuntimeException("Nicht genug Münzen!");
        }

        player.addCoins(-3);

        player.getFields().add(new BeanField());
    }
}
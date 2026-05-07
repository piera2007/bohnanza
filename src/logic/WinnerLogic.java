package logic;

import model.*;

public class WinnerLogic {

    public static Player determineWinner(GameState state) {

        Player winner = null;
        int maxCoins = -1;

        for (Player player : state.getPlayers()) {

            if (player.getCoins() > maxCoins) {
                maxCoins = player.getCoins();
                winner = player;
            }
        }

        return winner;
    }
}
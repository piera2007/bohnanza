package logic;

import model.*;

import java.util.List;
import java.util.Scanner;

public class GameLoop {

    public static void run(GameState state) {

        Scanner scanner = new Scanner(System.in);

        while (!isGameOver(state)) {

            Player player = state.getActivePlayer();

            System.out.println("\n==============================");
            System.out.println("Spieler " + state.getActivePlayerIndex());
            System.out.println("Hand: " + player.getHand());
            System.out.println("Coins: " + player.getCoins());
            System.out.println("==============================");
            System.out.println("Felder:");

            for (int i = 0; i < player.getFields().size(); i++) {
                System.out.println(i + " = " + player.getFields().get(i));
            }

            System.out.println("==============================");
            System.out.println("Aktionen:");
            System.out.println("1 = Feld ernten");
            System.out.println("2 = 3. Feld kaufen");
            System.out.println("0 = weiter");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Welches Feld? (0 oder 1)");
                int idx = Integer.parseInt(scanner.nextLine());
                HarvestLogic.harvestField(state, player, player.getFields().get(idx));
            }

            if (choice.equals("2")) {
                try {
                    FieldLogic.buyThirdField(player);
                } catch (Exception e) {
                    System.out.println("Fehler: " + e.getMessage());
                }
            }

            // Phase 3
            List<Card> table = TradeLogic.revealTradeCards(state);
            System.out.println("Tischkarten: " + table);

            System.out.println("Was möchtest du mit den Tischkarten machen?");
            System.out.println("1 = selbst pflanzen");
            System.out.println("2 = anderem Spieler geben");
            System.out.println("3 = ablegen");

            String tradeChoice = scanner.nextLine();

            if (tradeChoice.equals("2")) {

                System.out.println("Welcher Spieler?");
                int targetIndex = Integer.parseInt(scanner.nextLine());

                Player target = state.getPlayers().get(targetIndex);

                TradeLogic.plantTradeCards(state, target, table);

                System.out.println("Karten wurden bei Spieler "
                        + targetIndex + " gepflanzt.");

            } else if (tradeChoice.equals("3")) {

                for (Card c : table) {
                    state.getDiscardPile().add(c);
                }

                table.clear();

                System.out.println("Karten wurden abgelegt.");

            } else {

                TradeLogic.plantTradeCards(state, player, table);

                System.out.println("Karten wurden bei dir gepflanzt.");
            }

            // Phase 4
            System.out.println("Ziehe 3 Karten...");
            for (int i = 0; i < 3; i++) {
                Card c = DeckLogic.drawCard(state);
                if (c != null) {
                    player.addCard(c);
                }
            }

            state.nextPlayer();
        }

        System.out.println("\n=== SPIEL BEENDET ===");

        Player winner = WinnerLogic.determineWinner(state);
        System.out.println("Gewinner: " + winner.getCoins() + " Coins");
    }

    private static boolean isGameOver(GameState state) {
        return state.getReshuffleCount() >= 3;
    }
}
package model;

import java.util.List;

public class GameState {

    private List<Player> players;
    private int activePlayerIndex;

    private Deck drawPile;
    private Deck discardPile;

    private Phase currentPhase;

    private List<Card> tempTradeCards;

    private int reshuffleCount = 0;

    public GameState(List<Player> players, Deck drawPile, Deck discardPile) {
        this.players = players;
        this.drawPile = drawPile;
        this.discardPile = discardPile;
        this.activePlayerIndex = 0;
        this.currentPhase = Phase.PLANT_FIRST;
    }

    public Player getActivePlayer() {
        return players.get(activePlayerIndex);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Deck getDrawPile() {
        return drawPile;
    }

    public Deck getDiscardPile() {
        return discardPile;
    }

    public int getActivePlayerIndex() {
        return activePlayerIndex;
    }

    public void nextPlayer() {
        activePlayerIndex = (activePlayerIndex + 1) % players.size();
    }

    public Phase getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(Phase phase) {
        this.currentPhase = phase;
    }

    public List<Card> getTempTradeCards() {
        return tempTradeCards;
    }

    public void setTempTradeCards(List<Card> cards) {
        this.tempTradeCards = cards;
    }

    public void setDrawPile(Deck deck) {
        this.drawPile = deck;
    }

    public void setDiscardPile(Deck deck) {
        this.discardPile = deck;
    }

    public int getReshuffleCount() {
        return reshuffleCount;
    }

    public void incrementReshuffle() {
        reshuffleCount++;
    }
}
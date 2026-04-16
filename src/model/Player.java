package model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Card> hand = new ArrayList<>();
    private List<BeanField> fields = new ArrayList<>();
    private int coins = 0;

    public Player() {
        fields.add(new BeanField());
        fields.add(new BeanField());
    }

    public List<Card> getHand() {
        return hand;
    }

    public List<BeanField> getFields() {
        return fields;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public Card removeFirstCard() {
        return hand.remove(0);
    }

    public void addCoins(int amount) {
        coins += amount;
    }

    public int getCoins() {
        return coins;
    }
}
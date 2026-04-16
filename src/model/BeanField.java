package model;

import java.util.ArrayList;
import java.util.List;

public class BeanField {

    private BeanType type;
    private List<Card> cards = new ArrayList<>();

    public boolean canPlant(Card card) {
        return type == null || type == card.getType();
    }

    public void plant(Card card) {
        if (type == null) {
            type = card.getType();
        }
        cards.add(card);
    }

    public List<Card> harvest() {
        List<Card> harvested = new ArrayList<>(cards);
        cards.clear();
        type = null;
        return harvested;
    }

    public int size() {
        return cards.size();
    }

    public BeanType getType() {
        return type;
    }
}
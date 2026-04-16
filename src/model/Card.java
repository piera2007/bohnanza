package model;

public class Card {
    private BeanType type;

    public Card(BeanType type) {
        this.type = type;
    }

    public BeanType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.getName();
    }
}
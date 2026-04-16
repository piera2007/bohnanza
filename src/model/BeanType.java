package model;

import java.util.Map;

public class BeanType {
    private String name;
    private Map<Integer, Integer> rate;

    public BeanType(String name, Map<Integer, Integer> rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public int getCoins(int amount) {
        return rate.getOrDefault(amount, 0);
    }
}
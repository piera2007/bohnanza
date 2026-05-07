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
        int best = 0;

        for (Map.Entry<Integer, Integer> entry : rate.entrySet()) {
            int beansNeeded = entry.getKey();

            if (beansNeeded <= amount) {
                best = Math.max(best, entry.getValue());
            }
        }

        return best;
    }
}
package ui;

import model.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        BeanType bean = new BeanType("Blaue Bohne", Map.of(1,1, 2,2, 3,3));

        Card c1 = new Card(bean);
        Card c2 = new Card(bean);

        Player player = new Player();

        player.addCard(c1);
        player.addCard(c2);

        System.out.println("Handkarten: " + player.getHand());

        BeanField field = player.getFields().get(0);

        field.plant(player.removeFirstCard());

        System.out.println("Feld Größe: " + field.size());
    }
}
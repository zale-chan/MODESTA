/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elise
 */
public class Card {
    private static String[] name = new String[] {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private static String[] suit = new String[] {"Hearts","Clubs","Spades","Diamonds"};

    public Card(String[] name, String[] suit) {
        this.name = name;
        this.suit = suit;
    }

    public static String[] getName() {
        return name;
    }

    public static String[] getSuit() {
        return suit;
    }
    
    
}

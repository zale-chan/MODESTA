package Card;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * Code based from: crazyjugglerdrummer
 * http://www.dreamincode.net/forums/topic/110380-deck-of-cards-using-various-methods/
 * 
 */
public class Card {
    private int name, suit;

    public Card(int name, int suit) {
        this.name = name;
        this.suit = suit;
    }

    public int getName() {
        return name;
    }

    public int getSuit() {
        return suit;
    }

}
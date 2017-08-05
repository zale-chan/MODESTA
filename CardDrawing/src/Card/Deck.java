package Card;


import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * Code by: crazyjugglerdrummer
 * from: http://www.dreamincode.net/forums/topic/110380-deck-of-cards-using-various-methods/
 */
public class Deck {
    private ArrayList<Card> list;

    public void Deck() {
        list = new ArrayList<Card>();
        
        for(int i=0; i<=3; i++) {
            for(int j=0; j<=12; j++) {
                list.add(new Card(i,j));
            }
        }
    }
    
    public Card drawFromDeck() {
        Random gen = new Random();
        int index = gen.nextInt(list.size());
        return list.remove(index);
    }
  
    public int getTotal() {
        return list.size();
    }
    
}

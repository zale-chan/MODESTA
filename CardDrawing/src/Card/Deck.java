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
 * Code based from: crazyjugglerdrummer
 * http://www.dreamincode.net/forums/topic/110380-deck-of-cards-using-various-methods/
 */
public class Deck {
    private ArrayList<Card> listR;
    private ArrayList<Card> listW;

    public void Deck() {
        listR = new ArrayList<Card>();
        listW = new ArrayList<Card>();
        
        for(int i=0; i<=3; i++) {
            for(int j=0; j<=12; j++) {
                listW.add(new Card(i,j));
                listR.add(new Card(i,j));
            }
        }
    }
    
    public Card drawFromDeckWithout() {
        Random gen = new Random();
        int index = gen.nextInt(listW.size());
        return listW.remove(index);
    }
  
    public Card drawFromDeckWithR() {
        Random gen = new Random();
        int index = gen.nextInt(listR.size());
        return listR.get(index);
    }
    
    public int getTotalR() {
        return listR.size();
    }
    
    public int getTotalW() {
        return listW.size();
    }
    
}

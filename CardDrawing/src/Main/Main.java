/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Card.Card;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import org.rosuda.REngine.Rserve.RConnection;

/**
 *
 * Rserve code by:
 * from https://rajeshsubbiah.wordpress.com/2010/05/13/connecting-to-r-from-java/
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[] {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = new String[] {"H","C","S","D"};
        int Cchoice, Tchoice, Dchoice, suit, name, index, countR = 0, countW = 0;
        ArrayList<Card> handR = new ArrayList<Card>();
        ArrayList<Card> handW = new ArrayList<Card>();
        ArrayList<Card> listR = new ArrayList<Card>();
        ArrayList<Card> listW = new ArrayList<Card>();
        Random gen = new Random(52);
        String rbinom;
        System.out.println("Card Drawing Simulation\n");
        
        try{
            // NOTE: Rserve() must be entered in RStudio after library(Rserve) is used else no connection will happen.
            System.out.println("INFO: Trying to connect to R ");
            RConnection c = new RConnection();
            c.eval("library(Rserve)");
            System.out.println("INFO: Connected to R ");
            System.out.println("INFO: The Server version is " + c.getServerVersion() + "\n");

            //populate deck
            for (int i = 0; i <= 3; i++) {
                for (int j = 0; j <= 12; j++) {
                    listW.add(new Card(j, i));
                    listR.add(new Card(j, i));
                }
            }
            
            do {
                System.out.print("Select number of cards to be drawn (1 to 5): ");
                Cchoice = sc.nextInt();

                if (Cchoice < 1 || Cchoice > 5) {
                    System.out.println("Please select only from 1 to 5.");
                }
            } while (Cchoice < 1 || Cchoice > 5);
            
            do {
                System.out.print("Select number of trials to be done (10 to 100000): ");
                Tchoice = sc.nextInt();

                if (Tchoice < 10 || Tchoice > 100000) {
                    System.out.println("Please select only from 10 to 100000.");
                }
            } while (Tchoice < 10 || Tchoice > 100000);
            
            System.out.print("Input number of desired outcome: ");
            Dchoice = sc.nextInt();
                                 
            System.out.println("With repetition");
            for (int j = 0; j < Tchoice; j++) {
                
                //with rep
                for (int i = 0; i < Cchoice; i++) {
                    index = gen.nextInt(52);
                    suit = listR.get(index).getSuit();
                    name = listR.get(index).getName();
                    handR.add(listR.remove(index));
                    
                    countR += suit;

                    listR.add(new Card(name, suit)); // add back
                    
                    System.out.println(names[name] + " of " + suits[suit]);
                }
            }
            System.out.println("Total with Rep: " + countR);
            
            System.out.println("Without repetition");
            for (int j = 0; j < Tchoice; j++) {
                //without rep
                
                for (int i = 0; i < Cchoice; i++) {
                    index = gen.nextInt(listW.size());
                    suit = listW.get(index).getSuit();
                    name = listW.get(index).getName();
                    countW += suit;
                    handW.add(listW.remove(index));
                    System.out.println(names[name] + " of " + suits[suit]);
                }
            }
            System.out.println("Total Non-Rep: " + countW);
            
//            rbinom = "rbinom("+ Cchoice + "," + 52 + ",1/52)";
//            c.eval("result="+rbinom);
//            int[] res = c.eval("result").asIntegers();
//            for (int i = 0; i < res.length; i++) {
//                System.out.println(res[i]);
//            }
            c.close();

        } catch (Exception e) {
            System.out.println("ERROR: In Connection to R ");
            System.out.println("The Exception is " + e.getMessage());
            e.printStackTrace();
        }       
    }
}

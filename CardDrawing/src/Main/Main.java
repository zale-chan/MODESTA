/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Card.Card;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

/**
 * @author Zale and Faith
 * Rserve code by:
 * from https://rajeshsubbiah.wordpress.com/2010/05/13/connecting-to-r-from-java/
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[] {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = new String[] {"H","C","S","D"};
        int Cchoice, Tchoice, Dchoice, suit, name, index, countR = 0, countW = 0, appearR = 0, appearW = 0;
        float percent = 0;
        int[] tR, tW;
        ArrayList<Card> handR = new ArrayList<Card>();
        ArrayList<Card> handW = new ArrayList<Card>();
        ArrayList<Card> listR = new ArrayList<Card>();
        ArrayList<Card> listW = new ArrayList<Card>();
        Random gen = new Random();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy-hhmmss.SSS");
        String fileName = "files/File-" +  simpleDateFormat.format( new Date() ) + ".txt";
        
        System.out.println("Card Drawing Simulation\n");
        
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
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
            writer.write("Cards to be drawn: " + Cchoice);
            writer.write(System.getProperty( "line.separator" ));
            do {
                System.out.print("Select number of trials to be done (10 to 100000): ");
                Tchoice = sc.nextInt();

                if (Tchoice < 10 || Tchoice > 100000) {
                    System.out.println("Please select only from 10 to 100000.");
                }
            } while (Tchoice < 10 || Tchoice > 100000);
            writer.write("Trials to be done: " + Tchoice);
            writer.write(System.getProperty( "line.separator" ));
            
            System.out.print("Input number of desired total for with repetition: ");
            Dchoice = sc.nextInt();
            writer.write("Desired total (with rep): " + Dchoice);     
            writer.write(System.getProperty( "line.separator" ));
            
            System.out.println("ACTUAL PROBABILITY\n"
                    + "With repetition");
            writer.write("ACTUAL PROBABILITY");
            writer.write(System.getProperty( "line.separator" ));
            writer.write("With repetition");
            writer.write(System.getProperty( "line.separator" ));
            tW = tR = new int[Tchoice];
            for (int j = 0; j < Tchoice; j++) {
                writer.write("Trial " + j);
                writer.write(System.getProperty( "line.separator" ));
                //with rep
                for (int i = 0; i < Cchoice; i++) {
                    index = gen.nextInt(52);
                    suit = listR.get(index).getSuit();
                    name = listR.get(index).getName();
                    handR.add(listR.remove(index));
                    
                    countR = countR + (name + 1);

                    listR.add(new Card(name, suit)); // add back
                    
                    System.out.println(suits[suit] + names[name]);
                    writer.write(suits[suit] + names[name]);
                    writer.write(System.getProperty( "line.separator" ));
                }
                tR[j] = countR;
                System.out.println("Total with Rep: " + countR);
                writer.write("Total with Rep: " + countR);
                writer.write(System.getProperty( "line.separator" ));
                countR = 0;
            }
            
            for (int i = 0; i < Tchoice; i++) {
                if (tR[i] == Dchoice)
                    appearR++;
            }
            System.out.println("Number of times the desired value appeared: " + appearR);
            percent = (float) appearR / (float) Tchoice;
            percent *= 100;
            System.out.println("Percentage the desired value appeared: " + percent + "%");
            
            percent = 0;
            System.out.print("\nInput number of desired total for without repetition: ");
            Dchoice = sc.nextInt();
            writer.write("Desired total (non-rep): " + Dchoice);     
            writer.write(System.getProperty( "line.separator" ));
            
            System.out.println("Without repetition");
            writer.write(System.getProperty( "line.separator" ));
            writer.write("Without repetition");
            writer.write(System.getProperty( "line.separator" ));
            for (int j = 0; j < Tchoice; j++) {
                //without rep
                System.out.println("Trial " + j);
                writer.write("Trial " + j);
                writer.write(System.getProperty( "line.separator" ));
                for (int i = 0; i < Cchoice; i++) {
                    index = gen.nextInt(listW.size());
                    suit = listW.get(index).getSuit();
                    name = listW.get(index).getName();
                    
                    countW = countW + (name + 1);
                    
                    handW.add(listW.remove(index));
                    System.out.println(suits[suit] + names[name]);
                    writer.write(suits[suit] + names[name]);
                    writer.write(System.getProperty( "line.separator" ));
                }
                tW[j] = countW;
                System.out.println("Total Non-Rep: " + countW);
                writer.write("Total Non-Rep: " + countW);
                writer.write(System.getProperty( "line.separator" ));
                countW = 0;
            }
            
            for (int i = 0; i < Tchoice; i++) {
                if (tR[i] == Dchoice)
                    appearW++;
            }
            System.out.println("Number of times the desired value appeared: " + appearW);
            percent = (float) appearW / (float) Tchoice;
            percent *= 100;
            System.out.println("Percentage the desired value appeared: " + percent + "%");
            
            System.out.println("\nIDEAL PROBABILIY\n"
                    + "RBINOM");
            binomial(c, Cchoice, Tchoice, Dchoice);
            c.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERROR: In Connection to R ");
            System.out.println("The Exception is " + e.getMessage());
            e.printStackTrace();
        }       
    }
    
    static void binomial(RConnection r, int C, int T, int D){
        String rbinom = "rbinom("+ C + ",12,1/52)";
        int[] res = {};
        int total, match = 0;
        
        for(int i = 1; i <= T; i++){
            total = 0;
            
            try {
                r.eval("result="+rbinom);
                try {
                    res = r.eval("result").asIntegers();
                } catch (REXPMismatchException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (RserveException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            System.out.print("Trial " + i + ": ");
                
            for (int j = 0; j < res.length; j++) {
                System.out.print((res[j] + 1) + " ");
                total += (res[j] + 1);
            }
                
            System.out.println("Total: " + total);
            
            if(total == D){
                match++;
            }
        }

        System.out.println("Times desired total occured: " + match);
    }
}

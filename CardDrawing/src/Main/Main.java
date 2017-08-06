/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

/**
 *
 * Rserve code by:
 * from https://rajeshsubbiah.wordpress.com/2010/05/13/connecting-to-r-from-java/
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Cchoice, Tchoice, Dchoice;
        
        System.out.println("Card Drawing Simulation\n");
        
        try{
            // NOTE: Rserve() must be entered in RStudio after library(Rserve) is used else no connection will happen.
            System.out.println("INFO: Trying to connect to R ");
            RConnection c = new RConnection();
            c.eval("library(Rserve)");
            System.out.println("INFO: Connected to R ");
            System.out.println("INFO: The Server version is " + c.getServerVersion() + "\n");

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
            
            do {
                System.out.print("Select desired total in a trial (" + Cchoice + " to " + (Cchoice * 13) + "): ");
                Dchoice = sc.nextInt();

                if (Dchoice < Cchoice || Tchoice > (Cchoice * 13)) {
                    System.out.println("Please select only from " + Cchoice + " to " + (Cchoice * 13) + ".");
                }
            } while (Dchoice < Cchoice || Tchoice > (Cchoice * 13));
            
            binomial(c, Cchoice, Tchoice, Dchoice);            
            c.close();

        } catch (RserveException e) {
            System.out.println("ERROR: In Connection to R ");
            System.out.println("The Exception is " + e.getMessage());
        }       
    }
    
    static void binomial(RConnection r, int C, int T, int D){
        FileWriter fw = null;
        BufferedWriter bw = null;
        
        try {
            fw = new FileWriter("C:\\Users\\Faith Clarisse\\Documents\\log.txt");
            bw = new BufferedWriter(fw);
            bw.write("Binomial\n");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
                
            try {
                bw.append("Trial " + i + ": ");
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            for (int j = 0; j < res.length; j++) {
                try {
                    bw.append((res[j] + 1) + " ");
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                total += (res[j] + 1);
            }
                
            try {
                bw.append("Total: " + total + "\n");
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(total == D){
                match++;
            }
        }
        
        try {
            bw.append("Times desired total occured: " + match + "\n");
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

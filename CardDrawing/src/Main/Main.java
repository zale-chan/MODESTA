/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

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
        int Cchoice, Tchoice;
        String rbinom;
        int[] res;
        
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
            
            for(int i = 1; i <= Tchoice; i++){
                rbinom = "rbinom("+ Cchoice + ",12,1/52)";
                c.eval("result="+rbinom);
                res = c.eval("result").asIntegers();
                
                System.out.print("Trial " + i + ":");
                
                for (int j = 0; j < res.length; j++) {
                    System.out.print(" " + (res[j] + 1));
                }
                
                System.out.println();
            }
            
            c.close();

        } catch (Exception e) {
            System.out.println("ERROR: In Connection to R ");
            System.out.println("The Exception is " + e.getMessage());
            e.printStackTrace();
        }       
    }
}

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
 * @author Elise
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Cchoice, Tchoice;
        String rbinom;
        System.out.println("Card Drawing Simulation\n");
        
        try{

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
            
            rbinom = "rbinom("+ Tchoice + "," + Cchoice + ",1/52)";
            c.eval("result="+rbinom);
            int[] res = c.eval("result").asIntegers();
            for (int i = 0; i < res.length; i++)
                System.out.println(res[i]);
            
            c.close();

        } catch (Exception e) {
            System.out.println("ERROR: In Connection to R ");
            System.out.println("The Exception is " + e.getMessage());
            e.printStackTrace();
        }       
    }
}

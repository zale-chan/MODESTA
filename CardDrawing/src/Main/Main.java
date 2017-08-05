/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Scanner;

/**
 *
 * @author Elise
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        
        System.out.println("Card Drawing Simulation\n");
        
        do {
            System.out.print("Select number of cards to be drawn (1 to 5): ");
            choice = sc.nextInt();
            
            if (choice < 1 || choice > 5) {
                System.out.println("Please select only from 1 to 5.");
            }
        } while (choice < 1 || choice > 5);
        
        
    }
}

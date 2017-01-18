/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcardgame;

import java.util.ArrayList;

/**
 *
 * @author Ian
 */
public class WarCardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Card myFirstCard = new Card("Ace", "Spades", 14);
        System.out.printf("My card is: %s%n", myFirstCard);
        
        Card mySecondCard = new Card("Ace", "Hearts" , 14);
        System.out.printf("My card is: %s%n", mySecondCard);
        
        DeckOfCards theDeck = new DeckOfCards();
        System.out.printf("Our deck of cards includes: %n%s", theDeck.toString());
        theDeck.shuffle();
        
        System.out.printf("%n%nAfter shuffling the deck it looks like: %n%s", theDeck.toString());
        
        ArrayList<Card> ianHand = new ArrayList<>();
        
        for (int i=1; i<= 5; i++)
        {
            ianHand.add(theDeck.dealTopCard());
        }
        
        System.out.printf("%nIan's hand is %s%n", ianHand.toString());
    }
   
    
   
}

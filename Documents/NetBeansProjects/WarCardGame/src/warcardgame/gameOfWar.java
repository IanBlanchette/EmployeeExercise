package warcardgame;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ian
 */
public class gameOfWar {
    ArrayList<Card> p1Hand;
    ArrayList<Card> p2Hand;
    int counter = 0;
    public gameOfWar (){
        p1Hand = new ArrayList<>();
        p2Hand = new ArrayList<>();
        
        DeckOfCards theDeck = new DeckOfCards();
        theDeck.shuffle();
        
        dealTheCards(theDeck);
    } // end of the constructor
  
    //This method will deal all the cards to players
    private void dealTheCards(DeckOfCards theDeck)
    {
        for (int cardNum = 0; cardNum <52; cardNum++)
        {
            if (cardNum % 2 == 0)
                p1Hand.add(theDeck.dealTopCard());
            else 
                p2Hand.add(theDeck.dealTopCard());
        }
    }
    //Finds a winner
    public void playTheGame()
    {
        while (!p1Hand.isEmpty() && !p2Hand.isEmpty())
        {
            
            playHand();
            counter ++;
            
        }
        
        if (p1Hand.isEmpty())
            System.out.println("Player 2 is the winner");
        else
            System.out.println("Player 1 is the winner");
    }
    
    // This simulates playing a hand 
    public void playHand()
    {
        
        
        Card p1Card = p1Hand.remove(0);
        Card p2Card = p2Hand.remove(0);
        System.out.printf("Player 1: %s cards in hand %d" ,p1Card, p1Hand.size() + 1);
        System.out.printf("\tPlayer 2: %s cards in hand %d%n", p2Card, p2Hand.size() + 1);
        System.out.println(counter);
        
        // Player 1s card is higher then player 2's card
        if(p1Card.getFaceValue() > p2Card.getFaceValue())
        {
            p1Hand.add(p1Card);
            p1Hand.add(p2Card);
        }
       
        // Player's card is higher then player 1s 
        else if (p2Card.getFaceValue() > p1Card.getFaceValue())
        {
            p2Hand.add(p1Card);
            p2Hand.add(p2Card);
        }
        
        //otherwise its WAR
        
        else 
        {
            ArrayList<Card> warPile = new ArrayList<>();
            warPile.add(p1Card);
            warPile.add(p2Card);
            playWarHand(warPile);
        }
        
    }// end of method playHand()
    
    /**
     * this method will simulate playing the WAR hand
     */
    
    private void playWarHand(ArrayList<Card> warPile)
    {
        if (p1Hand.size() < 3)
        {
            p2Hand.addAll(p1Hand);
            p1Hand.clear();
            p2Hand.addAll(warPile);
            return;
        }
        //Check if player 2 had enough cards
        if (p2Hand.size() < 3)
        {
            p1Hand.addAll(p2Hand);
            p2Hand.clear();
            p1Hand.addAll(warPile);
            return;
        }
        
        warPile.add(p1Hand.remove(0));
        warPile.add(p1Hand.remove(0));
        warPile.add(p2Hand.remove(0));
        warPile.add(p2Hand.remove(0));
        
        Card p1Card = p1Hand.remove(0);
        Card p2Card = p2Hand.remove(0);
        
        
        
        if (p1Card.getFaceValue() > p2Card.getFaceValue())
                {
                  p1Hand.addAll(warPile);
                  p1Hand.add(p1Card);
                  p1Hand.add(p2Card);
                }
        
        else if (p2Card.getFaceValue() > p1Card.getFaceValue())
        {
            p2Hand.addAll(warPile);
            p2Hand.add(p1Card);
            p2Hand.add(p2Card);
        }
        else 
        {
            warPile.add(p1Card);
            warPile.add(p2Card);
            this.playWarHand(warPile);
        }
    }// end the playWarHand
    
}

//end of class
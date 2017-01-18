/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcardgame;

/**
 *
 * @author Ian
 */
public class Card 
{
    private String faceName, suit;
    private int faceValue;
    
    public Card(String face, String suit, int value)
    {
        faceName = face; 
        setSuit(suit);
        setValue(value);
    }
    
    
    /**
     * This method will return a string to represent the card
    */
    @Override
    public String toString()
    {
        return faceName + " of " + suit;
    }
    
    //Method will validate if the suit is valid
    private void setSuit(String suit)
    {
        if (suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("diamonds") || suit.equalsIgnoreCase("spades") || suit.equalsIgnoreCase("clubs"))
        {
            this.suit = suit;
        }
        else 
            throw new IllegalArgumentException("Suit must be hearts, diamonds, spades or clubs");
        
    }
    
    
    //This will validate that the input is between 2 and 14 and set the card value
    private void setValue(int value)
    {
        if (value < 2 || value > 14)
        {
            throw new IllegalArgumentException("Value must be inside 2 and 14");
        }
        else 
        {
            faceValue = value; 
        }
            
    }

    public String getFaceName() {
        return faceName;
    }

    public String getSuit() {
        return suit;
    }

    public int getFaceValue() {
        return faceValue;
    }
    
}

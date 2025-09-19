package card;

import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * 
 * Modifier: Navjot Sandhu
 * Student ID: 991806466
 * Date Modified: Sept 18, 2025
 * 
 * @author srinivsi
 */
public class CardTrick {
    
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        
        // Fill the hand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue((int)(Math.random() * 13) + 1); // values 1–13
            c.setSuit(Card.SUITS[(int)(Math.random() * 4)]); // random suit
            magicHand[i] = c;
        }
        
        // --- Print the hand ---
        for (Card c : magicHand) {
            System.out.println(c.getSuit() + " " + c.getValue());
        }
        
        // --- Ask user for input ---
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a card value (1-13): ");
        int userValue = input.nextInt();
        System.out.print("Enter a suit (0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
        int suitIndex = input.nextInt();
        
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(Card.SUITS[suitIndex]);
        
        // --- Search for user card ---
        boolean userFound = false;
        for (Card c : magicHand) {
            if (c.getValue() == userCard.getValue() &&
                c.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                userFound = true;
                break;
            }
        }
        
        if (userFound) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }
}

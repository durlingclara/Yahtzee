/*******************************************************************************
 * Yahtzee.java
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahtzee;

import java.util.Scanner;

/**
 *
 * @author whovianhalfblood
 */
public class Yahtzee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* TODO:
         * cumulative play (five games)
         * multi-player
         * multi-player cumulative
         * start game
         * create gui 
         * issue with Small Straight
         */
        
        boolean playAgain = true;
        boolean badResponse;
        String player1;
        String player2;
        String player3;
        String player4;
        String player6;
        
        do{
            Scanner scan = new Scanner(System.in);
            System.out.print("What is your name? ");
            player1 = scan.next();
        
            Game round = new Game(player1);
            Play play = new Play();
            play.start(round);
            int finalScore = round.getScore(1);
            
            System.out.println("Your final score is: " + finalScore);
            
            do{
                System.out.println("Enter 'y' to play again or 'n' to quit.");
                String choice = scan.next();
                
                if(choice.equals("y")){
                    // Player wants a new game
                    badResponse = false;
                    playAgain = true;
                } else if (choice.equals("n")){
                    // Player doesn't want to play again
                    badResponse = false;
                    playAgain = false;
                } else {
                    // Player has entered
                    badResponse = true;
                }
            } while(badResponse);
            
        } while(playAgain);
        
    }
    
}

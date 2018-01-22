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
        String[] playerName = {"Player 1", "Player 2", "Player 3", "Player 4", "Player 5", "Player 6"};
        
        do{
            Scanner scan = new Scanner(System.in);
            System.out.println("Right now, we can only accommodate one player games.");
            System.out.print("How many players will be playing? ");
            int players = scan.nextInt();
            
            
            scan.nextLine();
            for(int i = 0; i < players; i++){
                System.out.print(playerName[i] + ", what is your name? ");
                playerName[i] = scan.nextLine();
            }
        
            Game round = new Game(playerName, players);
            Play play = new Play();
            play.start(round);
            
            for(int i = 0; i < players; i++){
                int finalScore = round.getScore(i);
                System.out.println(playerName[i] + ", your final score is: " + finalScore);
            }
            
            boolean badResponse = false;
            
            do{
                System.out.println("Enter 'y' to play again or 'n' to quit.");
                String choice = scan.next().toLowerCase().trim();
                
                switch (choice) {
                    case "y":
                        // Player wants a new game
                        playAgain = true;
                        break;
                    case "n":
                        // Player doesn't want to play again
                        playAgain = false;
                        break;
                    default:
                        // Player has entered something non-compliant
                        badResponse = true;
                        break;
                }
                
            } while(badResponse);
            
        } while(playAgain); 
        
    } // End main method
    
} // End class Yahtzee

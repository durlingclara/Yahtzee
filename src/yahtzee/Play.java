/*******************************************************************************
 * Play.java
 * Clara Durling
 * 
 * This class
 ******************************************************************************/
package yahtzee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import scorecategories.ScoreCategory;

/**
 *
 * @author Clara Durling
 */
public class Play {
    
    private final Dice D1 = new Dice();
    private final Dice D2 = new Dice();
    private final Dice D3 = new Dice();
    private final Dice D4 = new Dice();
    private final Dice D5 = new Dice();
    private List<ScoreCard> cards;
    private final Scanner SCAN = new Scanner(System.in);

    public Play() {
        
    }
    
    //**************************************************************************

    /**
     *
     * @param round
     */
    public void start(Game round) {
        
        boolean gameOver = false;
        cards = round.getScoreCards();
        List<Map> playersScores = new ArrayList();
        
        Map<String, ScoreCategory> scores = new HashMap();
        List<ScoreCategory> categories = round.getCategories();
        
        for(int i = 0; i < categories.size(); i++) {
            ScoreCategory cat = categories.get(i);
            String name = cat.getName();
            scores.put(name, cat);
        }
        
        for(int i = 0; i < cards.size(); i++) {
            Map<String, ScoreCategory> playerScores = scores;
            playersScores.add(playerScores);
        }
        
        /* This loop has the player take a turn and then choose a scoring for 
         * each turn until the game ends*/
        do{ // }while(!gameOver);
            
            // Loops through players
            for(int i = 0; i < cards.size(); i++){
                ScoreCard playerCard = cards.get(i);
                
                // Only gives the player a turn if their card is not full
                if(!playerCard.isFull()){
                    System.out.println(playerCard.toString());
                    System.out.println("-------------------------------------------------");
                    takeTurn();
                    ScoreCategory turnCat = askCat(playersScores.get(i));
            
                    List<Integer> die = new ArrayList();
                    die.add(D1.value());
                    die.add(D2.value());
                    die.add(D3.value());
                    die.add(D4.value());
                    die.add(D5.value());
            
                    int turnScore = turnCat.scorer(die);
                    playerCard.inputScore(turnCat, turnScore);
                }
            }
            
            // Game is over unless one of the players hasn't filled their card
            gameOver = true;
            for(int i = 0; i < cards.size(); i++){
                ScoreCard playerCard = cards.get(i);
                if(!playerCard.isFull()){
                    gameOver = false;
                }
            }
            
        }while(!gameOver);
    }
    
    //**************************************************************************
    
    /**
     * 
     * @param scores
     * @return 
     */
    private ScoreCategory askCat(Map<String, ScoreCategory> scores) {
        String turnCategory;
        ScoreCategory turnCat;
        boolean availCat = true;
        
        // This loop keeps the player from counting a turn towards a section already scored
        do{ // }while(!availCat);
                
            System.out.println("Which score category would you like to count "
                + "this category towards?");
            System.out.println("(Be sure to type in the category name exactly as "
                + "spelled): ");
            SCAN.nextLine();
            
            
            turnCategory = SCAN.nextLine().toLowerCase().trim();
            turnCat = scores.get(turnCategory);
            
            try{
                boolean canBeUsed = turnCat.getAvailability();
            } catch(NullPointerException e){
                System.out.print("That is not a valid score name, try again: ");
                turnCategory = SCAN.nextLine().toLowerCase().trim();
                turnCat = scores.get(turnCategory);
                boolean canBeUsed = turnCat.getAvailability();
            }
            
            if(turnCat.getAvailability() == true){
                availCat = true;
            } else if(turnCat.getAvailability() == false){
                availCat = false;
                System.out.println("You need to choose a different category.  "
                    + "This one is already used.");
            }
                
        } while(!availCat);
        
        return turnCat;
        
    } // End private ScoreCategory askCat(Map<String, ScoreCategory> scores)
    
    //**************************************************************************
    
    /**
     * 
     */
    private void takeTurn() {
        
        // Roll one
        D1.roll();
        D2.roll();
        D3.roll();
        D4.roll();
        D5.roll();
        
        // Display roll one
        System.out.println("When answering as to whether you would like a dice "
                + "rolled on your next turn, type 'y' to roll it or 'n' to keep it");
        System.out.println("Roll 1:");
        displayRoll();
        
        // Roll two
        rollDie();
        
        // Display roll two
        System.out.println("Roll 2:");
        displayRoll();
        
        // Roll three
        rollDie();
        
        // Display roll three
        System.out.println("\nRoll 3:");
        displayRoll();
        
    } // End method private void takeTurn()
    
    //**************************************************************************
    
    /**
     * 
     */
    private void rollDie() {
        String ans = " ";
        List<Dice> die = new ArrayList();
        die.add(D1);
        die.add(D2);
        die.add(D3);
        die.add(D4);
        die.add(D5);
        
        for(int i = 0; i < 5; i++){
            System.out.print("Roll Dice " + (i+1) + " ?");
            ans = SCAN.next();
            if(ans.equals("n")){
                //do nothing
            } else {
                Dice d = die.get(i);
                d.roll();
            }
        }
        
    } // End private void rollDie()
    
    //**************************************************************************
    
    /**
     * 
     */
    private void displayRoll() {
        System.out.println("    Dice 1: " + D1.value());
        System.out.println("    Dice 2: " + D2.value());
        System.out.println("    Dice 3: " + D3.value());
        System.out.println("    Dice 4: " + D4.value());
        System.out.println("    Dice 5: " + D5.value() + "\n");
    } // End private void displayRoll()
    
} // End class Play

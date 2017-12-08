/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahtzee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
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
    
    public void start(Game round){
        
        boolean gameOver = false;
        ScoreCategory turnCat;
        int turnScore = 0;
        
        Map<String, ScoreCategory> scores = new HashMap();
        
        cards = round.getScoreCards();
        ScoreCard player1 = cards.get(0);
        
        List<ScoreCategory> categories = round.getCategories();
        for(int i = 0; i < categories.size(); i++){
            ScoreCategory cat = categories.get(i);
            String name = cat.getName();
            scores.put(name, cat);
        }
        
        /* This loop has the player take a turn and then choose a scoring for 
         * each turn until the game ends*/
        do{ // }while(!gameOver);
            
            System.out.println(player1.toString());
            System.out.println("-------------------------------------------------");
            takeTurn();
            turnCat = askCat(scores);
            
            List<Integer> die = new ArrayList();
            die.add(D1.value());
            die.add(D2.value());
            die.add(D3.value());
            die.add(D4.value());
            die.add(D5.value());
            
            turnScore = turnCat.scorer(die);
            
            gameOver = player1.inputScore(turnCat, turnScore);
            
        }while(!gameOver);
    }
    
    private ScoreCategory askCat(Map<String, ScoreCategory> scores){
        String turnCategory;
        String trash;
        ScoreCategory turnCat;
        boolean availCat = true;
        
        // This loop keeps the player from counting a turn towards a section already scored
        do{ // }while(!availCat);
                
            System.out.println("Which score category would you like to count "
                + "this category towards?");
            System.out.print("(Be sure to type in the category name exactly as "
                + "displayed on the card, ommitting spaces): ");
            
            turnCategory = SCAN.next();
            turnCat = scores.get(turnCategory);
                
            if(turnCat.getAvailability() == true){
                availCat = true;
            } else if(turnCat.getAvailability() == false){
                availCat = false;
                System.out.println("You need to choose a different category.  "
                    + "This one is already used.");
            }
                
        } while(!availCat);
        return turnCat;
    }
    
    private void takeTurn(){
        String ans = " ";
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
        System.out.println("    Dice 1: " + D1.value());
        System.out.println("    Dice 2: " + D2.value());
        System.out.println("    Dice 3: " + D3.value());
        System.out.println("    Dice 4: " + D4.value());
        System.out.println("    Dice 5: " + D5.value() + "\n");
        
        // Roll two
        System.out.print("Roll Dice 1? ");
        ans = SCAN.next();
        if(ans.equals("n")){
            //do nothing
        } else {
            D1.roll();
        }
        
        System.out.print("Roll Dice 2? ");
        ans = SCAN.next();
        if(ans.equals("n")){
            //do nothing
        } else {
            D2.roll();
        }
        
        System.out.print("Roll Dice 3? ");
        ans = SCAN.next();
        if(ans.equals("n")){
            //do nothing
        } else {
            D3.roll();
        }
        
        System.out.print("Roll Dice 4? ");
        ans = SCAN.next();
        if(ans.equals("n")){
            //do nothing
        } else {
            D4.roll();
        }
        
        System.out.print("Roll Dice 5? ");
        ans = SCAN.next();
        if(ans.equals("n")){
            //do nothing
        } else {
            D5.roll();
        }
        
        // Display roll two
        System.out.println("Roll 2:");
        System.out.println("    Dice 1: " + D1.value());
        System.out.println("    Dice 2: " + D2.value());
        System.out.println("    Dice 3: " + D3.value());
        System.out.println("    Dice 4: " + D4.value());
        System.out.println("    Dice 5: " + D5.value() + "\n");
        
        // Roll three
        System.out.print("Roll Dice 1? ");
        ans = SCAN.next();
        if(ans.equals("n")){
            //do nothing
        } else {
            D1.roll();
        }
        
        System.out.print("Roll Dice 2? ");
        ans = SCAN.next();
        if(ans.equals("n")){
            //do nothing
        } else {
            D2.roll();
        }
        
        System.out.print("Roll Dice 3? ");
        ans = SCAN.next();
        if(ans.equals("n")){
            //do nothing
        } else {
            D3.roll();
        }
        
        System.out.print("Roll Dice 4? ");
        ans = SCAN.next();
        if(ans.equals("n")){
            //do nothing
        } else {
            D4.roll();
        }
        
        System.out.print("Roll Dice 5? ");
        ans = SCAN.next();
        if(ans.equals("n")){
            //do nothing
        } else {
            D5.roll();
        }
        
        // Display roll three
        System.out.println("\nRoll 3:");
        System.out.println("    Dice 1: " + D1.value());
        System.out.println("    Dice 2: " + D2.value());
        System.out.println("    Dice 3: " + D3.value());
        System.out.println("    Dice 4: " + D4.value());
        System.out.println("    Dice 5: " + D5.value() + "\n");
        
    } // End method private void takeTurn()
}

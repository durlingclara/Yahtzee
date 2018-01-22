/*******************************************************************************
 * Game.java
 * Author: Clara Durling.
 * 
 * This class creates a clean scorecard for each player then initializes all 
 * score categories, and puts them in a list so that the program knows how to 
 * input the proper score for each category. It also creates the game's die.
 ******************************************************************************/
package yahtzee;

import java.util.ArrayList;
import java.util.List;
import scorecategories.Chance;
import scorecategories.Fives;
import scorecategories.FourOfKind;
import scorecategories.Fours;
import scorecategories.FullHouse;
import scorecategories.LargeStraight;
import scorecategories.Ones;
import scorecategories.ScoreCategory;
import scorecategories.Sixes;
import scorecategories.SmallStraight;
import scorecategories.ThreeOfKind;
import scorecategories.Threes;
import scorecategories.Twos;
import scorecategories.YahtzeeCard;

/**
 *
 * @author Clara Durling
 */
public class Game {
    
    // Scoring options
    private List<ScoreCategory> scores = new ArrayList();
    
    // Score card(s)
    // Stored as list for consistency when I work on multi-player
    private List<ScoreCard> scoreCards = new ArrayList();
    
    //**************************************************************************

    /**
     *
     * @param playerName
     * @param players
     */
    public Game(String[] playerName, int players) {
        
        // Initialize score categories
        this.setUp();
        
        // Initialize scoreCards
        for(int i = 0; i < players; i++){
            ScoreCard player = new ScoreCard(playerName[i], scores);
            this.scoreCards.add(player);
        }
    } // End constructor
    
    //**************************************************************************
    
    private void setUp(){
        
        // Initialize Categories
        ScoreCategory aces = new Ones();
        ScoreCategory twos = new Twos();
        ScoreCategory threes = new Threes();
        ScoreCategory fours = new Fours();
        ScoreCategory fives = new Fives();
        ScoreCategory sixes = new Sixes();
        ScoreCategory threeKind = new ThreeOfKind();
        ScoreCategory fourKind = new FourOfKind();
        ScoreCategory fullHouse = new FullHouse();
        ScoreCategory smStraight = new SmallStraight();
        ScoreCategory lgStraight = new LargeStraight();
        ScoreCategory yahtz = new YahtzeeCard();
        ScoreCategory chance = new Chance();
        
        // Put categories in a list
        this.scores.add(aces);
        this.scores.add(twos);
        this.scores.add(threes);
        this.scores.add(fours);
        this.scores.add(fives);
        this.scores.add(sixes);
        this.scores.add(threeKind);
        this.scores.add(fourKind);
        this.scores.add(fullHouse);
        this.scores.add(smStraight);
        this.scores.add(lgStraight);
        this.scores.add(yahtz);
        this.scores.add(chance);
        
    } // End method private void setUp()
    
    //**************************************************************************
    
    /**
     *
     * @return ScoreCard
     */
    public List getScoreCards(){
        return this.scoreCards;
    }
    
    //**************************************************************************
    
    /**
     *
     * @return List
     */
    public List getCategories(){
        return this.scores;
    }
    
    public int getScore(int i){
        ScoreCard player = scoreCards.get(i);
        return player.getFinalScore();
    }
    
    
} // End public class Game

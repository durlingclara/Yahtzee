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
     * @param player1
     */
    public Game(String player1) {
        
        // Initialize score categories
        this.setUp();
        
        // Initialize scoreCard
        ScoreCard p1 = new ScoreCard(player1, scores);
        this.scoreCards.add(p1);
    } // End constructor for one player
    
    //**************************************************************************

    /**
     *
     * @param player1
     * @param player2
     */
    public Game(String player1, String player2) {
        
        // Initialize score categories
        this.setUp();
        
        // Initialize scorecards and put into list
        ScoreCard p1 = new ScoreCard(player1, scores);
        ScoreCard p2 = new ScoreCard(player2, scores);
        scoreCards.add(p1);
        scoreCards.add(p2);
    } // End constructor for two players
    
    //**************************************************************************

    /**
     *
     * @param player1
     * @param player2
     * @param player3
     */
    public Game(String player1, String player2, String player3) {
        
        // Initialize score categories and die
        this.setUp();
        
        // Initialize scorecards and put into list
        ScoreCard p1 = new ScoreCard(player1, scores);
        ScoreCard p2 = new ScoreCard(player2, scores);
        ScoreCard p3 = new ScoreCard(player3, scores);
        scoreCards.add(p1);
        scoreCards.add(p2);
        scoreCards.add(p3);
    } // End Constructor for three players
    
    //**************************************************************************

    /**
     *
     * @param player1
     * @param player2
     * @param player3
     * @param player4
     */
    public Game(String player1, String player2, String player3, String player4) {
        
        // Initialize score categories and die
        this.setUp();
        
        // Initialize scorecards and put into list
        ScoreCard p1 = new ScoreCard(player1, scores);
        ScoreCard p2 = new ScoreCard(player2, scores);
        ScoreCard p3 = new ScoreCard(player3, scores);
        ScoreCard p4 = new ScoreCard(player4, scores);
        scoreCards.add(p1);
        scoreCards.add(p2);
        scoreCards.add(p3);
        scoreCards.add(p4);
    } // End constructor for four players
    
    //**************************************************************************

    /**
     *
     * @param player1
     * @param player2
     * @param player3
     * @param player4
     * @param player5
     */
    public Game(String player1, String player2, String player3, String player4, 
            String player5) {
        
        // Initialize score categories and die
        this.setUp();
        
        // Initialize scorecards and put into list
        ScoreCard p1 = new ScoreCard(player1, scores);
        ScoreCard p2 = new ScoreCard(player2, scores);
        ScoreCard p3 = new ScoreCard(player3, scores);
        ScoreCard p4 = new ScoreCard(player4, scores);
        ScoreCard p5 = new ScoreCard(player5, scores);
        scoreCards.add(p1);
        scoreCards.add(p2);
        scoreCards.add(p3);
        scoreCards.add(p4);
        scoreCards.add(p5);
    } // End constructor for five players
    
    //**************************************************************************

    /**
     *
     * @param player1
     * @param player2
     * @param player3
     * @param player4
     * @param player5
     * @param player6
     */
    public Game(String player1, String player2, String player3, String player4, 
            String player5, String player6) {
        
        // Initialize score categories and die
        this.setUp();
        
        // Initialize scorecards and put into list
        ScoreCard p1 = new ScoreCard(player1, scores);
        ScoreCard p2 = new ScoreCard(player2, scores);
        ScoreCard p3 = new ScoreCard(player3, scores);
        ScoreCard p4 = new ScoreCard(player4, scores);
        ScoreCard p5 = new ScoreCard(player5, scores);
        ScoreCard p6 = new ScoreCard(player6, scores);
        scoreCards.add(p1);
        scoreCards.add(p2);
        scoreCards.add(p3);
        scoreCards.add(p4);
        scoreCards.add(p5);
        scoreCards.add(p6);
    } // End constructor for 6 players
    
    // End of constructors
    
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
        ScoreCard player = scoreCards.get(i-1);
        return player.getFinalScore();
    }
    
    
} // End public class Game

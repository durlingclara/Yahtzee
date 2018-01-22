/*******************************************************************************
 * YahtzeeCard.java 
 * Author: Clara Durling
 * 
 * This class is for the Yahtzee location on the score sheet
 * This class accepts a sequence of dice values and calculates the proper score
 ******************************************************************************/
package scorecategories;

import java.util.List;

/**
 *
 * @author Clara Durling
 */
public class YahtzeeCard extends ScoreCategory {
    
    private final String name = "yahtzee";
    private final boolean available = true;
    private int score;

    /**
     *
     */
    public YahtzeeCard() {
        score = 0;
    }
    
    /**
     *
     * @param die
     * @return int
     */
    @Override
    public int scorer(List<Integer> die) {
        boolean qualifies = qualify(die);
        if (qualifies) {
            if(score == 0){
                score = 50;
            } else {
                score += 100;
            }   
        } else {
            score = 0;
        }
        
        return score;
    }
    
    private boolean qualify(List<Integer> die){
        boolean qualifies = false;
        
        int d1 = die.get(0);
        int d2 = die.get(1);
        int d3 = die.get(2);
        int d4 = die.get(3);
        int d5 = die.get(4);
        
        // If all the die have the same value, it qualifies
        if( (d2 == d1) && (d3 == d1) && (d4 == d1) && (d5 == d1) ){
            qualifies = true;
        }
        
        return qualifies;
    }

    /**
     *
     * @return String
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @return boolean
     */
    @Override
    public boolean getAvailability() {
        return available;
    }
    
}

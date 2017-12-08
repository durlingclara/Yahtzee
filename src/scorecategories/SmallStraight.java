/*******************************************************************************
 * SmallStraight.java 
 * Author: Clara Durling
 * 
 * This class is for the Small Straight location on the score sheet
 * This class accepts a sequence of dice values and calculates the proper score
 ******************************************************************************/
package scorecategories;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author Clara Durling
 */
public class SmallStraight extends ScoreCategory {
    
    // scorer doesn't work if there are two of a number in the middle of the straight
    
    private final String name = "SmallStraight";
    private boolean available;
    private int score;

    public SmallStraight() {
        this.available = true;
        this.score = 0;
    }

    
    /**
     *
     * @param die
     * @return int
     */
    @Override
    public int scorer(List<Integer> die) {
        boolean qualifies = qualify(die);
        if(qualifies){
            score = 30;
        } else {
            score = 0;
        }
        available = false;
        return score;
    }
    
    private boolean qualify(List<Integer> die){
        boolean qualifies = false;
        Collections.sort(die);
        
        int d1 = die.get(0);
        int d2 = die.get(1);
        int d3 = die.get(2);
        int d4 = die.get(3);
        int d5 = die.get(4);
        
        if( (d2 == (d1+1)) && (d3 == (d2+1)) && (d4 == (d3+1)) ){
            qualifies = true;
        } else if ( (d3 == (d2+1)) && (d4 == (d3+1)) && (d5 == (d4+1)) ) {
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

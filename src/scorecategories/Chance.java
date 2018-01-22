/*******************************************************************************
 * Chance.java 
 * Author: Clara Durling
 * 
 * This class is for the Chance location on the score sheet
 * This class accepts a sequence of dice values and calculates the proper score
 ******************************************************************************/
package scorecategories;

import java.util.List;

/**
 *
 * @author Clara Durling
 */
public class Chance extends ScoreCategory {
    
    private final String name = "chance";
    private boolean available;
    private int score;

    /**
     *
     */
    public Chance() {
        available = true;
        score = 0;
    }
    
    /**
     *
     * @param die
     * @return int
     */
    @Override
    public int scorer(List<Integer> die) {
        
        // Add together the value of all die
        for(int i = 0; i < die.size(); i++){
            score += die.get(i);
        }
        available = false;
        return score;
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

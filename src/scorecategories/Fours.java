/*******************************************************************************
 * Fours.java 
 * Author: Clara Durling
 * 
 * This class is for the Fours location on the score sheet
 * This class accepts a sequence of dice values and calculates the proper score
 ******************************************************************************/
package scorecategories;

import java.util.List;

/**
 *
 * @author Clara Durling
 */
public class Fours extends ScoreCategory {
    
    private final String name = "Fours";
    private boolean available;
    private int score;
    
    /**
     *
     */
    public Fours() {
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
        for(int i = 0; i < die.size(); i++){
            if(die.get(i) == 4){
                score += 4;
            }
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

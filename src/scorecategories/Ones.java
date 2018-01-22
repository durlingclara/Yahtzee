/*******************************************************************************
 * Ones.java 
 * Author: Clara Durling
 * 
 * This class is for the Ones location on the score sheet
 * This class accepts a sequence of dice values and calculates the proper score
 ******************************************************************************/
package scorecategories;

import java.util.List;

/**
 *
 * @author Clara Durling
 */
public class Ones extends ScoreCategory{
    private final String name = "aces";
    private int score;
    private boolean available;
    
    /**
     *
     */
    public Ones(){
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
        
        // Add the sum of all die with value one
        for(int i = 0; i < die.size(); i++){
            if(die.get(i) == 1){
                score++;
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

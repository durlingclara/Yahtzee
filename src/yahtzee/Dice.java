/*******************************************************************************
 * Dice.java
 * Author: Clara Durling
 * 
 * This class defines a dice and it's functions.
 ******************************************************************************/
package yahtzee;

import java.util.Random;

/**
 *
 * @author Clara Durling
 */
public class Dice {
    
    private int value;

    /**
     *
     */
    public Dice() {
        this.value = 0;
    }

    /**
     *
     * @return Integer
     */
    public int value() {
        return value + 1;
    }

    /**
     *
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    /**
     *
     */
    public void roll() {
        Random rand = new Random(); 
        int random = rand.nextInt(6);
        this.value = random;
    }
    
} // End public class Dice

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scorecategories;

import java.util.List;

/**
 *
 * @author whovianhalfblood
 */
public abstract class ScoreCategory {
    public abstract int scorer(List<Integer> die);
    public abstract String getName();
    public abstract boolean getAvailability();
}

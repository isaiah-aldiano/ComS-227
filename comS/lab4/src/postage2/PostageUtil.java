package postage2;

public class PostageUtil
{
  /**
   * Returns the cost of postage for a letter of the given weight.
   * @param weight
   *   given weight in ounces
   * @return
   *   cost of postage for the weight
   *   
   *   
   *   This if catches all values that would trigger weight > 3.5, so any value > 3.5 breaks this because it is caught at weight > 1 and won't compute rule 5
   */
  public static double computePostage(double weight)
  {
	double cost = 0.0;
	double calcWeight = Math.ceil(weight - 1);
	
    if(weight <= 1) {
    	cost = .47;
    } else { 
	    if (weight > 1) { 
	    	cost = .47 + calcWeight * .21;
	    } else {
	    	if (weight > 3.5) {
	    		cost = .94 + calcWeight * .21;
	    	} else {
		    	cost = .47 + calcWeight * .21;
	    	}
	    }
    }
    return cost;
  }
}
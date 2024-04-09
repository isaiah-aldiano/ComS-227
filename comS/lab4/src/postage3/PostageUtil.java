package postage3;

public class PostageUtil
{
  /**
   * Returns the cost of postage for a letter of the given weight.
   * @param weight
   *   given weight in ounces
   * @return
   *   cost of postage for the weight
   *   
   *   First if weight > 1 catches all values that would trigger weight > 3.5, but any value > 3.5 would break this because it doesn't implement the 5th rule
   */
  public static double computePostage(double weight)
  {
	double cost = .47;
	double calcWeight = Math.ceil(weight - 1);
	
    if(weight > 1) { //
    	cost += calcWeight * .21;
    } 
    if (weight > 3.5) {
	    cost += .47;
	} 
  
    return cost;
  }
}
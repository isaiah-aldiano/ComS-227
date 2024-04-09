package lab4;

public class PiggyBankExample
{

  /**
   * @param args
   * 
   * Piggy bank wasn't adding coins to the amount, only setting coins variable to the amount of coins being added
   * Also piggy.isSmashed() was using the assignment operand vs the comparison operand
   */
  public static void main(String[] args)
  {
    PiggyBank piggy = new PiggyBank(5);
    piggy.addCoins(1);
    piggy.addCoins(1);
    System.out.println("Should contain 2 coins: " + piggy.getNumCoins());
    System.out.println("Should be false (not smashed): " + piggy.isSmashed());
    piggy.addCoins(1);
    System.out.println("Should now contain 3 coins: " + piggy.getNumCoins());
  }

}

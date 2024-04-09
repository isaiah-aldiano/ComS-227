package lab7;

public class ArraySum
{
  /**
   * Try it out.
   */
  public static void main(String[] args)
  {
    int[] test = {3, 4, 5, 1, 2, 3, 2}; // sum should be 20
    int result = arraySum(test);
    System.out.println(result);
    
    int largest = divide_conquer(test, 0, test.length - 1);
    System.out.println(largest);
    
    int count = getPyramidCount(4);
    System.out.print(count);
  }

  /**
   * Returns the sum of all array elements.
   */
  public static int arraySum(int[] arr)
  {
    return arraySumRec(arr, 0, arr.length - 1);
  }
  
  /**
   * Returns the sum of array elements from start to end, inclusive.
   */
  private static int arraySumRec(int[] arr, int start, int end)
  {
    if (start == end)
    {
      return arr[start];
    }
    else
    {
      int mid = (start + end) / 2;
      int leftSum = arraySumRec(arr, start, mid);
      int rightSum = arraySumRec(arr, mid + 1, end);
      return leftSum + rightSum;
    }
  }
  
  private static int divide_conquer(int[] arr, int start, int end) {
	  int largest = 0;
	  
	  if(start == end)
	  {
		  return arr[start];
	  } else {
		  int mid = (start + end) / 2;
		  int leftSum = divide_conquer(arr, start, mid);
		  int rightSum = divide_conquer(arr, mid + 1, end);
		  if (leftSum >= rightSum) {
			  largest = leftSum;
		  } else {
			  largest = rightSum;
		  }
	  }
	  
	  return largest;
  }
  
  private static int getPyramidCount(int levels) {
	  int count = 0;
	  
	  if(levels == 1) {
		  count = 1;
	  } else {
		  count += (levels * levels) + getPyramidCount(levels - 1);
	  }
	  
	  return count;
  }
}
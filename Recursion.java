import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
public class Recursion {

	
	private static int maxVal;
	private static int count;
	private static int negCount;

	public static void main (String[]args) throws IOException
	{
		Scanner input = new Scanner(System.in);     //Scanner class to take in user input
		int[] numStore = new int[10];               //Define array length of 10                                 //Increment recursion with count
		int num = input.nextInt();                  //Number is the next input passed as integer
		
		fillArray(num, numStore, 0);				//Run recursive function to fill the array list
		
		negCount = 0;
		
		maxVal = numStore[0];						//Pre-define max value as the first value in array list
		
		System.out.println("Array has been filled with recursivity"); //Success message
		
		System.out.println("The maximum value in the list is: " + maxValCalc(numStore, 1, maxVal)); 	  //Print out the maximum value in the array list
	
		System.out.println("Number of negatives is: " + countNegs(numStore, negCount, 0));
	}
	
	public static int[] fillArray(int num, int [] array, int count) //Recursive method to fill the array
	{
		Scanner input = new Scanner(System.in);
		
		if (num!=0 && count < array.length-2)
		{
			array[count] = num;
			num = input.nextInt();
			return fillArray(num, array, count+1);
		}
		else if(num == 0)
			return array;
		return array;
	}
	
	
	public static int maxValCalc(int [] array, int count, int maxVal) //Method to count the maximum amount of values
	{
		if (array[count] != 0 && count < array.length-2)
		{
			if (array[count] > maxVal && array[count] != 0)
			{
				maxVal = array[count];
				return maxValCalc(array, count + 1, maxVal);
			}
			
			else
			{
				return maxValCalc(array, count+1, maxVal);
			}
		}
		return maxVal;
	}
	
	
	public static int countNegs(int [] array, int negs, int elementNum) //Method to count the amount
	
	{
		if (array[elementNum] != 0 && elementNum < array.length-2)
		{
			if (array[elementNum] < 0 && elementNum < array.length-2 && array[elementNum] != 0) 
				//If the current element in the array is less than 0 and...
				//The current element count doesn't exceed the actual length of the array and...
				//The current element in the array doesn't == 0 then execute the following code.
					
					return countNegs(array, negs + 1 , elementNum + 1);
	
					//Once the negative counter is incremented, rerun the method to check again
					//The rerun is different because the element number is comparing against the next element (one more than the previous)
			
			
			else
					return countNegs(array, negs, elementNum+1);
		}
		
		return negs;
	}
}
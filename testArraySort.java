import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

public class testArray {
	
	static ArrayList<Integer []> origArrays = new ArrayList<Integer []>();
	static ArrayList<Integer []> sortedArrays = new ArrayList<Integer []>();
	
    @BeforeClass 
    public static void createArrays() {
    	
    	Random rand = new Random();
		
		Integer[] zeroLenArr = new Integer[0];
		origArrays.add(zeroLenArr);
		Arrays.sort(zeroLenArr);
		sortedArrays.add(zeroLenArr);	
		
		Integer[] sameValueArr = {5,5,5,5,5,5,5};
		origArrays.add(sameValueArr);
		Arrays.sort(sameValueArr);
		sortedArrays.add(sameValueArr);
		
		Integer[] negValueArr = {-1,-3, 4, -2};
		origArrays.add(negValueArr);
		Arrays.sort(negValueArr);
		sortedArrays.add(negValueArr);
		
		Integer[] negPosArr = {1, -10, 3, 0, -2};
		origArrays.add(negPosArr);
		Arrays.sort(negPosArr);
		sortedArrays.add(negPosArr);
		
		
		int newArraySize = 0;
		Integer currArr[];
		
		for(int i=0; i<95; i++)
		{		
			newArraySize = rand.nextInt(50);
			currArr = new Integer[newArraySize];
			
			for(int ii=0; ii<currArr.length; ii++)
			{
				currArr[ii] = rand.nextInt();
			}
			
			origArrays.add(currArr);
			Arrays.sort(currArr);
			sortedArrays.add(currArr);			
		}
		

    }
	


	// test that when the array is sorted that the length of the array does not change
    @Test
	public void testSortLength(){
		
		boolean equalLengths = true;
		int origArrLen = 0, sortedArrLen = 0;
		
		for(int i=0; i<origArrays.size(); i++)
		{
			origArrLen = origArrays.get(i).length;
			sortedArrLen = sortedArrays.get(i).length;
			
			if(origArrLen != sortedArrLen){
				equalLengths = false;
				break;
			}
			
		}
		
		assertTrue(equalLengths);
	}
	
	// test that all values of the original array are in the sorted array
    @Test
	public void testValues(){
		
		boolean sortedContainsAllValues = true;
		Integer currOrigArr [], currSortedArr [];
		int currOrigArrVal, currSortedArrVal;
		
		
		for(int i=0; i<origArrays.size() && sortedContainsAllValues; i++)
		{
			currOrigArr = origArrays.get(i);
			currSortedArr = sortedArrays.get(i);
			
			for(int ii=0; ii<currOrigArr.length; ii++)
			{
				currOrigArrVal = currOrigArr[ii];
				
				boolean sortedArrContainsVal = false;
				for(int iii=0; iii<currSortedArr.length; iii++)
				{
					currSortedArrVal = currSortedArr[iii];
					
					if(currSortedArrVal == currOrigArrVal)
					{
						sortedArrContainsVal = true;
						break;
					}
				}
					
				if(!sortedArrContainsVal){
					sortedContainsAllValues = false;
				}
				
			}
		}
		
		assertTrue(sortedContainsAllValues);
	}
	
    // test that values in sorted arrays are increasing
	@Test
	public void testSortedArraysIncreasing()
	{
		
		boolean valuesIncreasing = true;
		int prevVal, currVal;
		
		for(int i=0; i<sortedArrays.size() && valuesIncreasing; i++)
		{
			Integer [] currSortedArr = sortedArrays.get(i);
			
			if(currSortedArr.length == 0){
				continue;
			}
			
			prevVal = currSortedArr[0];
			
			for(int ii=1; ii<currSortedArr.length; ii++)
			{
				currVal = currSortedArr[ii];
				
				if(prevVal > currVal)
				{
					valuesIncreasing = false;
					break;
				}
				
				prevVal = currVal;
			}
		}
		
		assertTrue(valuesIncreasing);
	}
}













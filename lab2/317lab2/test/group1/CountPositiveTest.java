package group1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountPositiveTest {

	@Test public void arrayContainsZeroes() 
	   {
	      int arr[] = {0, -4, 2, -1, 2, 0};
	      assertEquals("Array contains zeroes",2, CountPositive.countPositive(arr));
	   }

}

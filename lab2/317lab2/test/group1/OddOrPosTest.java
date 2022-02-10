package group1;

import static org.junit.Assert.*;

import org.junit.Test;

public class OddOrPosTest {

	@Test
	public void negativeOddNumbers() 
	   {
	      int arr[] = {1, 2, -3};
	      assertEquals("Negative odd numbers in array", 3, OddOrPos.oddOrPos(arr));
	   }

}

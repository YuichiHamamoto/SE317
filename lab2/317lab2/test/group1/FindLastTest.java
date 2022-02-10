package group1;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindLastTest {

	@Test
	 public void lastOccurrenceInFirstElement() 
	   {
	      int arr[] = {3, 2, 5};
	      int y = 3;
	      assertEquals("Last occurence in first element", 0, FindLast.findLast(arr, y));
	   }

}

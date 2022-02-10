package group1;

import static org.junit.Assert.*;

import org.junit.Test;

public class lastZeroTest {

	@Test 
	public void multipleZeroes() {
		int arr[] = {0, 1, 0};
	    assertEquals("Multiple zeroes: should find last one", 2, lastZero.lastZero(arr));
	}

}

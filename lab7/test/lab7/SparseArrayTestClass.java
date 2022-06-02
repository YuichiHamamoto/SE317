package lab7;

import org.junit.*;

import lab5.Tharmo;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class SparseArrayTestClass {
	private SparseArray<Object> array;
	@Before
	public void create() {
		array = new SparseArray<>();
	}
	
	@Test 
	public void handlesInsertionInDescendingOrder() { 
	array.put(7, "seven");  
	array.checkInvariants();
	array.put(6, "six");  
	array.checkInvariants();
	assertThat(array.get(6), equalTo("six")); 
	assertThat(array.get(7), equalTo("seven")); 
	} 
	
	@Test 
	public void nullTest() {
		array.put(0, null); 
		array.checkInvariants();
		assertTrue(array.size()==0); 
	}
	
	@Test 
	public void sixTest() {
		array.put(6, "seis");  
		array.put(6, "six");  
		assertThat(array.get(6), equalTo("six")); 
	}
	     
}

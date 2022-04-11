package lab5;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class test {
	private Tharmo t;
	
	@Before
	public void create() {
		t = new Tharmo();
	}
	
	@Test 
	public void currentTest1() throws Exception {
		t.read(0,0);
		assertTrue(t.curT==0&&t.curH==0);
	}
	
	@Test 
	public void currentTest2() throws Exception {
		t.read(125,100);
		assertTrue(t.curT==125&&t.curH==100);
	}
	
	@Test 
	public void currentTest3() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			t.read(-1,-1);
		});
	}
	@Test 
	public void currentTest4() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			t.read(126,100);
		});
	}
	
	
	@Test
	public void maxTest1() throws Exception{
		t.read(0,0);
		assertTrue(t.maxT==0&&t.maxH==0);
	}
	
	@Test
	public void maxTest2() throws Exception{
		t.read(0,0);
		t.read(125,100);
		assertTrue(t.maxT==125&&t.maxH==100);
	}
	
	@Test
	public void maxTest3() throws Exception{
		t.read(0,0);
		t.read(125,100);
		t.read(50,50);
		assertTrue(t.maxT==125&&t.maxH==100);
	}
	
	@Test
	public void minTest1() throws Exception{
		t.read(125,100);
		assertTrue(t.minT==125&&t.minH==100);
	}
	
	@Test
	public void minTest2() throws Exception{
		t.read(125,100);
		t.read(0,0);
		assertTrue(t.minT==0&&t.minH==0);
	}
	
	@Test
	public void minTest3() throws Exception{
		t.read(125,100);
		t.read(0,0);
		t.read(50,50);
		assertTrue(t.minT==0&&t.minH==0);
	}
	
	@Test
	public void trendTest1()throws Exception{
		t.read(0,0);
		assertTrue(t.getTrend(t.trendT).equals("N/A")&&t.getTrend(t.trendH).equals("N/A"));
	}
	
	@Test
	public void trendTest2()throws Exception{
		t.read(0,1);
		t.read(1,0);
		assertTrue(t.getTrend(t.trendT).equals("up")&&t.getTrend(t.trendH).equals("down"));		
	}
	
	@Test
	public void trendTest3()throws Exception{
		t.read(1,0);
		t.read(0,1);
		assertTrue(t.getTrend(t.trendT).equals("down")&&t.getTrend(t.trendH).equals("up"));		
	}
	
	@Test
	public void trendTest4()throws Exception{
		t.read(0,0);
		t.read(0,0);
		assertTrue(t.getTrend(t.trendT).equals("stable")&&t.getTrend(t.trendH).equals("stable"));		
	}
	
}

package lab6;
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class BearingTest {
	   	   
	   @Test
	   public void answersValidBearing() {
	      assertThat(new Bearing(Bearing.MAX).value(), equalTo(Bearing.MAX));
	   }
	   
	   @Test
	   public void answersAngleBetweenItAndAnotherBearing() {
	      assertThat(new Bearing(15).angleBetween(new Bearing(12)), equalTo(3));
	   }
	   
	   @Test
	   public void angleBetweenIsNegativeWhenThisBearingSmaller() {
	      assertThat(new Bearing(12).angleBetween(new Bearing(15)), equalTo(-3));
	   }
	   
}

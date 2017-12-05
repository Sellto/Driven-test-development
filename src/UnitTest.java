import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class UnitTest {
	  @Test
	  void test1(){
	    Sensors sensors;
		sensors=new Sensors(0);
		sensors.addName("Place 21");
//		assertEquals("Si date de naissance 1992", person.age(), 25);
		assertEquals("Place 21 doit être initialisé à false", sensors.getState("Place 21"), false);
	  }
}

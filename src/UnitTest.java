
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;


public class UnitTest {
  Sensors sensors;
  Parking parking;
  Map<String,Boolean> hash = new HashMap<String, Boolean>();

  @Test
  void test1(){
	  sensors=new Sensors(0);
	  sensors.addName("Place 21");
	  assertEquals(sensors.getState("Place 21"), false);
	  sensors=null;
  }
  @Test
  void test2() {
	  sensors = new Sensors(1);
	  hash = new HashMap<String, Boolean>();
	  hash.put("Place 1", false);
	  assertEquals(sensors.getChange(), hash);
	  sensors=null;
  }
  @Test
  void test3() {
	  sensors = new Sensors(1);
	  hash = new HashMap<String, Boolean>();
	  hash.put("Place 1", true);
	  sensors.changeState("Place 1", true);
	  assertEquals(sensors.getChange(), hash);
	  sensors=null;
	  hash=null;
  }
  @Test
  void test4() {
	  sensors = new Sensors(4);
	  hash = new HashMap<String, Boolean>();
	  hash.put("Place 1", false);
	  hash.put("Place 2", false);
	  hash.put("Place 3", false);
	  hash.put("Place 4", false);
	  assertEquals(sensors.getChange(), hash);
	  sensors=null;
	  hash=null;
  }
  @Test
  void test5(){
	sensors = new Sensors(6);
	parking=new Parking();
	parking.update(sensors.getChange());
	assertEquals(parking.numberFreeSpaces(), 6);
	sensors=null;
	parking=null;
  }
  @Test
  void test6(){
	parking=new Parking();
	parking.setCode("test");
	assertEquals(parking.checkCode(), true);
	parking=null;
  }
}

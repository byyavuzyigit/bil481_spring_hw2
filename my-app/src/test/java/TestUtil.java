import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void example() { assertTrue(true); }

  @Test
  public void testArgsLengthEquals1(){
    int[] args = new int[1];
    assertFalse(c.compute(args));
  }

  @Test
  public void testArgsLengthIsEven(){
    int[] args = new int[10];
    assertFalse(c.compute(args));
  }

  @Test
  public void testException(){
    int[] args = {1,2,0};
    boolean exception = false;
    try{
      c.compute(args);
    } catch(RuntimeException e){
        exception = true;
    }
    assertTrue(exception);
  }

  @Test
  public void testSumModArgs(){
    int[] args = {2,2,2,2,2};
    assertTrue(c.compute(args));
  }

  @Test
  public void testSumNotModArgs(){
    int[] args = {2,2,2,2,3};
    assertFalse(c.compute(args));
  }

}
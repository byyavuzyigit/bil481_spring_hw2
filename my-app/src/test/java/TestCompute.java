import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestCompute {
  Compute c;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    assertTrue(true);
  }

  @Test
  public void testMQSizeIsZero(){
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(0);
    c = new Compute(mq);
    assertEquals(c.countNumberOfOccurrences(""),-1);
  }

  @Test
  public void testMQNotContainsStr(){
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(1);
    when(mq.contains("")).thenReturn(false);
    c = new Compute(mq);
    assertEquals(c.countNumberOfOccurrences(""),0);
  }

  @Test
  public void testCounter(){
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(3);
    when(mq.contains("a")).thenReturn(true);
    when(mq.getAt(0)).thenReturn("a");
    when(mq.getAt(1)).thenReturn("a");
    when(mq.getAt(2)).thenReturn("b");
    c = new Compute(mq);
    assertEquals(c.countNumberOfOccurrences("a"),2);
  }
}
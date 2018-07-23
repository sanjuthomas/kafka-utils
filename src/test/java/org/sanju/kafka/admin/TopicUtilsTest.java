package org.sanju.kafka.admin;

import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Test;
import org.sanju.kafka.AbstractTest;

/**
 *
 * @author Sanju Thomas
 *
 */
public class TopicUtilsTest extends AbstractTest {

  @Test
  public void shouldGetAllTopics() {
    final Iterator<String> topics = super.util.allTopics().keySet().iterator();
    assertEquals("PABN", topics.next());
    assertEquals("PANA", topics.next());
    assertEquals("PAOU", topics.next());
  }

}

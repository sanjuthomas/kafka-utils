package org.sanju.kafka.metrics;

import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.sanju.kafka.AbstractTest;
import org.sanju.kafka.admin.IntegrationTest;

/**
 *
 * @author Sanju Thomas
 *
 */

@Category(IntegrationTest.class)
public class KafkaMetadataTest extends AbstractTest {

  private KafkaMetadata collector;

  @Override
  @Before
  public void setup() {
    super.setup();
    this.collector = new KafkaMetadataImpl(super.util, super.util.adminClient());
  }

  @Test
  public void shouldGetAllTopics() {
    final Iterator<String> topics = this.collector.topics().iterator();
    assertEquals("PABN", topics.next());
    assertEquals("PANA", topics.next());
    assertEquals("PAOU", topics.next());
  }

  @Test
  public void shouldGetAllGroups() {
    System.out.println(this.collector.groups());
  }

}

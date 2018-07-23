package org.sanju.kafka.metrics;

import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.sanju.kafka.AbstractTest;
import org.sanju.kafka.admin.IntegrationTest;

/**
 *
 * @author Sanju Thomas
 *
 */

@Category(IntegrationTest.class)
public class KafkaMetricsCollectorTest extends AbstractTest {

  private KafkaMetadata collector;

  @Override
  @Before
  public void setup() {
    super.setup();
    this.collector = new KafkaMetadataImpl(super.util, super.util.adminClient());
  }

}

package org.sanju.kafka.utils.broker;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.sanju.kafka.utils.AbstractTest;
import org.sanju.kafka.utils.IntegrationTest;
import org.sanju.kafka.utils.MetricsCollector;

/**
 *
 * @author Sanju Thomas
 *
 */

@Category(IntegrationTest.class)
public class TestKafkaMetricsCollector extends AbstractTest {

  private MetricsCollector collector;

  @Override
  @Before
  public void setup() {
    super.setup();
    this.collector = new BrokerMetricsCollector();
  }

  @Test
  public void shouldFindAllTopics() {
    this.collector.topics(this.util.kafkaHost());
  }

}

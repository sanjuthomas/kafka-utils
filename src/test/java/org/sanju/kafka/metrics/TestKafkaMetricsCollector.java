package org.sanju.kafka.metrics;

import org.junit.After;
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
    System.out.println(this.collector.topics(super.util.kafkaHost()));
  }

  @Override
  @After
  public void tearDown() {
    super.tearDown();
  }

}

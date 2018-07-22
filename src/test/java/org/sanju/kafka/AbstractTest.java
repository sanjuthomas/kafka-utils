package org.sanju.kafka;

import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.sanju.kafka.admin.TopicUtils;
import com.google.common.collect.ImmutableSet;

/**
 *
 * @author Sanju Thomas
 *
 */
public class AbstractTest {

  private final Set<String> topics = ImmutableSet.of("PABN", "PANA", "PAOU", "PANN");
  protected TopicUtils util;

  @Before
  public void setup() {
    this.util = new TopicUtils("localhost:9092", "localhost:2181");
    this.setupTopics();
  }

  private void setupTopics() {
    this.util.createTopics(this.topics);
  }

  @After
  public void tearDown() {
    this.util.deleteTopcis(this.topics);
  }

}

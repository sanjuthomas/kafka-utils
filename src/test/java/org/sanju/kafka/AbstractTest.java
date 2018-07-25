package org.sanju.kafka;

import java.util.Properties;
import java.util.Set;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
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

  private final Set<String> consumers = ImmutableSet.of("CNN", "CNBC", "FOX", "ESPN");
  private final Set<String> topics = ImmutableSet.of("PABN", "PANA", "PAOU", "PANN");
  protected TopicUtils util;

  @Before
  public void setup() {
    this.util = new TopicUtils("localhost:9092", "localhost:2181");
    this.setupTopics();
    this.setupConsumers();
  }

  private void setupConsumers() {
    this.consumers.forEach(c -> {
      final Consumer<Long, String> consumer = this.createConsumer(c);
      consumer.subscribe(this.topics);
    });
  }

  private void setupTopics() {
    this.util.createTopics(this.topics);
  }

  @After
  public void tearDown() {
    this.util.deleteTopcis(this.topics);
  }

  private void produceSampleMessages() {

  }

  private Consumer<Long, String> createConsumer(final String consumerName) {
    final Properties props = new Properties();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerName);
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    final Consumer<Long, String> consumer = new KafkaConsumer<>(props);
    return consumer;
  }
}

package org.sanju.kafka.metrics;

import java.util.Set;
import org.apache.kafka.common.TopicPartition;

/**
 *
 * @author Sanju Thomas
 *
 */
public interface KafkaMetadata {


  /**
   * Collect all the consumer groups from the broker.
   *
   * @param broker
   * @return
   */
  Set<String> groups();

  /**
   * Collect the lag for the given topic's all partitions from the broker.
   *
   * @param broker
   * @param topic
   * @return
   */
  long lag(String topic);


  /**
   *
   * Collect the lag for the given topic and partition from the broker.
   *
   * @param broker
   * @param topic
   * @param partition
   * @return
   */
  long lag(String topic, int partition);


  /**
   * Collect the lag for the given group, and topic from the broker.
   *
   * @param broker
   * @param group
   * @param topic
   * @return
   */
  long lag(String group, String topic);


  /**
   * Collect the lag for the given group, topic, and partition from the broker.
   *
   * @param broker
   * @param group
   * @param topic
   * @param partition
   * @return
   */
  long lag(String group, String topic, int partition);


  /**
   * Find the leader for the given topic and partition from the broker.
   *
   * @param broker
   * @param topic
   * @param partition
   * @return
   */
  String leader(String topic, String partition);


  /**
   * Collect the end offset of the given topic from the broker.
   *
   * @param broker
   * @param topic
   * @return
   */
  long logSize(String topic);


  /**
   * Collect the current offset of the given topic from the broker.
   *
   * @param broker
   * @param group
   * @param topic
   * @param offset
   * @return
   */
  long offset(String group, String topic, int offset);


  /**
   * Collect the owner of the given topic and partition from the broker.
   *
   * @param broker
   * @param topic
   * @param partition
   * @return
   */
  String owner(final String group, String topic, int partition);


  /**
   * Collect all the topics from the broker.
   *
   * @param broker
   * @return
   */
  Set<String> topics();


  /**
   * Collect all the topics for the given consumer group from the broker.
   *
   * @param broker
   * @param consumerGroup
   * @return
   */
  Set<String> topics(String group);


  /**
   * Collect all the TopicPartitions from the broker.
   *
   * @param broker
   * @return
   */
  Set<TopicPartition> topicsPartitions();

  /**
   * Collect all the TopicPartition for the given consumer group from the broker.
   *
   * @param broker
   * @param consumerGroup
   * @return
   */
  Set<TopicPartition> topicsPartitions(String group);

}

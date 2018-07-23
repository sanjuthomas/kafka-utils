package org.sanju.kafka.metrics;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.kafka.common.TopicPartition;
import org.sanju.kafka.admin.TopicUtils;
import kafka.admin.AdminClient;
import kafka.admin.AdminClient.ConsumerSummary;
import scala.collection.JavaConversions;

/**
 *
 * @author Sanju Thomas
 *
 */
public class KafkaMetadataImpl implements KafkaMetadata {

  private final TopicUtils topicUtils;
  private final AdminClient adminClient;

  public KafkaMetadataImpl(final TopicUtils topicUtils, final AdminClient adminClient) {
    this.topicUtils = topicUtils;
    this.adminClient = adminClient;
  }

  @Override
  public Set<String> groups() {
    final Set<String> consumerGroups = new LinkedHashSet<>();
    JavaConversions.asJavaCollection(this.adminClient.listAllConsumerGroupsFlattened())
        .forEach(gv -> consumerGroups.add(gv.groupId()));
    return consumerGroups;
  }

  @Override
  public long lag(final String topic) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public long lag(final String topic, final int partition) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public long lag(final String group, final String topic) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public long lag(final String group, final String topic, final int partition) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public String leader(final String topic, final String partition) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public long logSize(final String topic) {

    return 0;
  }

  @Override
  public long offset(final String group, final String topic, final int offset) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public String owner(final String group, final String topic, final int partition) {
    String owner = "Not Found!";
    final Collection<ConsumerSummary> consumers = JavaConversions
        .asJavaCollection(this.adminClient.describeConsumerGroup(group, 2000).consumers().get());
    for (final ConsumerSummary consumer : consumers) {
      final Collection<TopicPartition> topicParitions =
          JavaConversions.asJavaCollection(consumer.assignment());
      if (topicParitions.stream()
          .filter(tp -> topic.equalsIgnoreCase(tp.topic()) && (partition == tp.partition()))
          .findFirst().isPresent()) {
        owner = String.format("%s-%s", consumer.clientId(), consumer.host().substring(1));
      }
    }
    return owner;
  }

  @Override
  public Set<String> topics() {
    return this.topicUtils.allTopics().keySet();
  }

  @Override
  public Set<String> topics(final String consumerGroup) {
    final Set<String> topics = new LinkedHashSet<>();
    JavaConversions
        .asJavaCollection(
            this.adminClient.describeConsumerGroup(consumerGroup, 2000).consumers().get())
        .forEach(cs -> {
          JavaConversions.asJavaCollection(cs.assignment()).forEach(a -> {
            if (!topics.contains(a.topic())) {
              topics.add(a.topic());
            }
          });
        });
    return topics;
  }

  @Override
  public Set<TopicPartition> topicsPartitions() {
    final Set<TopicPartition> topicPartitions = new LinkedHashSet<>();
    this.groups().forEach(cg -> {
      JavaConversions
          .asJavaCollection(this.adminClient.describeConsumerGroup(cg, 2000).consumers().get())
          .forEach(dcg -> {
            topicPartitions.addAll(JavaConversions.asJavaCollection(dcg.assignment()));
          });
    });
    return topicPartitions;
  }

  @Override
  public Set<TopicPartition> topicsPartitions(final String consumerGroup) {
    final Set<TopicPartition> topicPartitions = new LinkedHashSet<>();
    JavaConversions
        .asJavaCollection(
            this.adminClient.describeConsumerGroup(consumerGroup, 2000).consumers().get())
        .forEach(dcg -> {
          topicPartitions.addAll(JavaConversions.asJavaCollection(dcg.assignment()));
        });
    return topicPartitions;
  }
}

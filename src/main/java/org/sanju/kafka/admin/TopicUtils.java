package org.sanju.kafka.admin;

import java.util.Properties;
import java.util.Set;
import kafka.admin.RackAwareMode;

/**
 *
 * @author Sanju Thomas
 *
 */
public class TopicUtils extends AdminUtils {

  public TopicUtils(final String kafkaHost, final String zooKeeperHost) {
    super(kafkaHost, zooKeeperHost);
  }

  public void allTopics() {
    System.out.println(super.adminZkClient().getAllTopicConfigs());
  }

  public void createTopic(final String topic) {
    super.adminZkClient().createTopic(topic, 1, 1, new Properties(), RackAwareMode.Disabled$.MODULE$);
  }

  public void createTopics(final Set<String> topics) {
    topics.forEach(t -> this.createTopic(t));
  }

  public void deleteTopcis(final Set<String> topics) {
    topics.forEach(t -> this.deleteTopic(t));
  }

  public void deleteTopic(final String topic) {
    super.adminZkClient().deleteTopic(topic);
  }
}

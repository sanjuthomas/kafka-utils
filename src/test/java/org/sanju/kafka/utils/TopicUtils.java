package org.sanju.kafka.utils;

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

	public void createTopic(final String topic) {
		kafka.admin.AdminUtils.createTopic(super.zkUtils(), topic, 1, 1, new Properties(),
				RackAwareMode.Enforced$.MODULE$);
	}

	public void createTopics(final Set<String> topics) {
		topics.forEach(t -> this.createTopic(t));
	}

	public void deleteTopcis(final Set<String> topics) {
		topics.forEach(t -> this.deleteTopic(t));
	}

	public void deleteTopic(final String topic) {
		kafka.admin.AdminUtils.deleteTopic(super.zkUtils(), topic);
	}
}

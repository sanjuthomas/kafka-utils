package org.sanju.kafka.utils.broker;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.common.TopicPartition;
import org.sanju.kafka.utils.MetricsCollector;

import kafka.admin.AdminClient;
import kafka.admin.AdminClient.ConsumerSummary;
import scala.collection.JavaConversions;

/**
 * 
 * @author Sanju Thomas
 *
 */
public class BrokerMetricsCollector implements MetricsCollector {

	private static final Map<String, AdminClient> adminClients = new LinkedHashMap<>();

	private static AdminClient adminClient(final String broker) {

		final Properties config = new Properties();
		config.put("bootstrap.servers", broker);
		return adminClients.computeIfAbsent(broker, f -> AdminClient.create(config));
	}

	@Override
	public List<String> groups(final String broker) {

		final List<String> consumerGroups = new ArrayList<>();
		JavaConversions.asJavaList(adminClient(broker).listAllConsumerGroupsFlattened())
				.forEach(gv -> consumerGroups.add(gv.groupId()));
		return consumerGroups;
	}

	@Override
	public List<String> topics(final String broker) {

		final List<String> topics = new ArrayList<>();
		this.groups(broker).forEach(cg -> {
			topics.addAll(this.topics(broker, cg));
		});
		return topics;
	}

	@Override
	public List<String> topics(final String broker, final String consumerGroup) {

		final List<String> topics = new ArrayList<>();
		JavaConversions.asJavaList(adminClient(broker).describeConsumerGroup(consumerGroup).consumers().get())
				.forEach(cs -> {
					JavaConversions.asJavaList(cs.assignment()).forEach(a -> {
						if (!topics.contains(a.topic()))
							topics.add(a.topic());
					});
				});
		return topics;
	}

	@Override
	public List<TopicPartition> topicPartition(final String broker) {

		final List<TopicPartition> topicPartitions = new ArrayList<>();
		this.groups(broker).forEach(cg -> {
			JavaConversions.asJavaList(adminClient(broker).describeConsumerGroup(cg).consumers().get()).forEach(dcg -> {
				topicPartitions.addAll(JavaConversions.asJavaList(dcg.assignment()));
			});
		});
		return topicPartitions;
	}

	@Override
	public List<TopicPartition> topicPartition(final String broker, final String consumerGroup) {

		final List<TopicPartition> topicPartitions = new ArrayList<>();
		JavaConversions.asJavaList(adminClient(broker).describeConsumerGroup(consumerGroup).consumers().get())
				.forEach(dcg -> {
					topicPartitions.addAll(JavaConversions.asJavaList(dcg.assignment()));
				});
		return topicPartitions;
	}

	@Override
	public long logSize(final String broker, final String topic) {

		return 0;
	}

	@Override
	public String owner(final String broker, final String group, final String topic, final int partition) {

		String owner = "Not Found!";

		final List<ConsumerSummary> consumers = JavaConversions
				.asJavaList(adminClient(broker).describeConsumerGroup(group).consumers().get());
		for (final ConsumerSummary consumer : consumers) {
			final List<TopicPartition> topicParitions = JavaConversions.asJavaList(consumer.assignment());
			if (topicParitions.stream()
					.filter(tp -> topic.equalsIgnoreCase(tp.topic()) && (partition == tp.partition())).findFirst()
					.isPresent())
				owner = String.format("%s-%s", consumer.clientId(), consumer.host().substring(1));
		}
		return owner;
	}

	@Override
	public long lag(final String broker, final String topic) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long lag(final String broker, final String topic, final int partition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long lag(final String broker, final String group, final String topic, final int partition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long lag(final String broker, final String group, final String topic) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long offset(final String broker, final String group, final String topic, final int offset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String leader(final String broker, final String topic, final String partition) {
		// TODO Auto-generated method stub
		return null;
	}

}

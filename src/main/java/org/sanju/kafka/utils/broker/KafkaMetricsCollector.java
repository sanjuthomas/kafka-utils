package org.sanju.kafka.utils.broker;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.common.TopicPartition;
import org.sanju.kafka.utils.MetricsCollector;

import kafka.admin.AdminClient;
import scala.collection.JavaConversions;

/**
 * 
 * @author Sanju Thomas
 *
 */
public class KafkaMetricsCollector implements MetricsCollector{
	
	private static AdminClient createAdminClient(final String broker) {
		
		final Properties config = new Properties();
		config.put("bootstrap.servers", broker);
		final AdminClient adminClient = AdminClient.create(config);
		return adminClient;
	}

	public List<String> consumerGroups(final String broker) {

		final List<String> consumerGroups = new ArrayList<>();
		JavaConversions.asJavaList(createAdminClient(broker).listAllConsumerGroupsFlattened())
				.forEach(gv -> consumerGroups.add(gv.groupId()));
		return consumerGroups;
	}

	public List<String> topics(final String broker) {

		final List<String> topics = new ArrayList<>();
		this.consumerGroups(broker).forEach(cg -> {
			topics.addAll(this.topics(broker, cg));
		});
		return topics;
	}
	
	public List<String> topics(final String broker, final String consumerGroup) {
		
		final List<String> topics = new ArrayList<>();
		JavaConversions.asJavaList(createAdminClient(broker).describeConsumerGroup(consumerGroup)).forEach(cs -> {
			JavaConversions.asJavaList(cs.assignment()).forEach(a -> {
				if (!topics.contains(a.topic())) {
					topics.add(a.topic());
				}
			});
		});
		return topics;
	}

	public List<TopicPartition> topicPartition(String broker) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TopicPartition> topicPartition(String broker, String consumerGroup) {
		// TODO Auto-generated method stub
		return null;
	}



	public List<Integer> partitions(String broker, String topic) {
		// TODO Auto-generated method stub
		return null;
	}

	public long currentOffset(String broker, String topic) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long endOffset(String broker, String topic) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String owner(String broker, String topic, int partition) {
		// TODO Auto-generated method stub
		return null;
	}

	public long lag(String broker, String topic) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long lag(String broker, String topic, int partition) {
		// TODO Auto-generated method stub
		return 0;
	}

}

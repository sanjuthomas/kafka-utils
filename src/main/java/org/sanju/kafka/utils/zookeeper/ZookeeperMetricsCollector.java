package org.sanju.kafka.utils.zookeeper;

import java.util.List;

import org.apache.kafka.common.TopicPartition;
import org.sanju.kafka.utils.MetricsCollector;

/**
 * 
 * @author Sanju Thomas
 *
 */
public class ZookeeperMetricsCollector implements MetricsCollector{

	public List<String> consumerGroups(String broker) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> topics(String broker) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TopicPartition> topicPartition(String broker) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TopicPartition> topicPartition(String broker, String consumerGroup) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> topics(String broker, String consumerGroup) {
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

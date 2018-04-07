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

	@Override
	public List<String> groups(final String broker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> topics(final String broker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TopicPartition> topicPartition(final String broker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TopicPartition> topicPartition(final String broker, final String group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> topics(final String broker, final String group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long offset(final String broker, final String group, final String topic, final int offset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long logSize(final String broker, final String topic) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String owner(final String broker, final String group, final String topic, final int partition) {
		// TODO Auto-generated method stub
		return null;
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
	public String leader(final String broker, final String topic, final String partition) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

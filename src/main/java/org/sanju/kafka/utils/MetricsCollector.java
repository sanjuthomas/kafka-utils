package org.sanju.kafka.utils;

import java.util.List;

import org.apache.kafka.common.TopicPartition;

/**
 * 
 * @author Sanju Thomas
 *
 */
public interface MetricsCollector {
	
	
	/**
	 * Collect all the consumer groups from the broker.
	 * 
	 * @param broker
	 * @return
	 */
	List<String> groups(String broker);
	
	
	/**
	 * Collect all the topics from the broker.
	 * 
	 * @param broker
	 * @return
	 */
	List<String> topics(String broker);
	
	
	/**
	 * Collect all the TopicPartitions from the broker.
	 * 
	 * @param broker
	 * @return
	 */
	List<TopicPartition> topicPartition(String broker);
	
	
	/**
	 * Collect all the TopicPartition for the given consumer group from the broker.
	 * 
	 * @param broker
	 * @param consumerGroup
	 * @return
	 */
	List<TopicPartition> topicPartition(String broker, String group);
	
	
	/**
	 * Collect all the topics for the given consumer group from the broker.
	 * 
	 * @param broker
	 * @param consumerGroup
	 * @return
	 */
	List<String> topics(String broker, String group);
	
	
	/**
	 * Collect the current offset of the given topic from the broker.
	 * 
	 * @param broker
	 * @param group
	 * @param topic
	 * @param offset
	 * @return
	 */
	long offset(String broker, String group, String topic, int offset);
	
	
	/**
	 * Collect the end offset of the given topic from the broker.
	 * 
	 * @param broker
	 * @param topic
	 * @return
	 */
	long logSize(String broker, String topic);
	
	
	/**
	 * Collect the owner of the given topic and partition from the broker.
	 * 
	 * @param broker
	 * @param topic
	 * @param partition
	 * @return
	 */
	String owner(String broker, final String group, String topic, int partition);
	
	
	/**
	 * Collect the lag for the given topic's all partitions from the broker.
	 * 
	 * @param broker
	 * @param topic
	 * @return
	 */
	long lag(String broker, String topic);
	

	/**
	 * 
	 * Collect the lag for the given topic and partition from the broker.
	 * 
	 * @param broker
	 * @param topic
	 * @param partition
	 * @return
	 */
	long lag(String broker, String topic, int partition);
	
	
	/**
	 * Collect the lag for the given group, topic, and partition from the broker.
	 * 
	 * @param broker
	 * @param group
	 * @param topic
	 * @param partition
	 * @return
	 */
	long lag(String broker, String group, String topic, int partition);
	
	
	/**
	 * Collect the lag for the given group, and topic from the broker.
	 * 
	 * @param broker
	 * @param group
	 * @param topic
	 * @return
	 */
	long lag(String broker, String group, String topic);
	
	/**
	 * Find the leader for the given topic and partition from the broker.
	 * 
	 * @param broker
	 * @param topic
	 * @param partition
	 * @return
	 */
	String leader(String broker, String topic, String partition);
	
}

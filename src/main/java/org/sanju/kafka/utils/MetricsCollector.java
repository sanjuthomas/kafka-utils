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
	List<String> consumerGroups(String broker);
	
	
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
	List<TopicPartition> topicPartition(String broker, String consumerGroup);
	
	
	/**
	 * Collect all the topics for the given consumer group from the broker.
	 * 
	 * @param broker
	 * @param consumerGroup
	 * @return
	 */
	List<String> topics(String broker, String consumerGroup);
	
	
	
	/**
	 * Collect all the partitions for the given topic from the broker.
	 * 
	 * @param topic
	 * @return
	 */
	List<Integer> partitions(String broker, String topic); 
	
	
	/**
	 * Collect the current offset of the given topic from the broker.
	 * 
	 * @param broker
	 * @param topic
	 * @return
	 */
	long currentOffset(String broker, String topic);
	
	
	/**
	 * Collect the end offset of the given topic from the broker.
	 * 
	 * @param broker
	 * @param topic
	 * @return
	 */
	long endOffset(String broker, String topic);
	
	
	/**
	 * Collect the owner of the given topic and partition from the broker.
	 * 
	 * @param broker
	 * @param topic
	 * @param partition
	 * @return
	 */
	String owner(String broker, String topic, int partition);
	
	
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
	
}

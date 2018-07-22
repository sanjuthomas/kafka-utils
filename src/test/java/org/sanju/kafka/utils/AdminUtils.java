package org.sanju.kafka.utils;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

import kafka.utils.ZkUtils;

public class AdminUtils {

	private static final String KAFKA_HOST = "localhost";
	private static final int KAFKA_PORT = 9092;
	private static final String ZOOKEEPER_HOST = "localhost:2181";

	private ZkClient zkClient;
	private ZkConnection zkConnection;

	public String kafkaHost() {
		return KAFKA_HOST;
	}

	public int kafkaPort() {
		return KAFKA_PORT;
	}

	public ZkClient zkClient() {
		if (null == this.zkClient) {
			this.zkClient = new ZkClient(this.zookeeperHost());
		}
		return this.zkClient;
	}

	public ZkUtils zkUtils() {
		return null;
	}

	public String zookeeperHost() {
		return ZOOKEEPER_HOST;
	}
}

package org.sanju.kafka.utils;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

import kafka.utils.ZkUtils;

public class AdminUtils {

	private static String KAFKA_HOST = "localhost:9092";
	private static String ZOOKEEPER_HOST = "localhost:2181";

	private ZkClient zkClient;
	private ZkConnection zkConnection;

	public AdminUtils(final String kafkaHost, final String zooKeeperHost) {
		AdminUtils.KAFKA_HOST = kafkaHost;
		AdminUtils.ZOOKEEPER_HOST = zooKeeperHost;
	}

	public String kafkaHost() {
		return KAFKA_HOST;
	}

	public ZkClient zkClient() {
		if (null == this.zkClient) {
			this.zkClient = new ZkClient(this.zookeeperHost());
		}
		return this.zkClient;
	}

	public ZkUtils zkUtils() {
		if (null == this.zkConnection) {
			this.zkConnection = new ZkConnection(this.zookeeperHost());
		}
		return new ZkUtils(this.zkClient, this.zkConnection, false);
	}

	public String zookeeperHost() {
		return ZOOKEEPER_HOST;
	}
}

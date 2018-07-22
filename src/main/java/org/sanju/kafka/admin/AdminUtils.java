package org.sanju.kafka.admin;

import kafka.zk.AdminZkClient;
import kafka.zk.KafkaZkClient;

public class AdminUtils {

  private static String KAFKA_HOST = "localhost:9092";
  private static String ZOOKEEPER_HOST = "localhost:2181";

  public AdminUtils(final String kafkaHost, final String zooKeeperHost) {
    AdminUtils.KAFKA_HOST = kafkaHost;
    AdminUtils.ZOOKEEPER_HOST = zooKeeperHost;
  }

  public AdminZkClient adminZkClient() {
    return new AdminZkClient(this.kafkaZkClient());
  }

  public String kafkaHost() {
    return KAFKA_HOST;
  }

  public KafkaZkClient kafkaZkClient() {
    return KafkaZkClient.apply(this.zookeeperHost(), false, 5000, 2000, 1000, org.apache.kafka.common.utils.Time.SYSTEM, "kafka-utils-group",
        "monitor");
  }

  public String zookeeperHost() {
    return ZOOKEEPER_HOST;
  }
}

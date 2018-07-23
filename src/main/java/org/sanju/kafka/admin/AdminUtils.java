package org.sanju.kafka.admin;

import java.util.Properties;
import kafka.admin.AdminClient;
import kafka.zk.AdminZkClient;
import kafka.zk.KafkaZkClient;

/**
 *
 * @author Sanju Thomas
 *
 */
public class AdminUtils {

  private static String KAFKA_HOST = "localhost:9092";
  private static String ZOOKEEPER_HOST = "localhost:2181";

  public AdminUtils(final String kafkaHost, final String zooKeeperHost) {
    AdminUtils.KAFKA_HOST = kafkaHost;
    AdminUtils.ZOOKEEPER_HOST = zooKeeperHost;
  }

  public AdminClient adminClient() {
    final Properties config = new Properties();
    config.put("bootstrap.servers", this.kafkaHost());
    return AdminClient.create(config);
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

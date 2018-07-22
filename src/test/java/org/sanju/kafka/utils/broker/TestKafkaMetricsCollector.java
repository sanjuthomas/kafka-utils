package org.sanju.kafka.utils.broker;

import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.sanju.kafka.utils.AbstractTest;
import org.sanju.kafka.utils.IntegrationTest;

/**
 * 
 * @author Sanju Thomas
 * 
 * This is an integration test and this test expect the Kafka and Zookeeper in the localhost running in the default port.
 * Please change the host and port in the AbstractTest if you are using a remote infrastructure.
 *
 */

@Category(IntegrationTest.class)
public class TestKafkaMetricsCollector extends AbstractTest {
	
	@Override
	@Before
	public void setup() {
		super.setup();
	}
	
	
	

}

package org.sanju.kafka.utils;

import java.util.Set;

import org.junit.After;
import org.junit.Before;

import com.google.common.collect.ImmutableSet;

/**
 *
 * @author Sanju Thomas
 *
 */
public class AbstractTest {

	private final Set<String> topics = ImmutableSet.of("PABN", "PANA", "PAOU", "PANN");
	private TopicUtils util;

	@Before
	public void setup() {
		this.util = new TopicUtils("localhost:9092", "localhost:2181");
		this.setupTopics();
	}

	private void setupTopics() {
		this.util.createTopics(this.topics);
	}

	@After
	public void tearDown() {

	}

}

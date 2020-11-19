package de.hfu;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class QueueTest {
	private Queue test;
	
	@Before
	public void erzeugeQueue() {
		test = new Queue(3);
	}
	
	@Test
	public void testQueue() {
		test.enqueue(1);
		test.enqueue(2);
		test.enqueue(3);
		test.enqueue(4);
		test.enqueue(0);
		assertEquals(1,test.dequeue());
		assertEquals(2,test.dequeue());
		assertEquals(0,test.dequeue());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testQueueExcep() {
		Queue t = new Queue(0);
	}
	
}

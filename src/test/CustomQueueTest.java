package test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import datatype.CustomQueue;

public class CustomQueueTest {
	CustomQueue<Integer> queue;

	@Before
	public void setQueue() {
		List<Integer> list = new ArrayList<>(2);
		list.add(10);
		list.add(20);
		queue = new CustomQueue<>(list);
	}

	@Test
	public void shouldReturnSize2() {
		assertEquals(2, queue.size());
	}

	@Test
	public void shouldReturnSize0() {
		queue.poll();
		queue.poll();
		assertEquals(0, queue.size());
	}

	@Test
	public void shouldReturnSize1AfterAddElement() {
		queue.add(30);
		assertEquals(3, queue.size());
	}

	@Test
	public void shouldRetrun10AfterPeek() {
		int result = queue.peek();
		assertEquals(10, result);
	}

	@Test
	public void shouldRetrunNullAfterPeek() {
		queue.poll();
		queue.poll();

		Integer result = queue.peek();
		assertNull(result);
	}

	@Test
	public void shouldRetrun10AfterPoll() {
		int result = queue.poll();
		assertEquals(10, result);
	}

	@Test
	public void shouldRetrunSize1AfterPoll() {
		int result = queue.poll();
		assertEquals(1, queue.size());
	}

	@Test
	public void isEmptyShouldReturnTrueAfterPollAll() {
		int p;
		p = queue.poll();
		p = queue.poll();

		assertTrue(queue.isEmpty());

	}

	@Test
	public void shouldReturnNullIfPollOnEmptyQueue() {

		queue.poll();
		queue.poll();
		Integer element = queue.poll();
		assertNull(element);

	}

	@Test
	public void isEmptyShouldReturnFalseAfterPollOne() {
		queue.poll();

		assertFalse(queue.isEmpty());

	}

}

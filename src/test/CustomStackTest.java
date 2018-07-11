package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import datatype.CustomStack;;

public class CustomStackTest {
	CustomStack<Integer> stack;

	@Before
	public void setStack() {
		List<Integer> list = new ArrayList<>(2);
		list.add(10);
		list.add(20);
		stack = new CustomStack<>(list);
	}

	@Test
	public void shouldReturnSize2() {
		assertEquals(2, stack.size());
	}

	@Test
	public void shouldReturnSize0() {
		stack.pop();
		stack.pop();
		assertEquals(0, stack.size());
	}

	@Test
	public void shouldReturnSize1AfterAddElement() {
		stack.push(30);
		assertEquals(3, stack.size());
	}

	@Test
	public void shouldRetrun10AfterPoll() {
		int result = stack.pop();
		assertEquals(20, result);
	}

	@Test
	public void shouldRetrunSize1AfterPoll() {
		stack.pop();
		assertEquals(1, stack.size());
	}

	@Test
	public void isEmptyShouldReturnTrueAfterPopAll() {
		int p;
		p = stack.pop();
		p = stack.pop();

		assertTrue(stack.isEmpty());

	}

	@Test(expected = EmptyStackException.class)
	public void shouldReturnEmptyStackExceptionIfPopOnEmptyQueue() {

		stack.pop();
		stack.pop();
		stack.pop();

	}

	@Test
	public void isEmptyShouldReturnFalseAfterPopOne() {
		stack.pop();
		assertFalse(stack.isEmpty());

	}

}

package test;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import datastructure.list.CustomLinkedList;

public class CustomLinkedListTest {

	CustomLinkedList<Integer> list;

	@Before
	public void setList() {

		list = new CustomLinkedList<>();
	}

	public void shouldReturnTrueWhenEmpty() {

		assertTrue(list.isEmpty());
	}

	@Test
	public void shouldReturnFalseWhenIsNotEmpty() {

		list.add(10);
		assertFalse(list.isEmpty());
	}

	@Test
	public void shouldReturn2WhenListHas2Element() {

		list.add(10);
		list.add(20);

		assertEquals(2, list.size());
	}

	@Test
	public void shouldReturn2WhenStringListHas2Element() {

		CustomLinkedList<String> listStr = new CustomLinkedList<String>();
		listStr.add("test1");
		listStr.add("test2");

		assertEquals(2, listStr.size());
	}

	@Test
	public void shouldReturn0WhenListIsEmpty() {

		list = new CustomLinkedList<>();

		assertEquals(0, list.size());
	}

	@Test
	public void shouldReturnTrueIfListContains50() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);

		boolean result = list.contains(50);
		assertTrue(result);
	}

	@Test
	public void shouldReturnFalseIfListNotContains30() {

		list.add(10);
		list.add(20);

		boolean result = list.contains(30);
		assertFalse(result);
	}

	@Test
	public void shouldReturnTrueIfContainsNull() {

		list.add(null);

		boolean result = list.contains(null);
		assertTrue(result);
	}

	@Test
	public void containsShouldReturnFalseWhenListIsEmpty() {

		list = new CustomLinkedList<>();
		boolean result = list.contains(50);
		assertFalse(result);
	}

	@Test
	public void shouldIsEmptyReturnTrueWhenClear() {

		list.add(10);
		list.add(20);
		list.add(30);

		list.clear();
		assertTrue(list.isEmpty());
	}

	@Test
	public void shouldReturn0WhenClear() {

		list.add(10);
		list.add(20);
		list.add(30);

		list.clear();
		assertEquals(0, list.size());
	}

	@Test
	public void shouldReturn10WhenGetSecondElement() {

		list.add(10);
		list.add(20);
		list.add(30);

		int result = list.get(2);
		assertEquals(30, result);
	}

	@Test
	public void shouldReturnNullWhenAddNull() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(null);

		Integer result = list.get(3);
		assertNull(result);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldReturnIndexOutOfBoundsExceptionWhenGetFourElement() {

		list.add(10);
		list.add(20);
		list.add(30);

		int result = list.get(4);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldReturnIndexOutOfBoundsExceptionWhenListIsEmpty() {

		list.get(0);

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldReturnIndexOutOfBoundsExceptionWhenIndexIsLessThan0() {

		list.get(-1);
	}

	@Test
	public void shouldReturn5WhenSetFirstElementAndGet() {

		list.add(10);
		list.add(20);
		list.add(30);

		list.set(0, 5);

		int result = list.get(0);
		assertEquals(5, result);
	}

	@Test
	public void shouldReturn30WhenSetLastElement() {

		list.add(10);
		list.add(20);
		list.add(30);

		int result = list.set(2, 15555);

		assertEquals(30, result);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldReturnIndexOutOfBoundsExceptionWhenIndexIsGreaterThanSize() {

		list.add(10);
		list.add(20);
		list.add(30);

		list.set(4, 15555);

	}

	@Test
	public void shouldReturnSize3ElementsAfterAdd() {

		list.add(10);
		list.add(20);
		list.add(0, 5);

		assertEquals(3, list.size());
	}

	@Test
	public void shouldReturn5ElementsAfterAddWhenGet() {

		list.add(10);
		list.add(20);
		list.add(0, 5);

		int result = list.get(0);
		assertEquals(5, result);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldReturnIndexOutOfBoundsExceptionWhenIndexLessThan0() {

		list.add(10);
		list.add(20);
		list.add(-1, 5);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldReturnIndexOutOfBoundsExceptionWhenIndexGreaterThanSize() {

		list.add(10);
		list.add(20);
		list.add(2, 5);
	}

	@Test
	public void shouldReturn25ElementWhenGet2ElementAfterAdd() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(2, 25);

		int result = list.get(2);
		assertEquals(25, result);
	}

	@Test
	public void shouldReturn50ElementWhenGetLastElementAfterAdd() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(3, 50);

		int result = list.get(3);
		assertEquals(50, result);
	}

	@Test
	public void shouldReturnNullElementWhenGetLastElementAfterAdd() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(3, null);

		Integer result = list.get(3);
		assertNull(result);
	}

	@Test
	public void shouldReturnSize3AfterRemoveLastByIndex() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.remove(3);

		assertEquals(3, list.size());
	}

	@Test
	public void shouldReturnSize3AfterRemoveFirstByIndex() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.remove(0);

		assertEquals(3, list.size());
	}

	@Test
	public void shouldReturnSize3AfterRemoveMiddleByIndex() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.remove(2);

		assertEquals(3, list.size());
	}

	@Test
	public void shouldReturnSize0AfterRemoveOneElement() {

		list.add(10);
		list.remove(0);

		assertEquals(0, list.size());
	}

	@Test
	public void shouldReturnSize10AfterRemoveOneElement() {

		list.add(10);
		int result = list.remove(0);

		assertEquals(10, result);
	}

	@Test
	public void shouldReturnSize10AfterRemoveLastElement() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		int result = list.remove(3);

		assertEquals(40, result);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldReturnIndexOutOfBoundsExceptionWhenRemoveByIndexGreaterThanSize() {

		list.remove(3);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldReturnIndexOutOfBoundsExceptionWhenRemoveByIndexLessThan0() {

		list.remove(-1);
	}

	@Test
	public void shouldReturnSize3AfterRemoveLastByObject() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.remove(new Integer(40));

		assertEquals(3, list.size());
	}

	@Test
	public void shouldReturnSize3AfterRemoveFirstByObject() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.remove(new Integer(10));

		assertEquals(3, list.size());
	}

	@Test
	public void shouldReturnSize3AfterRemoveBadByObject() {

		list.add(10);
		list.remove(new Integer(30));

		assertEquals(1, list.size());
	}

	@Test
	public void shouldReturnSize3AfterRemoveFirstByObjectWithSize() {

		list.add(10);
		list.remove(new Integer(10));

		assertEquals(0, list.size());
	}

	@Test
	public void shouldReturnIndex3For40() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);

		assertEquals(3, list.indexOf(new Integer(40)));
	}

	@Test
	public void shouldReturnIndex0For10() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);

		assertEquals(0, list.indexOf(new Integer(10)));
	}

	@Test
	public void shouldReturnIndexMinus1For50() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);

		assertEquals(-1, list.indexOf(new Integer(50)));
	}

	@Test
	public void testRemove30FromIterator() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);

		Iterator<Integer> iterator = list.iterator();

		while (iterator.hasNext()) {
			Object element = iterator.next();
			if (element.equals(40)) {
				iterator.remove();
			}
		}

		assertFalse(list.contains(40));
	}

	@Test
	public void shouldReturnSum70WhenSumGreaterThan20() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		int sum = 0;

		Iterator<Integer> iterator = list.iterator();

		while (iterator.hasNext()) {
			Object element = iterator.next();
			if ((int) element > 20) {
				sum += (int) element;
			}
		}

		assertEquals(70, sum);
	}

	@Test
	public void shouldReturnSum100WhenSumByForEach() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		int sum = 0;

		for (Integer element : list) {
			sum += element;
		}
		assertEquals(100, sum);
	}

	@Test
	public void shouldReturnSum60WhenSumByForEach() {

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		int sum = 0;

		for (Integer element : list) {
			if (element.equals(40)) {
				list.remove(element);
			} else {
				sum += element;
			}
		}
		assertEquals(60, sum);
	}

}

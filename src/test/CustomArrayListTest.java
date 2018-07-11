package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;
import datastructure.list.CustomArrayList;

public class CustomArrayListTest {
	CustomArrayList<Integer> arrayInt;

	/*
	 * Method to write Array param - int x - value to recognize which write it
	 * is
	 */
	void writeElements(int x) {

		System.out.println(x + " CAPACITY: " + arrayInt.getCapacity());
		for (int i = 0; i < arrayInt.getCapacity(); i++) {
			if (arrayInt.get(i) != null) {
				System.out.print("[" + i + "] " + arrayInt.get(i) + " ");
			} else {
				System.out.print("[" + i + "]: NULL ");
			}
		}
		System.out.println();
	}

	@Before
	public void setArrayList() {

		// System.out.println("------------BEFORE------------------");
		arrayInt = new CustomArrayList<>(2);
		arrayInt.add(10);
		// writeElements(10);
		arrayInt.add(20);
		// writeElements(20);
		arrayInt.add(30);
		// // writeElements(30);
		arrayInt.add(40);
		// // writeElements(40);
		arrayInt.add(50);
		// // writeElements(50);
		arrayInt.add(60);
		// // writeElements(60);
		arrayInt.add(70);
		// // writeElements(70);
		arrayInt.add(80);
		// // writeElements(80);
		arrayInt.add(90);
		// // writeElements(90);
		arrayInt.add(100);
		// writeElements(100);

	}

	@Test
	public void sizeShouldhReturn10WithoutSet() {

		assertEquals(10, arrayInt.size());

	}

	@Test
	public void sizeShouldhReturn100WithSet() {

		arrayInt = new CustomArrayList<>(100);
		assertEquals(100, arrayInt.getCapacity());

	}

	@Test
	public void shouldReturnTrueIfEmpty() {

		arrayInt = new CustomArrayList<>();
		assertTrue(arrayInt.isEmpty());

	}

	@Test
	public void shouldReturnTrueIfEmptyAfterAddAndRemove() {

		arrayInt = new CustomArrayList<>(2);
		arrayInt.add(10);
		arrayInt.add(20);
		arrayInt.remove(0);
		arrayInt.remove(0);
		assertTrue(arrayInt.isEmpty());

	}

	@Test
	public void shouldReturnFalseIfNotEmpty() {

		arrayInt.add(10);
		assertFalse(arrayInt.isEmpty());

	}

	@Test
	public void shouldReturnTrueIfContains10() {

		assertTrue(arrayInt.contains(10));
	}

	@Test
	public void shouldReturnTrueIfContainsNull() {

		arrayInt.add(null);
		assertTrue(arrayInt.contains(null));
	}

	@Test
	public void shouldReturnTrueAfterRemove10() {

		Integer obj = 10;
		assertTrue(arrayInt.remove(obj));
	}

	@Test
	public void shouldReturnFalseAfterRemove120() {

		Integer obj = 120;
		assertFalse(arrayInt.remove(obj));
	}

	@Test
	public void shouldReturnTrueIfIsNullAndRemoveNull() {

		Integer obj = null;
		arrayInt.add(null);
		assertTrue(arrayInt.remove(obj));
	}

	@Test
	public void shouldReturnFalseIfRemoveFromEmptyList() {

		arrayInt = new CustomArrayList<>();
		Integer obj = 10;
		assertFalse(arrayInt.remove(obj));
	}

	@Test
	public void isEmptyShouldReturnTrueAfterClear() {

		arrayInt.clear();
		assertTrue(arrayInt.isEmpty());
	}

	@Test
	public void shouldReturn20AfterSet10On20() {

		arrayInt.add(10);
		arrayInt.set(0, 20);
		int result = arrayInt.get(0);
		assertEquals(20, result);
	}

	@Test
	public void shouldReturn20AfterSetNullOn30() {

		arrayInt.add(10);
		arrayInt.set(1, 30);
		int result = arrayInt.get(1);
		assertEquals(30, result);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldReturIndexOutOfBoundsExceptionWhenIndexIsGreaterThanCapacity() {

		arrayInt.set(arrayInt.getCapacity(), 20);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldReturIndexOutOfBoundsExceptionWhenIndexIsLessThan0() {

		arrayInt.set(-1, 20);
	}

	@Test
	public void shouldReturnNullAfterSetNullOn30() {

		arrayInt.add(1, null);
		Integer result = arrayInt.set(1, 30);
		assertNull(result);
	}

	@Test
	public void shouldReturnNotNullAfterSetNull() {

		Integer result = arrayInt.set(1, null);
		assertNotNull(result);
	}

	@Test
	public void shouldReturn100AfterGetWithLastIndex() {

		int result = arrayInt.get(arrayInt.getCapacity() - 1);
		assertEquals(100, result);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldReturnIndexOutOfBoundsExceptionWhenIndexLessThan0() {

		int result = arrayInt.get(-1);
	}

	@Test
	public void shouldReturnNullWhenNull() {

		arrayInt.add(0, null);
		Integer result = arrayInt.get(0);
		assertNull(result);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldReturnIndexOutOfBoundsExceptionWhenIndexIsGreaterThanSize() {

		arrayInt.get(arrayInt.getCapacity());
	}

	@Test
	public void shouldReturn5555AfterAdd555() {

		arrayInt.add(5, 555);
		int result = arrayInt.get(5);
		assertEquals(555, result);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldReturnIndexOutOfBoundsExceptionAfterAddWithIndexGreater() {

		arrayInt.add(arrayInt.getCapacity() * 2, 555);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldReturnIndexOutOfBoundsExceptionAfterAddWithIndexLess0() {

		arrayInt.add(-1, 555);
	}

	@Test
	public void shouldReturnSize3AfterAdd3ElementsToClearArray() {

		arrayInt.clear();
		arrayInt.add(0, 10);
		arrayInt.add(1, 20);
		arrayInt.add(2, 30);

		assertEquals(3, arrayInt.size());
	}

	@Test
	public void shouldReturnSize11AfterAddElement() {

		arrayInt.add(0, 5);
		assertEquals(11, arrayInt.size());
	}

	@Test
	public void shouldReturn9WhenRemove0Element() {

		int result = arrayInt.remove(0);
		assertEquals(9, arrayInt.size());
	}

	@Test
	public void shouldReturn0WhenListIsEmpty() {

		arrayInt = new CustomArrayList<>(0);
		assertEquals(0, arrayInt.size());
	}

	@Test
	public void shouldReturn55WhenAdd55ToListWIthSize0() {

		arrayInt = new CustomArrayList<>(0);
		arrayInt.add(55);
		int result = arrayInt.get(0);
		assertEquals(55, result);
	}

	@Test
	public void shouldReturn50WhenRemove4Element() {

		int result = arrayInt.remove(4);
		assertEquals(50, result);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldReturnIndexOutOfBoundsExceptionWhenRemoveWithIndexLessThan0() {

		arrayInt.remove(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldReturnIndexOutOfBoundsExceptionWhenRemoveWithIndexGreaterThanCapacity() {

		arrayInt.remove(arrayInt.getCapacity() * 2);
	}

	@Test
	public void shouldReturnNullWhenRemove4AndGetLast() {

		arrayInt.remove(4);
		Integer result = arrayInt.get(arrayInt.getCapacity() - 1);
		assertNull(result);
	}

	@Test
	public void shouldReturnSize9AfterRemoveOneElement() {

		arrayInt.remove(0);
		assertEquals(9, arrayInt.size());
	}

	@Test
	public void shouldReturn9WhenIndexOf100() {

		Integer obj = new Integer(100);
		int result = arrayInt.indexOf(obj);
		assertEquals(9, result);
	}

	@Test
	public void shouldReturnTrueAfterRemove30FromIterator() {

		Iterator<Integer> iterator = arrayInt.iterator();

		while (iterator.hasNext()) {
			Object element = iterator.next();
			if (element.equals(30)) {
				iterator.remove();
			}
			assertTrue(arrayInt.contains(30));
		}
	}

	@Test
	public void shouldReturnSum190WhenSumGreaterThan80() {

		Iterator<Integer> iterator = arrayInt.iterator();
		int sum = 0;

		while (iterator.hasNext()) {
			int element = (Integer) iterator.next();
			if (element > 80) {
				sum += element;
			}
		}

		assertEquals(190, sum);
	}

	@Test
	public void shouldReturnSum10WhenSumLessThan20() {

		Iterator<Integer> iterator = arrayInt.iterator();
		int sum = 0;

		while (iterator.hasNext()) {
			int element = (Integer) iterator.next();
			if (element < 20) {
				sum += element;
			}
		}

		assertEquals(10, sum);
	}

	@Test
	public void shouldReturnSum550WhenSumByForEach() {

		int sum = 0;

		for (Integer element : arrayInt) {
			sum += element;
		}
		assertEquals(550, sum);
	}

}

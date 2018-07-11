package test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import datastructure.list.FilterIterator;
import static org.junit.Assert.*;

public class FilterIteratorTest {
	FilterIterator<Integer> filterInteger;
	List<Integer> listInt;
	
	@Before
	public void setFilterIterator(){
		listInt = new ArrayList<>();
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		listInt.add(4);
		listInt.add(5);
		
	}

	@Test
	public void shouldReturnSum5AfterSumInIterator() {
		int sum = 0;
	
		Iterator<Integer> iterator = new FilterIterator<>(listInt, p -> p >= 3);

		while (iterator.hasNext()) {
			Object element = iterator.next();
			sum += (Integer) element;
			
		}
		
		assertEquals(12, sum);
	}
	
	@Test
	public void shouldReturnSum3AfterSumLessThan3InIterator() {
		int sum = 0;
		
		Iterator<Integer> iterator = new FilterIterator<>(listInt, p -> p < 3);
		

		while (iterator.hasNext()) {
			Object element = iterator.next();
			sum += (Integer) element;
			
		}
		
		assertEquals(3, sum);
	}
	
	@Test
	public void shouldReturnSum1AfterSumLessThan3InIterator() {
		
		FilterIterator<Integer> iterator = new FilterIterator<>(listInt, p -> p < 3);

		while (iterator.hasNext()) {
			Object element = iterator.next();
			if(element.equals(2)){
				iterator.remove();
			}
			
		}
			
		assertEquals(1, iterator.getFilterList().size() );
	}

}

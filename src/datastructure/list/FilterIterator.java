package datastructure.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Filter iterator
 */
public class FilterIterator<T> implements Iterator<T> {

	private List<T> filterList;
	private int currentIndex = 0;

	public FilterIterator(List<T> list, Predicate<T> predicate) {

		this.filterList = new ArrayList<>();
		for (T element : list) {
			if (predicate.test(element)) {
				this.filterList.add(element);
			}
		}
		// this.filterList =
		// list.stream().filter(predicate).collect(Collectors.<T> toList());
	}

	@Override
	public boolean hasNext() {
		if (currentIndex < filterList.size() && filterList.get(currentIndex) != null) {
			return true;
		}

		return false;
	}

	@Override
	public T next() {
		return filterList.get(currentIndex++);
	}

	@Override
	public void remove() {
		filterList.remove(--currentIndex);
	}

	// Getter use in test remove
	public List<T> getFilterList() {
		return this.filterList;
	}
}

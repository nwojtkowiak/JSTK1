package datatype;

import java.util.EmptyStackException;
import java.util.List;

import datastructure.list.CustomArrayList;

/**
 * Stack, LIFO queue
 */
public class CustomStack<T> extends AbstractCustomStackAdapter<T> {

	CustomArrayList<T> storage;

	public CustomStack(List<T> storage) {
		this.storage = new CustomArrayList<>(storage.size());
		for (T element : storage) {
			this.storage.add(element);
		}
	}

	@Override
	public void push(T t) {
		this.storage.add(t);
	}

	@Override
	public T pop() {
		int lastIndex = this.storage.size() - 1;
		if (lastIndex < 0) {
			throw new EmptyStackException();
		}

		T element = this.storage.get(lastIndex);
		this.storage.remove(lastIndex);
		return element;
	}

	@Override
	public int size() {
		return this.storage.size();
	}

	@Override
	public boolean isEmpty() {
		return this.storage.isEmpty();
	}
}

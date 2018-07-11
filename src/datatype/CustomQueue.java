package datatype;

import java.util.List;

import datastructure.list.CustomArrayList;

/**
 * FIFO queue
 */
public class CustomQueue<T> extends AbstractCustomQueueAdapter<T> {

	private CustomArrayList<T> storage;

	public CustomQueue(List<T> storage) {
		this.storage = new CustomArrayList<>(storage.size());
		for (T element : storage) {
			this.storage.add(element);
		}
	}

	@Override
	public int size() {
		return this.storage.size();
	}

	@Override
	public boolean isEmpty() {
		return this.storage.isEmpty();
	}

	@Override
	public boolean add(T t) {
		return this.storage.add(t);
	}

	@Override
	public T poll() {
		T element = this.storage.get(0);
		this.storage.remove(0);
		return element;
	}

	@Override
	public T peek() {

		return this.storage.get(0);
	}
}

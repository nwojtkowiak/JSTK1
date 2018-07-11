package datastructure.list;

import java.util.Iterator;

/**
 * List based on the table
 *
 * @param <T>
 */
public class CustomArrayList<T> extends AbstractCustomListAdapter<T> {

	private Object[] array;
	private final int defaultCapacity = 10;
	private final int numOfChangeLength = 1;
	private int size;
	private int capacity;
	private int initCapacity;

	public CustomArrayList() {

		this.array = new Object[defaultCapacity];
		this.capacity = defaultCapacity;
		this.initCapacity = defaultCapacity;
	}

	public CustomArrayList(int initialCapacity) {

		this.array = new Object[initialCapacity];
		this.capacity = initialCapacity;
		this.initCapacity = initialCapacity;
	}

	// OK
	@Override
	public int size() {
		return this.size;
	}

	// OK
	@Override
	public boolean isEmpty() {

		for (Object obj : this.array) {
			if (obj != null) {
				return false;
			}
		}
		return true;
	}

	// OK
	@Override
	public boolean contains(Object o) {

		for (Object obj : this.array) {
			if (obj != null && obj.equals(o)) {
				return true;
			} else if (o == null && obj == null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {

		return new CustomArrayListIterator<>();
	}

	// OK
	@Override
	public boolean add(T t) {

		relocation();
		if (this.size < this.capacity) {
			this.array[this.size] = t;
			this.size++;
			return true;
		} else if (this.capacity == 0) {
			this.array = new Object[this.defaultCapacity];
			this.array[this.size] = t;
			this.size++;
			return true;
		}
		return false;
	}

	// OK
	@Override
	public boolean remove(Object o) {

		for (int index = 0; index < this.size(); index++) {
			if (o != null) {
				if (this.array[index] != null && this.array[index].equals(o)) {
					System.arraycopy(this.array, index + 1, this.array, index, this.capacity - index - 1);
					// this.array[index] = null;
					this.size--;
					relocation();

					return true;
				}
			} else if (this.array[index] == null) {
				System.arraycopy(this.array, index + 1, this.array, index, this.capacity - index - 1);
				// this.array[index] = null;
				this.size--;
				relocation();

				return true;
			}
		}
		return false;
	}

	// OK
	@Override
	public void clear() {

		this.array = new Object[this.initCapacity];
		this.size = 0;
	}

	// OK
	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {

		if (index > this.capacity || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return (T) this.array[index];
	}

	// OK
	@SuppressWarnings("unchecked")
	@Override
	public T set(int index, T element) {

		if (index > this.capacity || index < 0)
			throw new IndexOutOfBoundsException();

		T oldValue = (T) this.array[index];
		this.array[index] = element;

		return oldValue;
	}

	// OK
	@Override
	public void add(int index, T element) {

		relocation();
		if (index > this.size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		Object[] tmp = new Object[this.capacity];
		System.arraycopy(array, 0, tmp, 0, index);
		System.arraycopy(array, index, tmp, index + 1, this.capacity - index - 1);
		tmp[index] = (T) element;
		this.size++;
		System.arraycopy(tmp, 0, this.array, 0, this.capacity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) {

		relocation();

		if (index > this.capacity || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		T element = (T) this.array[index];
		System.arraycopy(this.array, index + 1, this.array, index, this.capacity - index - 1);
		this.size--;

		return element;
	}

	@Override
	public int indexOf(Object o) {

		if (this.capacity <= 0) {
			return -1;
		}

		for (int index = 0; index < this.size(); index++) {
			if (this.get(index).equals(o)) {
				return index;
			}
		}
		return -1;
	}

	/**
	 * Method to relocation array array is increased when filled is more than
	 * 90% array is decreased when filled is less than 60%
	 */
	private void relocation() {

		float ratio = ((float) (this.size() / (float) this.capacity)) * 100;
		Object[] tmpArray = new Object[this.capacity];

		System.arraycopy(this.array, 0, tmpArray, 0, this.size());
		if (ratio >= 90) {
			this.capacity += numOfChangeLength;
			this.array = new Object[this.capacity];
			System.arraycopy(tmpArray, 0, this.array, 0, tmpArray.length);

		} else if (ratio < 60) {
			if (this.capacity - numOfChangeLength > 0) {
				this.capacity -= numOfChangeLength;
				this.array = new Object[this.capacity];
				System.arraycopy(tmpArray, 0, this.array, 0, this.size());
			}

		}

	}

	/**
	 * Iterator for CustomArrayList
	 */
	private class CustomArrayListIterator<E> implements Iterator<E> {
		int currentIndex = -1;

		@Override
		public boolean hasNext() {

			int nextIndex = currentIndex + 1;
			if (nextIndex < size() && get(nextIndex) != null) {
				return true;
			}

			return false;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {

			return (E) get(++currentIndex);

		}

		@Override
		public void remove() {

			CustomArrayList.this.remove(new Integer(currentIndex));

		}
	}

	/*
	 * Method to write Array param - int x - to recognize which write
	 */
	void writeElements(int x) {
		System.out.println(x);
		System.out.println("SIZE_WRITE " + this.size() + " CAPACITY: " + this.getCapacity());
		for (int i = 0; i < this.getCapacity(); i++) {
			if (this.get(i) != null) {
				System.out.print("[" + i + "] " + this.get(i) + " ");
			} else {
				System.out.print("[" + i + "]: NULL ");
			}
		}
		System.out.println();
		System.out.println("-----------------------------");
	}

	public int getCapacity() {
		return this.capacity;
	}
}

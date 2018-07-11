package datastructure.list;

import java.util.Iterator;

/**
 * List based on recursively related objects
 *
 * @param <T>
 */

public class CustomLinkedList<T> extends AbstractCustomListAdapter<T> {

	private Node<T> head;
	private int size = 0;

	// OK
	@Override
	public int size() {
		return this.size;
	}

	// OK
	@Override
	public boolean isEmpty() {

		if (head != null) {
			return false;
		}
		return true;
	}

	private boolean checkEquals(Node<T> node, Object obj) {

		if (node.getValue() != null && node.getValue().equals(obj)) {
			return true;
		} else if (obj == null && node.getValue() == null) {
			return true;
		}
		return false;
	}

	// OK
	@Override
	public boolean contains(Object o) {

		if (this.isEmpty()) {
			return false;
		}

		if (checkEquals(this.head, o)) {
			return true;
		}
		Node<T> node = this.head;

		while (node.getNext() != null) {
			node = node.getNext();
			if (checkEquals(node, o)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new CustomLinkedListIterator<>();
	}

	// OK
	@Override
	public boolean add(T t) {

		Node<T> node = new Node<T>(t);

		if (this.isEmpty()) {
			this.head = node;
		} else {
			Node<T> next = this.head;

			while (next.getNext() != null) {
				next = next.getNext();
			}
			next.setNext(node);
		}
		this.size++;
		return true;
	}

	// OK
	@Override
	public boolean remove(Object o) {
		if (this.isEmpty()) {
			return false;
		}
		if (!this.contains(o)) {
			return false;
		}

		if (head.getValue().equals(o)) {
			this.head = head.getNext();
			this.size--;
			return true;
		}

		Node<T> prev = this.head;
		Node<T> node = this.head;

		while (node.getNext() != null) {
			prev = node;
			node = node.getNext();
			if (node.getValue().equals(o)) {
				prev.setNext(node.getNext());
				this.size--;
				return true;
			}
		}

		return false;
	}

	// OK
	@Override
	public void clear() {

		this.head = null;
		this.size = 0;
	}

	// OK
	@Override
	public T get(int index) {

		if (index > this.size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		if (this.isEmpty()) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0 && this.head != null) {
			return this.head.getValue();
		}

		int currentIndex = 0;
		Node<T> node = this.head;
		while (node.getNext() != null) {
			node = node.getNext();
			currentIndex++;
			if (currentIndex == index) {
				return node.getValue();
			}

		}
		return null;
	}

	// OK
	@Override
	public T set(int index, T element) {

		if (index >= this.size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		if (this.isEmpty()) {
			throw new IndexOutOfBoundsException();
		}

		T oldElement;
		int currentIndex = 1;

		if (index == 0) {
			oldElement = this.head.getValue();
			this.head.setValue(element);
			return oldElement;
		}

		Node<T> node = this.head;
		while (node.getNext() != null) {
			node = node.getNext();
			if (currentIndex == index) {
				oldElement = node.getValue();
				node.setValue(element);
				return oldElement;
			}
			currentIndex++;
		}

		throw new UnknownError();
	}

	// OK
	@Override
	public void add(int index, T element) {
		if (index >= this.size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		Node<T> node = new Node<T>(element);
		if (index == 0) {
			node.setNext(this.head);
			this.head = new Node<T>(node);
			this.size++;
			return;
		}

		Node<T> prev = this.head;
		Node<T> next = this.head;
		int currentIndex = 1;
		while (next.getNext() != null) {
			prev = next;
			next = next.getNext();
			if (currentIndex == index) {
				node.setNext(next);
				prev.setNext(node);
				this.size++;
				return;
			}
			currentIndex++;
		}

	}

	// OK
	@Override
	public T remove(int index) {

		if (index >= this.size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		Node<T> node = this.head;
		T element;
		if (index == 0) {
			element = this.head.getValue();
			this.head = this.head.getNext();
			this.size--;
			return element;
		}

		Node<T> prev = this.head;
		Node<T> next = this.head;
		int currentIndex = 1;
		while (node.getNext() != null) {
			prev = node;
			node = node.getNext();
			next = node.getNext();
			if (currentIndex == index) {
				element = node.getValue();
				this.size--;
				prev.setNext(next);
				return element;
			}
			currentIndex++;
		}
		return null;
	}

	// OK
	@Override
	public int indexOf(Object o) {

		if (this.isEmpty()) {
			return -1;
		}

		Node<T> node = this.head;
		int currentIndex = 0;
		while (node.getNext() != null) {
			if (node.getValue().equals(o)) {
				return currentIndex;
			}
			currentIndex++;
			node = node.getNext();
		}
		if (node.getValue().equals(o)) {
			return currentIndex;
		}
		return -1;
	}

	/**
	 * Iterator for CustomLinkedList
	 */
	private class CustomLinkedListIterator<E> implements Iterator<E> {
		private int currentIndex = 0;

		@Override
		public boolean hasNext() {

			int nextIndex = currentIndex + 1;
			if (nextIndex <= size() && get(currentIndex) != null) {
				return true;
			}
			return false;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			return (E) get(currentIndex++);
		}

		@Override
		public void remove() {

			CustomLinkedList.this.remove(--currentIndex);
		}
	}
}

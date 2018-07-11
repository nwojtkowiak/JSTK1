package datastructure.list;

/**
 * Component of linked list that stores a value and reference to the next
 * element.
 * 
 * @param <T>
 */

public class Node<T> {

	private T value;
	private Node<T> next;

	public Node() {

	}

	public Node(Node<T> node) {
		this.value = node.getValue();
		this.next = node.getNext();
	}

	public Node(T value, Node<T> next) {
		this.setValue(value);
		this.setNext(next);
	}

	public Node(T value) {
		this.setValue(value);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
}

package hello.ds;

public class DoubleEndedList {

	private Node head;
	private Node tail;

	public void addAtEnd(int data) {

		Node newNode = new Node(data);
		System.out.println(
				"data -->" + newNode.toString() + "this.head -->" + this.head + " <-- this.tail -->" + this.tail);
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		}

		if (this.tail != null) {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
	}

	public int getLength() {

		int length = 0;

		Node current = this.head;
		while (current != null) {

			length++;
			current = current.getNext();
		}

		return length;
	}

	@Override
	public String toString() {

		StringBuilder result = new StringBuilder("{ ");

		Node current = this.head;
		while (current != null) {

			result.append(current.toString() + ", ");
			current = current.getNext();
		}

		result.append(" }");

		return result.toString();
	}

}
/*
 * 
 * public class DoubleEndedList extends LinkedList {
 * 
 * private Node tail; private Node head;
 * 
 * public Node getTail() { return this.tail; }
 * 
 * public void addAtEnd(int data) { Node newNode = new Node(data);
 * System.out.println("data -->"+newNode.toString()+"this.head -->"+this.
 * head+" <-- this.tail -->"+this.tail ); if (this.head == null) { this.head =
 * newNode; } if (this.tail != null) { this.tail.setNext(newNode); this.tail =
 * newNode; } }
 * 
 * }
 */
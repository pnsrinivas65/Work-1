package hello.ds;

public class LinkedList {

	private Node head;

	public void insertAtHead(int data) {

		Node newNode = new Node(data);
		newNode.setNext(this.head);
		this.head = newNode;
	}

	public void insertAtEnd(int data) {

		Node current = this.head;
		while (current.getNext() != null) {
			current = current.getNext();
		}

		Node newNode = new Node(data);
		current.setNext(newNode);
	}

	public void insertAtSomePoint(int data, int position) {

		int length = getLength();

		if (length < position) {
			System.out.println("Not a valid position");
		}

		Node current = this.head;
		int count = 1;
		while (count < position - 1) {
			current = current.getNext();
			count++;
		}

		Node newNode = new Node(data);
		newNode.setNext(current.getNext());
		
		current.setNext(newNode);
		
		
	}

	public void deleteAtSomePoint(int position) {

		int length = getLength();

		if (length < position || position < 0) {
			System.out.println("Invalid Position");
		}
		Node current = this.head;
		int count = 1;
		while (count < position - 1) {
			current = current.getNext();
			count++;
		}
		Node newNode = current.getNext().getNext();
		current.setNext(newNode);

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

	public void deleteNodeAtHead() {

		this.head = this.head.getNext();
	}

	public Node find(int data) {
		Node current = this.head;
		while (current != null) {
			if (current.getData() == data) {
				return current;
			}
			current = current.getNext();
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		result.append("{ ");

		Node current = this.head;
		while (current != null) {
			result.append(current.toString() + ", ");
			current = current.getNext();
		}
		result.append(" }");
		return result.toString();
	}
	
	
}

package hello.ds;

public class LinkedListSorted {

	private Node head;

	public void insertNode(int data) {

		Node current = this.head;
		Node newNode = new Node(data);

		if (current == null || this.head.getData() > data) {

			newNode.setNext(this.head);
			this.head = newNode;
			return;
		}
		while (current != null && current.getNext() != null && current.getNext().getData() < data) {
			current = current.getNext();

		}
		newNode.setNext(current.getNext());
		current.setNext(newNode);

	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		result.append("{ ");

		Node current = this.head;
		while (current != null) {
			result.append(current.toString() + ", ");
			current = current.getNext();
			System.out.println("in to string" + current);
		}
		result.append(" }");
		return result.toString();
	}
}

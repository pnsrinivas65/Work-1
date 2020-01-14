package hello.ds;

public class DoubleLinkedList {

	
	private DoublyLinkedNode head;
	private DoublyLinkedNode tail;

	public DoublyLinkedNode getHead() {
		return this.head;
	}

	protected void setHead(DoublyLinkedNode head) {
		this.head = head;
	}

	public boolean isHead(DoublyLinkedNode node) {
		return this.head == node;
	}

	public void insertAtHead(Integer data) {
		
		DoublyLinkedNode newNode = new DoublyLinkedNode(data, this.head, null);
		newNode.setNextNode(this.head);
		
		if(this.head == null ) {
			head =  tail  = newNode;
			head.setPreviousNode(null);
			tail.setNextNode(null);
			
		} else {
			
			//newNode will be added after tail such that tail's next will point to newNode  
            tail.setNextNode(newNode);   
            //newNode's previous will point to tail  
            newNode.setPreviousNode(tail);  
            //newNode will become new tail  
            tail = newNode;  
            //As it is last node, tail's next will point to null  
            tail.setNextNode(null);  
			
		}
		
	}

	public int length() {
		if (head == null)
			return 0;
		int length = 0;
		DoublyLinkedNode curr = this.head;
		while (curr != null) {
			length += 1;
			curr = curr.getNextNode();
		}
		return length;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DoublyLinkedNode n = this.head;
		while (n != null) {
			sb.append("Node data: ");
			sb.append(""+n.getPreviousNode() +"::"+ n.getNextNode());
			sb.append("\n");
			n = n.getNextNode();
		}
		return sb.toString();
	}
	
	/*
	 * private DoublyLinkedNode head;
	 * 
	 * public void insertAtHead(int data) {
	 * 
	 * DoublyLinkedNode newNode = new DoublyLinkedNode(data);
	 * newNode.setNextNode(this.head);
	 * 
	 * System.out.println("this.head -->"+this.head); if (this.head != null) {
	 * this.head.setPrevNode(newNode); }
	 * 
	 * this.head = newNode;
	 * 
	 * }
	 * 
	 * public int length() {
	 * 
	 * if (head == null) return 0;
	 * 
	 * int length = 0;
	 * 
	 * DoubleLinkedNode curr = this.head; while (curr != null) { length += 1; curr =
	 * curr.getNextNode(); }
	 * 
	 * return length; }
	 * 
	 * public boolean isEmpty() { return this.head == null; }
	 * 
	 * 
	 * @Override public String toString() { StringBuilder sb = new StringBuilder();
	 * DoubleLinkedNode current = this.head; while (current != null) {
	 * sb.append("Node data: "); sb.append(""+current.getPrevNode() +
	 * current.getNextNode()); sb.append("\n"); current = current.getNextNode(); }
	 * return sb.toString(); }
	 */}

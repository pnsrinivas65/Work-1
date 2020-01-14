package hello.ds;


public class DoublyLinkedNode {
	private Integer data;
	private DoublyLinkedNode nextNode;
	private DoublyLinkedNode previousNode;

	public DoublyLinkedNode(Integer data, DoublyLinkedNode nextNode, DoublyLinkedNode preNode) {
		this.data = data;
		this.nextNode = nextNode;
		this.previousNode = preNode;
	}
	
	public Integer getData() {
		return data;
	}
	
	public DoublyLinkedNode getNextNode() {
		return nextNode;
	}
	
	public void setNextNode(DoublyLinkedNode nextNode) {
		this.nextNode = nextNode;
	}
	
	public DoublyLinkedNode getPreviousNode() {
		return previousNode;
	}
	
	public void setPreviousNode(DoublyLinkedNode prevNode) {
		this.previousNode = prevNode;
	}
	
	@Override
	public String toString() {
		return this.data.toString();
	}
}


/*
 * public class DoubleLinkedNode {
 * 
 * private int data;
 * 
 * private DoubleLinkedNode nextNode; private DoubleLinkedNode prevNode;
 * 
 * 
 * 
 * public DoubleLinkedNode(int data) { this.data = data; }
 * 
 *//**
	 * @return the data
	 */
/*
 * public int getData() { return data; }
 *//**
	 * @param data the data to set
	 */
/*
 * public void setData(int data) { this.data = data; }
 *//**
	 * @return the nextNode
	 */
/*
 * public DoubleLinkedNode getNextNode() { return nextNode; }
 *//**
	 * @param nextNode the nextNode to set
	 */
/*
 * public void setNextNode(DoubleLinkedNode nextNode) { this.nextNode =
 * nextNode; }
 *//**
	 * @return the prevNode
	 */
/*
 * public DoubleLinkedNode getPrevNode() { return prevNode; }
 *//**
	 * @param prevNode the prevNode to set
	 *//*
		 * public void setPrevNode(DoubleLinkedNode prevNode) { this.prevNode =
		 * prevNode; }
		 * 
		 * 
		 * public String toString() {
		 * 
		 * return "Data "+this.data; }
		 * 
		 * }
		 */
package hello.ds;

public class DoubleLinkedListDemo {
	
	public static void main(String s[]) {
		
		DoubleLinkedList list = new DoubleLinkedList();
		
		list.insertAtHead(1);
		list.insertAtHead(3);
		
		System.out.println("List -->"+list.toString());
	}

}

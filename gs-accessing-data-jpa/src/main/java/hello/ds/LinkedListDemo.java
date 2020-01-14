package hello.ds;

public class LinkedListDemo {

	
	public static void main(String s[]) {
	
		
		LinkedList list = new LinkedList();
		list.insertAtHead(5);
		list.insertAtHead(10);
		list.insertAtHead(2);
		list.insertAtHead(12);
		list.insertAtHead(19);
		list.insertAtHead(20);
		
		System.out.println("Actual list -->"+list);
		
		System.out.println("before deleting length -->"+list.getLength());
		
		System.out.println("Search -->"+list.find(1));
		list.deleteNodeAtHead();
		
		System.out.println("After deleting List -->"+list);
		System.out.println("After deleting the length"+list.getLength());
		list.insertAtEnd(22);
		System.out.println("Actual list after adding-->"+list);
		
		list.insertAtSomePoint(400, 3);
		System.out.println("Actual list after adding middle-->"+list);
		
		list.deleteAtSomePoint(3);
		System.out.println("Actual list after deleting middle-->"+list);
		
		LinkedListSorted sortList  = new LinkedListSorted();
		
		sortList.insertNode(10);
		System.out.println("in Main");
		System.out.println(" sortList after adding 10--> "+sortList.toString());
		sortList.insertNode(12);
		sortList.insertNode(2);
		sortList.insertNode(1);
		System.out.println(" sortList after adding 10--> "+sortList.toString());
		
	}
	
	
	
}

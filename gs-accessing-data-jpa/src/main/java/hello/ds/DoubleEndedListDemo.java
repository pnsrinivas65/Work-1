package hello.ds;

public class DoubleEndedListDemo {
	
	public static void main(String s[]) {
		
		DoubleEndedList dlist = new DoubleEndedList();
		
		dlist.addAtEnd(19);
		dlist.addAtEnd(29);
		dlist.addAtEnd(9);
		dlist.addAtEnd(99);
		
		System.out.println("List -->"+dlist +" <-- Length -->"+dlist.getLength());
	}
	

}

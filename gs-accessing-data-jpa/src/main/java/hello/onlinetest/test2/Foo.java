package hello.onlinetest.test2;

public class Foo {

	public void foo(boolean a, boolean b) {
		if (a) {
			System.out.println("A"); /* Line 5 */
		} else if (a && b) /* Line 7 */
		{
			System.out.println("A && B");
		} else /* Line 11 */
		{
			if (!b) {
				System.out.println("notB");
			} else {
				System.out.println("ELSE");
			}
		}
		
		Float f = new Float("12"); 
		switch (f.intValue()) 
		{
		    case 12: System.out.println("Twelve"); 
		    case 0: System.out.println("Zero"); 
		    default: System.out.println("Default"); 
		}
	}

}

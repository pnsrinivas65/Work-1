package hello.onlinetest.test1;

public class SwitchTest {
	public static void main(String[] args) {
		System.out.println("value =" + switchIt(4));
	}

	public static int switchIt(int x) {
		int j = 1;
		switch (x) {
		case 1:
			j++;
		case 2:
			j++;
		case 3:
			j++;
		case 4:
			j++;
		case 5:
			j++;
		default:
			j++;
			//break;
		}
		return j + x;
	}
}
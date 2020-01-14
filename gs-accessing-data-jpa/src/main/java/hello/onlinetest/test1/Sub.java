package hello.onlinetest.test1;

class Super {
	public Integer getLength() {
		return new Integer(4);
	}
}

public class Sub extends Super {
	public Integer getLength() {
		return new Integer(5);
	}

	public static void main(String[] args) {
		Super sooper = new Super();
		Sub sub = new Sub();
		System.out.println(sooper.getLength().toString() + "," + sub.getLength().toString());
	}
}
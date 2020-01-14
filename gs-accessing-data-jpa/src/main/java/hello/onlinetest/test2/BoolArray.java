package hello.onlinetest.test2;

class BoolArray {
	boolean[] b = new boolean[3];
	int count = 0;

	void set(boolean[] x, int i) {
		x[i] = true;
		++count;
	}

	public static void main(String[] args) {
		BoolArray ba = new BoolArray();
		ba.set(ba.b, 0);
		ba.set(ba.b, 2);
		ba.test();
	}

	void test() {
		if (b[0] && b[1] | b[2])
			count++;
		if (b[1] && b[(++count - 2)])
			count += 7;
		System.out.println("count = " + count);
	}
}
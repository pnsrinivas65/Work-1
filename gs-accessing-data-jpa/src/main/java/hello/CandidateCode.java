package hello;


import java.util.Scanner;

class Rectangle {
	int h, w;

	void display(int height, int width) {
		h = height;
		w = width;
		System.out.println(h + " " + w);
	}
}

class RectangleArea extends Rectangle {
	int height, width;

	public void read_input() {
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();
		width = sc.nextInt();
	}

	void display() {
		super.display(height, width);
		System.out.print(height * width);
	}
}

public class CandidateCode {
	public static void main(String args[]) throws Exception {
		RectangleArea a = new RectangleArea();
		a.read_input();
		a.display();
	}
}

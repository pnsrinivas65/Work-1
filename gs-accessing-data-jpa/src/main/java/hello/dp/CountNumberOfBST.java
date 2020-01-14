package hello.dp;

public class CountNumberOfBST {

	public static void main(String[] args) {
		CountNumberOfBST bst = new CountNumberOfBST();
		System.out.println("1 -->" + bst.maxNumberofBST(1));
		System.out.println("2 -->" + bst.maxNumberofBST(2));
		System.out.println("3 -->" + bst.maxNumberofBST(3));
		System.out.println("4 -->" + bst.maxNumberofBST(4));

	}

	public int maxNumberofBST(int number) {

		int [] temp = new int[number + 1];
		
		

		if (number == 0 || number == 1) {
			return 1;
		}

		temp[0] = 1;
		temp[1] = 1;

		for (int i = 2; i <= number; i++) {

			for (int j = 0; j < i; j++) {

				temp[i] = temp[i] + (temp[j] * temp[i - j - 1]);

			}
		}
		return temp[number];

	}
}

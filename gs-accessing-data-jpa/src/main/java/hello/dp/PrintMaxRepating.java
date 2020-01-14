package hello.dp;

public class PrintMaxRepating {

	public static void main(String s[]) {

		PrintMaxRepating pmr = new PrintMaxRepating();
		String inputString = "abaabbbc";
		pmr.printMaxRepatChar(inputString);
	}

	private char printMaxRepatChar(String inputString) {

		int maxRepatCount = 0;
		int count = 0;
		char res[] = new char[1];
		int length = inputString.length();
		for (int i = 0; i < length; i++) {

			if ((i < length - 1) 
					&& (inputString.charAt(i) == inputString.charAt(i + 1))) {
				maxRepatCount++;
			} else {
				if (maxRepatCount > count) {
					count = maxRepatCount;
					res[0] = inputString.charAt(i);
					System.out.println("Count -->" + count + "res[0]"+res[0]);
				}
				maxRepatCount = 1;
			}
		}
		
		return res[0];

	}

}

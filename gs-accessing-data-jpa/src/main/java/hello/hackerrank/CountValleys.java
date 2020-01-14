package hello.hackerrank;

public class CountValleys {

	public static void main(String s[]) {

		String code = "UDDDUDUU";
		int length = 8;

		countingValleys(length, code);
	}

	// Complete the countingValleys function below.
	static int countingValleys(int n, String s) {

		int countOfValleys = 0;
		int altitude = 0;
		for (int i = 0; i < s.length(); i++) {
			System.out.println("countOfValleys -->" + countOfValleys + "<-- altitude -->" + altitude);
			if (s.charAt(i) == 'U') {
				altitude++;

				if (altitude == -1) {
					countOfValleys += countOfValleys;
				}

			} else {
				altitude--;
			}
		}
		
		return 0;
	}

}

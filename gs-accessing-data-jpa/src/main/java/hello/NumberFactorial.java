package hello;

import java.math.BigInteger;

public class NumberFactorial {

	private int min_value = 1;
	private int max_value = 1000;

	public static void main(String s[]) {
		NumberFactorial nb = new NumberFactorial();
		//long timeinMilliSeconds = System.nanoTime();
		//System.out.println("Before Calling Iterative"+System.nanoTime());
		int factorial = 6;
		System.out.println("Value -->" + nb.getFactorial(factorial));
		//System.out.println("Before Iterative"+(System.nanoTime()-timeinMilliSeconds));
		//timeinMilliSeconds = System.nanoTime();
		System.out.println("Value from Recursive-->" + nb.getFactorialByRecursive(factorial, true));
		//System.out.println("After Recursive"+(System.nanoTime()-timeinMilliSeconds));
	}

	public BigInteger getFactorial(int number) {

		BigInteger factorialValue = BigInteger.ONE;

		if (number <= min_value || number >= max_value) {
			return BigInteger.valueOf(-1);
		}

		// if user enter 20, 20*19*18.....
		for (int i = 1; i <= number; i++) {
			factorialValue = factorialValue.multiply(BigInteger.valueOf(i));
		}
		return factorialValue;
	}

	public BigInteger getFactorialByRecursive(int number, boolean fromRecursive) {

		BigInteger factorialValue = BigInteger.ONE;

		if (fromRecursive && (number <= min_value || number >= max_value)) {
			return BigInteger.valueOf(-1);
		}
		if (number > 1) {
			factorialValue = getFactorialByRecursive(number - 1, false).multiply(BigInteger.valueOf(number));
		}
		return factorialValue;
	}
}
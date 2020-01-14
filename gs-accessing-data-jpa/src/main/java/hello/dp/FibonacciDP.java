package hello.dp;

import java.util.Arrays;

public class FibonacciDP {

	int memo[] = new int[100];

	public int fibo(int n) {
		if (n <= 1) {
			//memo[n] = 1;
			return n;
		}
		// If we have processed this function before, return the result from the last time.
		if (memo[n] != 0) {
			return memo[n];
		
		}
		// Otherwise calculate the result and remember it.
		memo[n] = fibo(n - 1) + fibo(n - 2);
		System.out.println("memo["+n+"] -->"+memo[n]);
		return memo[n];
	}
	
	public static int fibDP(int x) {
		int fib[] = new int[x + 1];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < x + 1; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[x];
	}

	
	public int getFibonacci(int number) {
		int fibNumber = 0;
		int fibNumberLoop[] = new int[number];
		if(number == 0 || number == 1) {
			return number;
		} else if(number > 1) {
			fibNumber = fibNumber + (getFibonacci(number-1)+getFibonacci(number-2));
		}
		fibNumberLoop[0] = 1;
		fibNumberLoop[1] = 2;
		for(int i = 2; i < number; i++) {
			fibNumberLoop[i] = fibNumberLoop[i-1] + fibNumberLoop[i-2];
			System.out.println(" <-- fibNumberLoop --> "+Arrays.toString(fibNumberLoop));
		}
		
		return fibNumber;
	}
	
	public static void main(String s[]) {

		FibonacciDP fib = new FibonacciDP();
		int value = fib.fibo(8);
		System.out.println("value -->" + value);
		
		int valueDP = fibDP(8);
		System.out.println("valueDP -->" + valueDP);
		
		System.out.println(fib.getFibonacci(8));
	}

}

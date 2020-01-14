package hello;

import java.util.stream.IntStream;

public class PrimesPrint {
	
	
	private Object toList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static boolean isPrime(long n) {
        return n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(divisor -> n % divisor == 0);
    }


}

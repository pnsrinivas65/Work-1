package hello.lambda;

import java.sql.Time;

public class ParallelStream {
	
	public static void main(String [] s) {
		
		
	}
	
	public static void testParallelStreams() {
		
		Employee emps[] = StreamsExample.getEmployees();
		
		System.out.println("Stateless sequential stream");
		
		long total = getTotalAgeSequential();
		
		//total = ParallelStream::getTotalAgeSequential, emps;
	}

	private static long getTotalAgeSequential() {
		
		return 0;
	}

}

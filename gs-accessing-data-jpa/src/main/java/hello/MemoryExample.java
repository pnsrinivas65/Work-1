package hello;

public class MemoryExample {
	  public MemoryExample() {}
	  public static long demo(long a, long b) {
	    return new Long(a+b).longValue();
	  }
	  public static void main(String[] args) {
	    // Warmup to avoid counting classloading allocations
	    demo(1L, 2L);
	    
	    long start = Evil.readTLABPointer();
	    demo(1L, 2L);
	    long end = Evil.readTLABPointer();
	    System.out.println(end-start);
	    // Hopefully force a c2 compile:
	    for(long i = 0; i < 10000000; i++) {
	      demo(i, i+1);
	    }
	    start = Evil.readTLABPointer();
	    demo(1L,2L);
	    end = Evil.readTLABPointer();
	    System.out.println(end-start);
	  }
	}
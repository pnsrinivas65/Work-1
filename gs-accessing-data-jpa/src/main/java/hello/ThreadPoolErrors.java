package hello;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolErrors extends ThreadPoolExecutor {
    public ThreadPoolErrors() {
        super(  1, // core threads
                1, // max threads
                1, // timeout
                TimeUnit.MINUTES, // timeout units
                new LinkedBlockingQueue<Runnable>() // work queue
        );
    }

    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if(t != null) {
            System.out.println("Got an error: " + t);
        } else {
            System.out.println("Everything's fine--situation normal!");
            if (t == null && r instanceof Future<?>) {
            	System.out.println(" 1 -->"+t);
                try {
                    Future<?> future = (Future<?>) r;
                    System.out.println(" 2 -->"+t);
                    if (future.isDone()) {
                    	
                        future.get();
                        System.out.println(" 3 -->"+t);
                    }
                } catch (CancellationException ce) {
                    t = ce;
                    System.out.println(" exception 1 -->"+t);
                } catch (ExecutionException ee) {
                    t = ee.getCause();
                    System.out.println(" exception 2 -->");
                    t.printStackTrace();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    System.out.println(" exception 3  -->"+t);
                }
            }
            if (t != null) {
                System.out.println("Here --> "+t.getLocalizedMessage());
            }
        }
    }

    public static void main( String [] args) {
        ThreadPoolErrors threadPool = new ThreadPoolErrors();
        threadPool.submit( 
                new Runnable() {
                    public void run() {
                        throw new RuntimeException("Ouch! Got an error.");
                    }
                }
        );
        threadPool.shutdown();
    }
}

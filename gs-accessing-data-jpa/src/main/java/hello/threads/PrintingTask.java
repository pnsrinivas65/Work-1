package hello.threads;

import java.io.PrintStream;

public class PrintingTask implements Runnable {

	private final PrintStream stream;
    private final int first;
    private final int last;
    private final int incr;

    public PrintingTask(final PrintStream stream,
                        final int first,
                        final int last,
                        final int incr) {
        if (stream == null) {
            throw new NullPointerException("stream");
        }
        this.stream = stream;
        this.first = first;
        this.last = last;
        this.incr = incr;
    }

    @Override
    public void run() {
        for (int i = this.first; i <= this.last; i+= this.incr) {
            synchronized (this.stream) {
                this.stream.println(i);
            }
            try {
                Thread.sleep(100);
            } catch (final InterruptedException e) {
                return;
            }
        }
    }

}

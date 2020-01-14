package hello.onlinetest.test2;

class MyThread extends Thread 
{
    public static void main(String [] args) 
    {
        MyThread t1 = new MyThread();
        t1.start();
        System.out.print("one. ");
        MyThread t2 = new MyThread();
        t2.start();
        System.out.print("two. ");
    }
    public void run() 
    {
        System.out.print("Thread ");
    }
}
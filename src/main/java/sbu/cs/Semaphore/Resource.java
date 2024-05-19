package sbu.cs.Semaphore;

public class Resource {

    public static void accessResource(String threadName) {
        try {
//            System.out.println(threadName + " " + System.currentTimeMillis());
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package sbu.cs.Semaphore;

import java.util.concurrent.Semaphore;

public class Operator extends Thread {

    private Semaphore semaphore;
    private Resource resource;

    public Operator(String name, Semaphore semaphore, Resource resource) {
        super(name);
        this.semaphore = semaphore;
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++)
        {
//            Resource.accessResource(getName());         // critical section - a Maximum of 2 operators can access the resource concurrently
            try {
                semaphore.acquire();
                System.out.println(getName() + " " + System.currentTimeMillis());
                Resource.accessResource(getName());
//                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }
}

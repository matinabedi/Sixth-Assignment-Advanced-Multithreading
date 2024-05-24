package sbu.cs.Semaphore;

import java.util.concurrent.Semaphore;

public class Operator extends Thread {
    private  String name;
    private Semaphore semaphore;

    public Operator(String name , Semaphore semaphore) {
        this.name=name;
        this.semaphore=semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("starting  "+name);

            System.out.println(name+"  is waiting for a permit ");

            semaphore.acquire();
            System.out.println(name+"  gets a permit");

            for (int i = 0; i < 10; i++)
            {
                Resource.accessResource();
                sleep(500);
                System.out.println(i);
            }
            System.out.println(name+"  release the permit");
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

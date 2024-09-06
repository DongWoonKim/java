package himedia.java;

// * 기아 현상(Starvation)
// 멀티스레딩 프로그래밍에서 특정 스레드가 다른 스레드들에 의해 지속적으로 자원을 얻지 못해
// 실행되지 못하는 상황을 의미한다.
// 이 문제를 해결하는 방법 중 하나로, notifyAll()을 사용할 수 있다.
// notifyAll() 대기 중인 모든 스레드를 깨워서 자원을 경쟁하도록 한다.
// 반면에 notify()는 대기 중인 스레드 중 하나만 깨우기 때문에 기아 현상이 발생할 가능성이 크다.

// 스레드들 간에 자원을 고르게 배분하지 않고 notify()만 사용하여 특정 스레드가
// 자원을 계속 얻지 못하는 상황을 시뮬레이션하고, notifyAll()을 사용해 기아 현상을 해결.

class SharedResource {

    private boolean isAvailable = false;

    // 자원을 대기하는 메서드
    public synchronized void waitForResource(String threaName) {
        while (!isAvailable) {
            try {
                System.out.println(threaName + " is waiting for resource...");
                wait(); // 자원이 사용 가능할 때까지 대기
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(threaName + " got the resource!");
        isAvailable = false;
    }

    // 자원을 공급하는 메서드
    public synchronized void makeResourceAvailable() {
        isAvailable = true;
        System.out.println("Resource is now available!");
//        notify();
        notifyAll();
    }

}

class WorkerThread extends Thread {
    private SharedResource sharedResource;
    private String threadName;

    public WorkerThread(SharedResource sharedResource, String threadName) {
        this.sharedResource = sharedResource;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while (true) {
            sharedResource.waitForResource(threadName);
            try {
                Thread.sleep(1000); // 자원을 얻은 후 1초간 작업 수행
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class C_thread_8_3_notifyAll {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        WorkerThread worker1 = new WorkerThread(sharedResource, "worker1");
        WorkerThread worker2 = new WorkerThread(sharedResource, "worker2");
        WorkerThread worker3 = new WorkerThread(sharedResource, "worker3");

        worker1.start();
        worker2.start();
        worker3.start();

        // 2초마다 자원을 공급
        new Thread( () -> {
                while (true) {
                    try {
                        Thread.sleep(2000);
                        sharedResource.makeResourceAvailable();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        ).start();

    }
}

package himedia.java;

// * 스레드의 실행 제어
// ** 스레드 상태
// [NEW] : 스레드가 생성되고 아직 start()가 호출이되지 않은 상태.

// [RUNNABLE] : 실행 중 또는 실행 가능한 상태(실행대기)
// -> 스레드를 생성하고 start()를 호출하면 바로 실행되는 것이 아니라
// 실행대기열에 저장되어 자신의 차례가 될 때까지 기다려야 한다.
// 실행대기열은 큐(queue)와 같은 구조로 먼저 실행대기열에 들어온 스레드가 먼저 실행된다.
// 주어진 실행 시간이 다되거나 yield()를 만나면 다시 실행 대기상태가 되고 다음 차례의 스레드가 실행된다.

// [BLOCKED] : 동기화블럭에 의해서 일시정지된 상태(lock이 풀릴 때까지 기다리는 상태)

// [WAITING, TIMED_WAITING] : 스레드의 작업이 종료되지 않았지만 실행가능하지 않은 일시정지 상태,
// TIMED_WAITING은 일시정지시간이 지정된 경우를 의미한다.
// -> 실행 중에 suspend(), sleep(), wait(), join(), I/O block에 의해 일시정지된상태가 될 수 있다.
// I/O block은 입출력잡업에서 발생하는 지연상태를 뜻한다. 사용자의 입력을 기다리는 경우를 예로 들 수 있는데
// 이런 경우 일시정지 상태에 있다가 사용자가 입력을 마치면 다시 실행대기 상태가 된다.
// -> 지정된 일시정지시간이 다되거나(time-out), notify(), resume(), interrupt()가 호출되면
// 일시 정지 상태를 벗어나 다시 실행대기열에 저장되어 자신의 차례를 기다리게 된다.

// [TERMINATED] : 스레드의 작업이 종료된 상태
// -> 실행을 모두 마치거나 stop()이 호출되면 스레드는 소멸된다.

// * 메서드
// - sleep() : 지정된 시간동안 스레드를 일시정지 시킨다.
// 지정한 시간이 지나고 나면, 자동적으로 다시 실행대기 상태가 된다.
// - join() : 지정된 시간동안 스레드가 실행되도록 한다. 지정된 시간이 지나거나 작업이 종료되면
// join()을 호출한 스레드로 다시 돌아와 실행을 계속한다.
// - interrupt() : sleep()이나 join()에 의해 일시정지상태인 스레드를 깨워서 실행대기상태로 만든다.
// 해당 스레드에서는 interruptedException이 발생함으로써 일시정지 상태를 벗어나게 된다.
// - stop() : 스레드를 즉시 종료시킨다.
// - suspend() : 스레드를 일시정지시킨다. resume()을 호출하면 다시 실행대기상태가 된다.
// - resume() : suspend()에 의해 일시정지상태에 있는 스레드를 실행대기상태로 만든다.
// - yield() : 실행 중에 자신에게 주어진 실행시간으로 다른 스레드에게 양보하고 자신은 실행대기상태가 된다.

// -> resume(), stop(), suspend()는 스레드를 교착상태로 만들기 쉽기 때문에 deprecated되었다.

import java.util.Scanner;

class ThreadEx_sleep_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; ++i) {
            System.out.print("-");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("<<th1 종료>>");
    }
}

class ThreadEx_sleep_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; ++i) {
            System.out.print("|");
        }
        System.out.println("<<th2 종료>>");
    }
}

class ThreadEx_interrupt_1 extends Thread {
    @Override
    public void run() {
        int i = 10;
        while ( i != 0 && !isInterrupted() ) {
            System.out.println(i--);
            for ( long x = 0; x < 2500000000L; x++ ) ; //시간 지연
        }

        System.out.println("카운트가 종료되었습니다.");
    }
}

class ThreadEx_interrupt_2 extends Thread {
    @Override
    public void run() {
        int i = 10;
        while ( i != 0 && !isInterrupted() ) {
            System.out.println(i--);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("카운트가 종료되었습니다.");
    }
}

class ThreadEx_yield extends Thread {
    private String name;

    public ThreadEx_yield(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; ++i) {
            System.out.println(name + " is running. Iteration : " + i);

            // 현재 실행 중인 스레드가 다른 스레드에게 실행 기회를 양보
            Thread.yield();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class ThreadEx_join_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 30000; ++i) {
            System.out.print("-");
        }
        System.out.println();
    }
}

class ThreadEx_join_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 30000; ++i) {
            System.out.print("|");
        }
        System.out.println();
    }
}

public class C_thread_7 {

    // - sleep()
    public static void exam1() {
        ThreadEx_sleep_1 t1 = new ThreadEx_sleep_1();
        ThreadEx_sleep_2 t2 = new ThreadEx_sleep_2();
        t1.start();
        t2.start();

//        try {
//            t1.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("<<main 종료>>");

        // t1이 가장 늦게 종료되어야 하는데 결과에서는 제일 먼저 종료가 될 때가 있다.
        // 그 이유는 sleep()이 항상 현재 실행 중인 스레드에 대해 작동하기 때문에 t1.sleep()을 하였어도
        // 실제로 영향을 받는 것은 main메서드를 실행하는 main스레드이다.
        // 그래서 sleep()은 참조변수를 이용해서 호출하기 보다 static으로 선언되어 있는 Thread.sleep(2000)과
        // 같이 사용 해야 한다.

    }

    // - interrupt() : 스레드의 작업을 취소한다.
    // 진행중인 스레드의 작업이 끝나기 전에 취소시켜야할 때가 있다.
    // 예를들어 큰 파일을 다운로드 받을 때 시간이 너무 오래 걸리면 중간에 다운로드를 포기하고
    // 취소할 수 있어야 한다.
    // interrupt()는 스레드에게 작업을 멈추라고 요청한다.
    // 단지 멈추라고 요청만 하는 것일 뿐 스레드를 강제로 종료시키지는 못한다.
    // 그리고 interrupted()는 스레드에 대해 interrupt()가 호출되었는지 알려준다.
    // interrupted()가 호출되지 않았다면 false, 호출되었다면 true를 반환한다.
    public static void exam2_1() {
        ThreadEx_interrupt_1 t1 = new ThreadEx_interrupt_1();
        t1.start();

        System.out.println("I1 : " + t1.isInterrupted());
        System.out.println("아무 값이나 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("입력한 값은 " + input + "입니다.");
        t1.interrupt();
        System.out.println("I2 : " + t1.isInterrupted());
    }

    // 스레드가 sleep(), wait(), join()에 의해 '일시 정지 상태(WAITING)'에 있을 때,
    // 해당 스레드에 대해 interrupt()를 호출하면, sleep(), wait(), join()에서
    // InterruptedException이 발생하고 스레드는 '실행 대기 상태'로 바뀐다.
    public static void exam2_2() {
        ThreadEx_interrupt_2 t1 = new ThreadEx_interrupt_2();
        t1.start();

        System.out.println("I1 : " + t1.isInterrupted());
        System.out.println("아무 값이나 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("입력한 값은 " + input + "입니다.");
        t1.interrupt();
        System.out.println("I2 : " + t1.isInterrupted());
    }

    // - Thread.yield()
    // 자바의 스레드 제어 메서드 중 하나로, 현재 실행 중인 스레드가 CPU를 다른 스레드에게 양보하도록한다.
    // 즉 실행 상태에 있는 스레드가 자신의 남은 시간을 포기하고 다른 스레드에게 기회를 주도록
    // 스케줄러에게 신호를 보내는 역할을 한다.
    // 그러나 yield() 메서드는 단순히 힌트일 뿐이며, 반드시 다른 스레드가 CPU시간을 받는다는 보장은 없다.
    // 실제로 CPU를 다른 스레드가 차지할지 여부는 자바 스레드 스케줄러와 운영체제의 결정에 따라 달라진다.
    public static void exam3() {
        ThreadEx_yield t1 = new ThreadEx_yield("Thread 1");
        ThreadEx_yield t2 = new ThreadEx_yield("Thread 2");

        t1.start();
        t2.start();
    }

    // - join() : 다른 스레드의 작업을 기다린다.
    public static void exam4() {
        ThreadEx_join_1 t1 = new ThreadEx_join_1();
        ThreadEx_join_2 t2 = new ThreadEx_join_2();

        t1.start();
        t2.start();

        long startTime = System.currentTimeMillis();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime) + "ms");
        // join을 사용하지 않았다면 main스레드가 바로 종료되었겠지만,
        // join()으로 스레드 t1, t2가 모두 작업을 마칠 때까지 main스레드가 기다리도록 하였다.
    }

    public static void main(String[] args) {
        exam4();
    }
}

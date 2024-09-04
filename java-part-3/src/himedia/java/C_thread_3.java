package himedia.java;

// * 싱글 스레드와 멀티스레드
// 두 개의 작업을 하나의 스레드로 처리하는 경우와 두 개의 스레드로 처리하는 경우,
// 하나의 스레드로 두 작업을 처리하는 경우는 한 작업을 마친 후에 다른 작업을 시작하지만
// 두 개의 스레드로 작업 하는 경우에는 짧은 시간동안 2개의 스레드가 번갈아 가면서 작업을 수행해서
// 동시에 두 작업이 처리되는 것과 같이 느끼게 한다.
// 하나의 스레드로 두개의 작업을 수행한 시간과 두개의 스레드로 두 개의 작업을 수행한 시간은 거의 같다.
// 오히려 두 개의 스레드로 작업한 시간이 싱글스레드로 작업한 시간보다 더 걸리게 되는데
// 그 이유는 스레드간의 작업전환(Context Switching)에 시간이 걸리기 때문이다.
// 그래서 싱글 코어에서 단순히 cpu만을 사용하는 계산작업이라면 오히려 멀티스레드보다
// 싱글스레드 프로그래밍하는 것이 더 효율적이다.
class C_threadEx_time extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3000; ++i) {
            System.out.printf("%s", new String("|"));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("소요시간 2 : " + (endTime - C_thread_3.startTime) + "ms");
    }
}

public class C_thread_3 {
    static long startTime = 0;

    public static void exam1() {
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        for (int i = 0; i < 3000; ++i) {
            System.out.printf("%s", new String("-"));
        }
        long endTime = System.currentTimeMillis();
        System.out.print("소요시간 1 : " +  (endTime - startTime) + "ms");
        for (int i = 0; i < 3000; ++i) {
            System.out.printf("%s", new String("|"));
        }
        System.out.print("소요시간 2 : " +  (endTime - startTime) + "ms");

    }

    // 결과는 실행할 때마다 다른 결과를 얻을 수 있는데 그 이유는 실행 중인 프로세스가
    // OS의 스케줄러의 영향을 받기 때문이다.
    // JVM의 스레드 스케줄러에 의해서 어떤 스레드가 얼마동안 실행될 것인지 결정되는 것과 같이
    // 프로세스도 프로세스 스케줄러에 의해 할당되는 시간 역시 일정하지 않게 된다.
    // 그래서 스레드가 이러한 불확실성을 가지고 있다는 것을 염두해 두어야 한다.
    // 자바가 OS에 독립적이라고 하지만 실제로 OS종속적인 부분이 몇 가지 있는데 스레드도 그 중 하나이다.
    // 두 스레드가 서로 다른 자원을 사용하는 작업의 경우에는 싱글스레드 프로세스보다 멀티프로세스가 더 효율적이다.
    public static void exam2() {
        C_threadEx_time t1 = new C_threadEx_time();
        t1.start();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 3000; ++i) {
            System.out.printf("%s", new String("-"));
        }
        long endTime = System.currentTimeMillis();
        System.out.print("소요시간 1 : " +  (endTime - startTime) + "ms");
    }

    public static void main(String[] args) {
        exam2();
    }
}

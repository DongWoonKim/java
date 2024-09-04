package himedia.java;

// * 스레드의 우선순위
// 스레드는 우선순위라는 속성을 가지고 있는데, 이 우선순위 값에따라 스레드가 얻는 실행시간이 달라진다.
// 스레드가 수행하는 작업의 중요도에 따라 스레드의 우선순위를 서로 다르게 지정하여 특정 스레드가
// 더 많은 작업시간을 갖을 수 있도록 할 수 있다.
// 스레드가 가질 수 있는 우선순위 범위는 1~10이며 숫자가 높을수록 우선순위가 높다.

// 스레드의 우선순위는 스레드를 생성한 스레드로부터 상속받는다.
// main메서드를 수행하는 main스레드는 우선순위가 5이므로 main메서드 내에서 생성하는 스레드의
// 우선순위는 자동적으로 5가 된다.

// OS마다 다른 방식으로 스케줄링을 하기 때문에, 어떤 OS에서 실행하느냐에 따라 다른 결과를 얻을 수 있다.
// 굳이 우선순위에 차등을 두어 스레드를 실행하려면, 특정 OS의 스케줄링 정책과 JVM의 구현을 직접 확인해봐야 한다.
// 만일 확인하더라도 OS의 스케줄러에 종속적이라서 어느 정도 예측만 가능한 정도일 뿐 정확히 알 수는 없다.
// 차라리 스레드에 우선순위를 부여하는 대신 작업에 우선순위를 두어 PriorityQueue에 저장해 놓고 사용하는것이
// 더 나을 수 있다.
class C_threadEx_pri_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3000; i++) {
            System.out.print("-");
        }
    }
}

class C_threadEx_pri_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3000; i++) {
            System.out.print("|");
        }
    }
}

public class C_thread_4_priority {
    public static void main(String[] args) {
        C_threadEx_pri_1 t = new C_threadEx_pri_1();
        C_threadEx_pri_2 t2 = new C_threadEx_pri_2();

        t2.setPriority(7);

        System.out.println("Pri 1 : " + t.getPriority());
        System.out.println("Pri 2 : " + t2.getPriority());

        t.start();
        t2.start();
    }
}

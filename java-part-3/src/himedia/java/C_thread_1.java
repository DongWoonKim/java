package himedia.java;

// * 프로세스와 스레드
// 프로세스란 '실행중인 프로그램'이다.
// 프로그램을 실행하면 OS로부터 실행에 필요한 자원(메모리)을 할당받아 프로세스가 된다.
// 프로세스의 자원을 이용해서 실제로 작업을 수행하는 것이 바로 '스레드'이다.
// 그래서 모든 프로세스에는 최소한 하나 이상의 스레드가 존재하며,
// 둘 이상의 스레드를 가진 프로세스를 '멀티 스레드 프로세스'라고 한다.
// 하나의 프로세스가 가질 수 있는 스레드의 개수는 제한되어 있지 않으나
// 스레드가 작업을 수행하는데 개별적인 메모리 공간(호출 스택)을 필요로하기 때문에
// 프로세스의 메모리 한계에 따라 생성할 수 있는 스레드의 수가 결정된다.

// * 멀티 스레딩의 장단점
// 장점
// - CPU의 사용률을 향상시킨다.
// - 자원을 보다 효율적으로 사용할 수 있다.
// - 사용자에 대한 응답성이 향상된다.
// - 작업이 분리되어 코드가 간결해진다.

// 여러 사용자에게 서비스를 해주는 서버 프로그램의 경우 멀티스레드로 작성하는 것이 필수적이어서
// 하나의 서버 프로세스가 여러 개의 스레드를 생성해서 스레드와 사용자의 요청이 일대일로 처리되도록
// 프로그래밍해야 한다.
// 만일 싱글 스레드로 서버 프로그램을 작성한다면 사용자의 요청 마다 새로우 프로세스를 생성해야하는데,
// 프로세스를 생성하는 것은 스레드를 생성하는 것에 비해 더 많은 시간과 메모리 공간이 필요하기 때문에
// 많은 수의 사용자 요청을 서비스하기 어렵다.

// 그러나 멀티스레드 프로세스는 여러 스레드가 같은 프로세스 내에서 자원을 공유하면서
// 작업을 하기 때문에 발생할 수 있는 동기화, 교착상태와 같은 문제들을 고려해서 신중하게 프로그래밍해야 한다.

// * 스레드를 구현하는 방법
// 1. Thread클래스를 상송
// 2. Runnable인터페이스를 구현

// Runnable인터페이스를 구현한 경우, Runnable인터페이스를 구현한 클래스의 인스턴스를 생성한 다음,
// 이 인스턴스를 Thread클래스의 생성자의 매개변수로 제공해야 한다.

// -> 어느 쪽을 선택해도 별 차이는 없지만, Thread클래스를 상속받으면 다른 클래스를 상속받을 수 없기 때문에,
// -> Runnable인터페이스를 구현하는 방법이 일반적이다.

class ThreadEx_extends extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println("th1 : " + i + " : " + getName());
        }
    }
}

class ThreadEx_runnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println("th2 : " + i + " : " + Thread.currentThread().getName());
        }
    }
}

public class C_thread_1 {
    public static void main(String[] args) {
        ThreadEx_extends t1 = new ThreadEx_extends();

        ThreadEx_runnable r = new ThreadEx_runnable();
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        // ** 한 번 실행이 종료된 스레드는 다시 실행할 수 없다.
        // 즉 하나의 스레드에 대해서 start()가 한 번만 호출될 수 있다는 뜻이다.
        // 그래서 만일 스레드의 작업을 한 번 더 수행해야 한다면 새로운 스레드를 생성한 다음에
        // start()를 호출해야 한다.
//        t1.start(); // 에러
        t1 = new ThreadEx_extends();
        t1.start();

    }
    
}

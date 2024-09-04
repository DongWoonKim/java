package himedia.java;

// * start()와 run()
// main메서드에서 run()을 호출하는 것은 생성된 스레드를 실행시키는 것이 아니라
// 단순히 클래스에 선언된 메서드를 호출하는 것일 뿐이다.
// 반면에 start()는 새로운 스레드가 작업을 실행하는데 필요한 호출스택을 생성한 다음에
// run()을 호출해서, 생성된 호출스택에 run()이 첫 번째로 올라가게 된다.
// 모든 스레드는 독립적인 작업을 수행하기 위해 자신만의 호출스택을 필요로 하기 때문에
// 새로운 스레드를 생성하고 실행시킬 때마다 새로운 호출스택이 생성되고 스레드가 종료되면
// 작업에 사용된 호출스택은 소멸된다.

// 스레드가 둘 이상일 때는 호출스택의 최상위에 있는 메서드 일지라도 대기상태 있을 수 있다.
// 각 스레드들은 작성된 스케줄러에 따라 자신의 순서가 되면 지정된 시간동안 작업을 수행한다.
// 이 때 주어진 시간동안 작업을 마치지 못한 스레드는 다시 자신의 차례가 돌아올 때까지 대기상태로 있게 되며,
// 작업을 마친 스레드, 즉 run()의 수행이 종료된 스레드는 호출스택이 모두 비워지면서
// 이 스레드가 사용하던 호출스택은 사라진다.
// main 메서드의 작업을 수행하는 것도 스레드이며, 이를 main스레드라고 한다.
// main메서드가 수행을 마쳤다하더라도 다른 스레드가 아직 작업을 마치지 않은 상태라면 프로그램은 종료되지 않는다.
class C_threadEx_exception extends Thread {
    @Override
    public void run() {
        System.out.println("ex run~~~~");
        throwException();
    }

    private void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

public class C_thread_2 {

    public static void exam1() {
        C_threadEx_exception t = new C_threadEx_exception();
        t.start(); // 스레드가 생성됨
    }

    public static void exam2() {
        C_threadEx_exception t = new C_threadEx_exception();
        t.run(); // 스레드가 생성되지 않음
    }

    public static void main(String[] args) {
        exam1();
        System.out.println("main~~~~");
    }
}

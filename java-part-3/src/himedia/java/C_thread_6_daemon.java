package himedia.java;

// * 데몬 스레드
// 데몬 스레드는 다른 일반 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드이다.
// 일반 스레드가 모두 종료되면 데몬 스레드는 강제적으로 자동 종료되는데,
// 그 이유는 데몬 스레드는 일반 스레드의 보조 역할을 수행하므로
// 일반 스레드가 모두 종료되고 나면 데몬 스레드의 존재의 의미가 없기 때문이다.
// 데몬 스레드의 예로는 가비지 컬렉터, 워드프로세서의 자동저장, 화면자동 갱신 등이 있다.

public class C_thread_6_daemon implements Runnable {

    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new C_thread_6_daemon());
        thread.setDaemon(true);
        thread.start();

        for ( int i = 1; i <= 10; ++i ) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
            if (i == 5) autoSave = true;
        }

        System.out.println("프로그램을 종료합니다.");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3*1000);
                if (autoSave) {
                    autoSave();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void autoSave() {
        System.out.println("작업 파일이 자동 저장되었습니다.");
    }

}

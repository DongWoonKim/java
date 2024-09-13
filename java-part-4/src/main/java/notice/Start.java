package notice;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Start {
    public static void main(String[] args) {
        setCharacter();
        Notice notice = new NoticeImpl();

        while (true) {
            int choice = notice.printMenu();
            switch (choice) {
                case 1:
                    notice.signIn();
                    break;
                case 2:
                    notice.signUp();
                    break;
                case 3:
                    notice.getList();
                    break;
                case 4:
                    notice.newNotice();
                    break;
                case 5:
                    notice.updateNotice();
                    break;
                case 6:
                    notice.deleteNotice();
                    break;
                case 7:
                    notice.signOut();
                    break;
                case 8:
                    notice.leave();
                    break;
                case 9:
                    System.out.println("다음에 또 만나요!");
                    return;
            }
        }

    }

    private static void setCharacter() {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

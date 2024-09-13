package notice;

import java.util.List;
import java.util.Scanner;

public class NoticeImpl implements Notice {

    private NoticeDAO noticeDAO;

    private boolean status;
    private String userId;
    private String name;

    public NoticeImpl() {
        noticeDAO = new NoticeDAO();
        this.status = false;
        this.name = null;
    }

    @Override
    public int printMenu() {
        System.out.println("=========================== [My Notice] ===========================");
        System.out.println(status ? name + "(" + userId + ") 님! 환영합니다." : "로그인 해주세요.");
        System.out.println("[1]로그인 [2]회원가입 [3]글목록보기 [4]글등록 [5]글수정 [6]글삭제");
        System.out.println("[7]로그아웃 [8]회원탈퇴 [9]프로그램종료");
        System.out.println("==================================================================");
        System.out.println("번호를 입력하세요.");

        return new Scanner(System.in).nextInt();
    }

    @Override
    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ID를 입력하세요.");
        String userId = scanner.nextLine();
        System.out.println("PW를 입력하세요.");
        String password = scanner.nextLine();
        System.out.println("사용자 이름을 입력하세요.");
        String name = scanner.nextLine();
        
        // ID중복체크
        if (noticeDAO.checkUserId(userId)) {
            System.out.println("이미 가입된 사용자입니다.");
            return;
        }
        
        // 회원가입
        if (noticeDAO.sigupExc(userId, password, name) ) {
            System.out.println("회원가입이 성공적으로 완료되었습니다.");
        }
    }

    @Override
    public void signIn() {
        System.out.println("[로그인]");
        Scanner scanner = new Scanner(System.in);
        System.out.println("ID를 입력하세요.");
        String userId = scanner.nextLine();
        System.out.println("비밀번호를 입력하세요.");
        String password = scanner.nextLine();

        SignInResponseDTO signInResponseDTO = noticeDAO.signInExc(userId, password);
        if (signInResponseDTO != null) {

            if (signInResponseDTO.isStatus()) {
                setUserInfo(
                        signInResponseDTO.isStatus(),
                        signInResponseDTO.getUserId(),
                        signInResponseDTO.getName()
                );
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }

        } else {
            System.out.println("존재하지 않습니다.");
        }

    }

    @Override
    public void newNotice() {

        if (!checkSignIn()) return;

        System.out.println("작성할 글을 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();

        if (noticeDAO.newNotice(userId, content)) {
            System.out.println("글이 등록 되었습니다.");
        } else {
            System.out.println("글이 정상적으로 등록되지 않았습니다.\n관리자한테 문의하세요.");
        }

    }

    @Override
    public void getList() {
        noticeDAO.getList()
                .forEach(System.out::println);
    }

    @Override
    public void updateNotice() {

        if (!checkSignIn()) return;

        List<String> list = noticeDAO.getListByUserId(userId);
        if ( list.size() == 0 ) {
            System.out.println("수정할 글이 존재하지 않습니다.");
            return;
        }

        list.forEach(System.out::println);
        System.out.println("[수정] 글 번호를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int contentId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("수정할 내용을 입력하세요.");
        String content = scanner.nextLine();

        boolean result = noticeDAO.updateNotice(contentId, content);
        if (result) {
            System.out.println("정상적으로 수정되었습니다.");
        } else {
            System.out.println("수정이 정상적으로 되지 않았습니다. 관리자한테 문의하세요.");
        }

    }

    @Override
    public void deleteNotice() {
        if (!checkSignIn()) return;

        List<String> list = noticeDAO.getListByUserId(userId);
        if ( list.size() == 0 ) {
            System.out.println("삭제할 글이 존재하지 않습니다.");
            return;
        }

        list.forEach(System.out::println);
        System.out.println("[삭제] 글 번호를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int contentId = scanner.nextInt();

        boolean result = noticeDAO.deleteNotice(contentId);
        if (result) {
            System.out.println("삭제가 완료되었습니다.");
        }
    }

    @Override
    public void signOut() {
        setUserInfo(false, null, null);
    }

    @Override
    public void leave() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("삭제할 ID를 입력하세요.");
        String userId = scanner.nextLine();

        if(!noticeDAO.checkUserId(userId)) {
            System.out.println("삭제할 회원이 없습니다.");
            return;
        }

        boolean result = noticeDAO.leaveExc(userId);
        if (result) {
            noticeDAO.deleteContentExc(userId);
            System.out.println("정상적으로 탈퇴 되었습니다.");
        }

    }

    private void setUserInfo(boolean status, String userId, String name) {
        this.status = status;
        this.userId = userId;
        this.name = name;
    }

    private boolean checkSignIn() {
        if (!status) {
            System.out.println("로그인을 먼저 해주세요.");
            return false;
        }
        return true;
    }
}

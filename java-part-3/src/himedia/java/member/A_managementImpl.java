package himedia.java.member;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static himedia.java.member.A_PricePlan.*;

/*
[멤버 관리 프로그램]
->Member.java(I)
->ManagementImpl.java // 필드 -> private
->Start.java

// 반드시 Collections중 하나를 적용할 것.
[1]Lite : 10명 [2]Basic : 20명 [3]Premium : 30명 [4]Freepass : 무제한

요금제 관리 -> enum

[1]회원추가 [2]회원조회(메일) [3]회원조회(이름)
[4]전체조회 [5]회원정보 수정 [6]회원삭제
[7]요금제 변경 [8]초기화 [9]프로그램 종료

// 10명... -> 꽉 차면 "요금제를 변경하시오."

 */

public class A_managementImpl implements A_member {

    private A_PricePlan pricePlan;
    private Map<String, String[]> memberMap;

    public A_managementImpl() {
        pricePlan = null;
        memberMap = new HashMap<>();
    }

    @Override
    public void printPricePlan() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[요금제를 선택하세요.]");
        System.out.println("[1]Lite : 10명 [2]Basic : 20명 [3]Premium : 30명 [4]무제한");
        int planNum = sc.nextInt();

        updatePricePlan(planNum);
    }

    @Override
    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[수행할 업무를 선택하세요 - 현재 회원수 " + memberMap.size() + " / " + (pricePlan.getCount() == -1 ? "무제한" : pricePlan.getCount()) + "]");
        System.out.println("[1]회원추가 [2]회원조회(메일) [3]회원조회(이름)");
        System.out.println("[4]전체조회 [5]회원정보 수정 [6]회원삭제");
        System.out.println("[7]요금제 변경 [8]초기화 [9]프로그램 종료");

        return sc.nextInt();
    }

    @Override
    public void addMember() {
        int currentMemberCnt = memberMap.size();
        int totalCnt = pricePlan.getCount();
        if ( totalCnt != -1 && currentMemberCnt >= totalCnt ) {
            System.out.println("회원이 꽉 찼습니다. 요금제를 변경해주세요.");
            return;
        }

        // 사용자로부터 이름, 이메일, 연락처
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하세요.");
        String name = sc.nextLine();
        System.out.println("이메일을 입력하세요.");
        String email = sc.nextLine();
        System.out.println("연락처를 입력하세요.");
        String phone = sc.nextLine();

        if ( checkEmail(email) ) {
            System.out.println("이미 존재하는 회원입니다.");
            return;
        }

        memberMap.put(email, new String[]{name, phone});
    }

    @Override
    public boolean checkEmail(String email) {
        return memberMap.containsKey(email);
    }

    @Override
    public void selectEmail() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[조회] 이메일을 입력하세요.");
        String email = sc.nextLine();

        if ( !checkEmail(email) ) {
            System.out.println("찾으시는 정보가 없습니다.");
            return;
        }

        String[] infos = memberMap.get(email);
        System.out.println("[이름] " + infos[0] + ", [이메일] " + email + ", [연락처] " + infos[1]);
    }

    @Override
    public void selectName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하시오.");
        String name = sc.nextLine();

        boolean flag = false;

        for( String key : memberMap.keySet() ) {
            String[] infos = memberMap.get(key);
            if ( name.equals(infos[0]) ) {
                System.out.println("[이름] " + infos[0] + ", [이메일] " + key + ", [연락처] " + infos[1]);
                flag = true;
            }
        }

        if(!flag) {
            System.out.println("찾으시는 정보가 없습니다.");
        }
    }

    @Override
    public void selectAll() {
        for( String key : memberMap.keySet() ) {
            String[] infos = memberMap.get(key);
            System.out.println("[이름] " + infos[0] + ", [이메일] " + key + ", [연락처] " + infos[1]);
        }
    }

    @Override
    public void updateMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[수정] 이메일을 입력하세요.");
        String email = sc.nextLine();

        if ( !checkEmail(email) ) {
            System.out.println("찾으시는 회원이 없습니다");
            return;
        }

        // 해당 행의 속한 회원 정보를 갱신
        System.out.println("변경할 이름을 입력하세요.");
        String newName = sc.nextLine();
        System.out.println("변경할 이메일을 입력하세요.");
        String newEmail = sc.nextLine();
        System.out.println("변경할 연락처를 입력하세요.");
        String newPhone = sc.nextLine();

        memberMap.remove(email);
        memberMap.put(newEmail, new String[]{newName, newPhone});

        System.out.println("수정이 완료되었습니다.");
    }

    @Override
    public void deleteMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[삭제] 이메일을 입력하세요.");
        String email = sc.nextLine();

        if ( !checkEmail(email) ) {
            System.out.println("찾으시는 회원이 없습니다");
            return;
        }

        memberMap.remove(email);
    }

    @Override
    public void updatePricePlan(int planNum) {
        A_PricePlan type = null;
        switch (planNum) {
            case 1:
                type = LITE;
                break;
            case 2:
                type = BASIC;
                break;
            case 3:
                type = PREMIUM;
                break;
            case 4:
                type = FREE;
                break;
        }

        if (
                type != null
                && type != FREE
                && memberMap.size() >= type.getCount()
        ) {
            if ( pricePlan == type ) {
                System.out.println("현재 요금제와 동일한 요금제를 택할 수 없습니다.");
            } else {
                System.out.println("현재 인원보다 더 적은 요금제를 택할 수 없습니다.");
            }
            return;
        }

        pricePlan = type;
    }

    @Override
    public void initMember() {
        memberMap.clear();
    }

}

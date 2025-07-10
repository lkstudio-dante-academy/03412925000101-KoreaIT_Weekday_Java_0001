package Training.Training_15;

/*
 * Java 연습 문제 15
 * - 하노이 탑 시뮬레이션 제작하기
 * - 원반 개수를 입력 받아 해당 개수의 원반을 목적지로 이동 시킨다
 *
 * Ex)
 * 원반 개수 입력 : 3
 * 1 번 원반 : A -> C 로 이동
 * 2 번 원반 : A -> B 로 이동
 * 1 번 원반 : C -> B 로 이동
 * 3 번 원반 : A -> C 로 이동
 * 1 번 원반 : B -> A 로 이동
 * 2 번 원반 : B -> C 로 이동
 * 1 번 원반 : A -> C 로 이동
 */

import java.util.Scanner;

/**
 * Training 15
 */
public class CT01Training_15 {
    /** 초기화 */
    public static void start(String[] args) {
        Scanner oScanner = new Scanner(System.in);

        System.out.print("원반 개수 입력 : ");
        int nNum = oScanner.nextInt();

        printResult_HanoiTower(nNum, "A", "C", "B");
    }

    /** 하노이 탑 결과를 출력한다 */
    private static void printResult_HanoiTower(int a_nNum, String a_oFrom, String a_oTo, String a_oBuffer) {
        // 결과 출력이 불가능 할 경우
        if(a_nNum <= 0) {
            return;
        }

        printResult_HanoiTower(a_nNum - 1, a_oFrom, a_oBuffer, a_oTo);
        System.out.printf("%d 원반 : %s -> %s 로 이동\n", a_nNum, a_oFrom, a_oTo);

        printResult_HanoiTower(a_nNum - 1, a_oBuffer, a_oTo, a_oFrom);
    }
}

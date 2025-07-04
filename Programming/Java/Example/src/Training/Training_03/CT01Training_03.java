package Training.Training_03;

/*
 * Java 연습 문제 3
 * - 구구단 출력하기
 * - 사용자로부터 2 ~ 9 사이의 수를 입력 받아 해당 수에 해당하는 구구단 출력하기
 * - 단, 범위를 벗어나는 수를 입력 할 경우 잘못된 입력이라는 메세지 출력하기
 *
 * Ex)
 * 정수 2 개 입력 (2 ~ 9) : 4 1
 * 2 ~ 9 사이의 수를 입력해주세요.
 *
 * 정수 2 개 입력 (2 ~ 9) : 4 2
 * =====> 2 단 <=====
 * 2 * 1 = 2
 * 2 * 2 = 4
 * 2 * 3 = 6
 * ...이하 생략
 *
 * 3 * 1 = 3
 * 3 * 2 = 6
 * 3 * 3 = 9
 * ...이하 생략
 *
 * 4 * 1 = 4
 * 4 * 2 = 8
 * 4 * 3 = 12
 * ...이하 생략
 */

import java.util.Scanner;

/**
 * Training 3
 */
public class CT01Training_03 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		System.out.print("정수 2 개 입력 (2 ~ 9) : ");
		
		int nValA = oScanner.nextInt();
		int nValB = oScanner.nextInt();
		
		boolean bIsValidA = nValA >= 2 && nValA <= 9;
		boolean bIsValidB = nValB >= 2 && nValB <= 9;
		
		// 범위를 벗어났을 경우
		if(!bIsValidA || !bIsValidB) {
			System.out.println("2 ~ 9 사이의 수를 입력해주세요.");
			return;
		}
		
		// 보정이 필요 할 경우
		if(nValA > nValB) {
			int nTemp = nValA;
			nValA = nValB;
			nValB = nTemp;
		}
		
		for(int i = nValA; i <= nValB; ++i) {
			System.out.printf("=====> %d 단 <=====\n", i);
			
			for(int j = 1; j < 10; ++j) {
				System.out.printf("%d * %d = %d\n", i, j, i * j);
			}
			
			System.out.println();
		}
	}
}

package Training.Training_05;

/*
 * Java 연습 문제 5
 * - 합계 및 평균 출력하기
 * - 사용자로부터 정수를 입력 받는다
 * - 입력 받은 정수가 0 보다 클 경우 값을 누적 후 다시 정수를 입력 받는다
 * - 입력 받은 정수가 0 이하 일 경우 입력을 종료하고 합계와 평균을 출력한다
 *
 * Ex)
 * 1 번째 정수 입력 : 1
 * 2 번째 정수 입력 : 3
 * 3 번째 정수 입력 : 5
 * 4 번째 정수 입력 : 0
 *
 * 합계 : 14
 * 평균 : 3.0
 */

import java.util.Scanner;

/**
 * Training 5
 */
public class CT01Training_05 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		
		int nVal_Sum = 0;
		int nNumValues = 0;
		
		while(true) {
			System.out.printf("%d 번째 정수 입력 : ", nNumValues + 1);
			int nVal = oScanner.nextInt();
			
			// 입력 종료 일 경우
			if(nVal <= 0) {
				break;
			}
			
			nVal_Sum += nVal;
			nNumValues += 1;
		}
		
		System.out.printf("합계 : %d\n", nVal_Sum);
		System.out.printf("평균 : %f\n", nVal_Sum / (float)nNumValues);
	}
}

package Practice.Practice_01;

/*
 * Java 과제 1
 * - 숫자 야구 게임 제작하기
 * - 1 ~ 9 사이의 수 중 중복되지 않는 4 개의 수를 추출한다
 * - 사용자로부터 4 개의 수를 입력 받아 입력 받은 수가 정답에 있는지 검사한다
 * - 입력 받은 수가 정답에 존재하고 위치가 동일 할 경우 스트라이크
 * - 입력 받은 수가 정답에 존재하지만 위치가 다를 경우 볼
 * - 4 스트라이크가 되면 게임을 종료한다
 *
 * Ex)
 * 정답 : 1 8 5 2
 *
 * 정수 (4 개) 입력 : 1 5 8 2
 * 결과 : 2 Strike, 2 Ball
 *
 * 정수 (4 개) 입력 : 1 8 5 2
 * 결과 : 4 Strike, 0 Ball
 *
 * 프로그램을 종료합니다.
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Practice 1
 */
public class CP01Practice_01 {
	/** 초기화 */
	public static void start(String[] args) {
		int[] oAnswer = new int[4];
		setupAnswer(oAnswer);
		
		System.out.print("정답 : ");
		printValues(oAnswer);
		
		Scanner oScanner = new Scanner(System.in);
		System.out.println();
		
		while(true) {
			System.out.print("정수 (4 개) 입력 : ");
			String[] oTokens = oScanner.nextLine().split(" ");
			
			int nCount_Strike = 0;
			int nCount_Ball = 0;
			
			for(int i = 0; i < oTokens.length; ++i) {
				int j = 0;
				int nVal = Integer.parseInt(oTokens[i]);
				
				for(j = 0; j < oAnswer.length; ++j) {
					// 숫자가 존재 할 경우
					if(nVal == oAnswer[j]) {
						break;
					}
				}
				
				// 숫자가 없을 경우
				if(j >= oAnswer.length) {
					continue;
				}
				
				nCount_Strike += (i == j) ? 1 : 0;
				nCount_Ball += (i != j) ? 1 : 0;
			}
			
			System.out.printf("결과 : %d Strike, %d Ball\n\n",
					nCount_Strike, nCount_Ball);
			
			// 모든 숫자를 맞췄을 경우
			if(nCount_Strike >= oAnswer.length) {
				break;
			}
		}
		
		System.out.println("프로그램을 종료합니다.");
	}
	
	/** 정답을 설정한다 */
	private static void setupAnswer(int[] a_oAnswer) {
		Random oRandom = new Random();
		int nNumValues = 0;
		
		while(nNumValues < a_oAnswer.length) {
			int i = 0;
			int nVal = oRandom.nextInt(1, 10);
			
			for(i = 0; i < nNumValues; ++i) {
				// 숫자가 존재 할 경우
				if(a_oAnswer[i] == nVal) {
					break;
				}
			}
			
			// 숫자가 중복 될 경우
			if(i < nNumValues) {
				continue;
			}
			
			a_oAnswer[nNumValues++] = nVal;
		}
	}
	
	/** 값을 출력한다 */
	private static void printValues(int[] a_oValues) {
		for(int i = 0; i < a_oValues.length; ++i) {
			System.out.printf("%d, ", a_oValues[i]);
		}
		
		System.out.println();
	}
}

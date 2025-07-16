package Training.Training_14;

/*
 * Java 연습 문제 12
 * - 배열 치환하기
 * - 길이 10 배열을 생성 후 1 ~ 15 사이의 수로 랜덤하게 초기화한다
 * - 사용자로부터 위치를 입력 받아 해당 위치를 포함한 주변의 1 자리수를 모두 -1 로 치환한다
 *
 * Ex)
 * =====> 배열 - 치환 전 <=====
 * 1, 10, 5, 4, 8, 15, 7, 2, 9, 1
 *
 * 위치 입력 : 3
 *
 * =====> 배열 - 치환 후 <=====
 * 1, 10, -1, -1, -1, 15, 7, 2, 9, 1
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Training 12
 */
public class CT01Training_14 {
	/** 초기화 */
	public static void start(String[] args) {
		Random oRandom = new Random();
		Scanner oScanner = new Scanner(System.in);
		
		int[] oValues = new int[10];
		
		for(int i = 0; i < oValues.length; ++i) {
			oValues[i] = oRandom.nextInt(1, 15);
		}
		
		System.out.println("=====> 배열 - 치환 전 <=====");
		printValues(oValues);
		
		System.out.print("\n위치 입력 : ");
		int nIdx = oScanner.nextInt();
		
		replaceValues(oValues, nIdx);
		
		System.out.println("\n=====> 배열 - 치환 후 <=====");
		printValues(oValues);
	}
	
	/** 값을 변경한다 */
	private static void replaceValues(int[] a_oValues, int a_nIdx) {
		// 값 변경이 불가능 할 경우
		if(a_nIdx < 0 || a_nIdx >= a_oValues.length) {
			return;
		}
		
		String oStr_Val = Integer.toString(a_oValues[a_nIdx]);
		
		// 값 변경이 불가능 할 경우
		if(oStr_Val.length() != 1) {
			return;
		}
		
		a_oValues[a_nIdx] = -1;
		
		replaceValues(a_oValues, a_nIdx - 1);
		replaceValues(a_oValues, a_nIdx + 1);
	}
	
	/** 값을 출력한다 */
	private static void printValues(int[] a_oValues) {
		for(int i = 0; i < a_oValues.length; ++i) {
			System.out.printf("%d, ", a_oValues[i]);
		}
		
		System.out.println();
	}
}

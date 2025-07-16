package Training.Training_13;

/*
 * Java 연습 문제 10
 * - 달팽이 형태로 배열 초기화하기
 * - 배열 크기를 입력 받아 해당 크기 만큼 삼각형 형태로 배열 초기화하기
 *
 * Ex)
 * 크기 입력 : 5
 *  1  2  3  4  5
 * 16 17 18 19  6
 * 15 24 25 20  7
 * 14 23 22 21  8
 * 13 12 11 10  9
 */

import java.util.Scanner;

/**
 * Training 10
 */
public class CT01Training_13 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("크기 입력 : ");
		int nSize = oScanner.nextInt();
		
		int[][] oMatrix = new int[nSize][nSize];
		setupValues(oMatrix);
		
		for(int i = 0; i < oMatrix.length; ++i) {
			for(int j = 0; j < oMatrix[i].length; ++j) {
				System.out.printf("%4d", oMatrix[i][j]);
			}
			
			System.out.println();
		}
	}
	
	/** 값을 설정한다 */
	private static void setupValues(int[][] a_oMatrix) {
		int i = 0;
		int j = -1;
		
		int nTimes = a_oMatrix.length;
		int nDirection = 1;
		
		int nVal = 0;
		int nVal_Max = a_oMatrix.length * a_oMatrix[0].length;
		
		while(nVal < nVal_Max) {
			for(int k = 0; k < nTimes; ++k) {
				j += nDirection;
				a_oMatrix[i][j] = ++nVal;
			}
			
			nTimes -= 1;
			
			for(int k = 0; k < nTimes; ++k) {
				i += nDirection;
				a_oMatrix[i][j] = ++nVal;
			}
			
			nDirection = -nDirection;
		}
	}
}

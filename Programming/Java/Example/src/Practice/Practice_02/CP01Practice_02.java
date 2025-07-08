package Practice.Practice_02;

/*
 * Java 과제 2
 * - 삼각형 형태로 배열 초기화하기
 * - 배열 크기를 입력 받아 해당 크기 만큼 삼각형 형태로 배열 초기화하기
 *
 * Ex)
 * 크기 입력 : 5
 *  1  0  0  0  0
 * 12  2  0  0  0
 * 11 13  3  0  0
 * 10 15 14  4  0
 *  9  8  7  6  5
 */

import java.util.Scanner;

/**
 * Practice 2
 */
public class CP01Practice_02 {
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
		int nVal = 0;
		int nVal_Max = (a_oMatrix.length * (a_oMatrix.length + 1)) / 2;
		
		int i = -1;
		int j = -1;
		
		int nTimes = a_oMatrix.length;
		
		while(nVal < nVal_Max) {
			for(int k = 0; k < nTimes; ++k) {
				a_oMatrix[++i][++j] = ++nVal;
			}
			
			nTimes -= 1;
			
			for(int k = 0; k < nTimes; ++k) {
				a_oMatrix[i][--j] = ++nVal;
			}
			
			nTimes -= 1;
			
			for(int k = 0; k < nTimes; ++k) {
				a_oMatrix[--i][j] = ++nVal;
			}
			
			nTimes -= 1;
		}
	}
}

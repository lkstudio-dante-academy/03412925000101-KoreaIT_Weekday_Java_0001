package Training.Training_06;

/*
 * Java 연습 문제 6
 * - 다양한 형태 출력하기
 * - 라인 수를 입력 받아 해당 라인 수 만큼 여러 형태를 출력하기
 *
 * Ex)
 * 라인 수 입력 : 5
 * *   *
 *  * *
 *   *
 *  * *
 * *   *
 *
 * *****
 *    *
 *   *
 *  *
 * *****
 *
 * *   *
 * **  *
 * * * *
 * *  **
 * *   *
 *
 * *
 * **
 * ***
 * ****
 * *****
 *
 * *****
 * ****
 * ***
 * **
 * *
 *
 *     *
 *    **
 *   ***
 *  ****
 * *****
 *
 * *****
 *  ****
 *   ***
 *    **
 *     *
 *
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 *
 * *********
 *  *******
 *   *****
 *    ***
 *     *
 */

import java.util.Scanner;

/**
 * Training 6
 */
public class CT01Training_06 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("라인 수 입력 : ");
		int nNumLines = oScanner.nextInt();
		
		for(int i = 0; i < nNumLines; ++i) {
			for(int j = 0; j < nNumLines; ++j) {
				boolean bIsStarA = i == j;
				boolean bIsStarB = (nNumLines - 1) - i == j;
				
				char chLetter = (bIsStarA || bIsStarB) ? '*' : ' ';
				System.out.printf("%c", chLetter);
			}
			
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = 0; i < nNumLines; ++i) {
			for(int j = 0; j < nNumLines; ++j) {
				boolean bIsStarA = i == 0;
				boolean bIsStarB = i == nNumLines - 1;
				boolean bIsStarC = (nNumLines - 1) - i == j;
				
				char chLetter = (bIsStarA || bIsStarB || bIsStarC) ? '*' : ' ';
				System.out.printf("%c", chLetter);
			}
			
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = 0; i < nNumLines; ++i) {
			for(int j = 0; j < nNumLines; ++j) {
				boolean bIsStarA = j == 0;
				boolean bIsStarB = j == nNumLines - 1;
				boolean bIsStarC = i == j;
				
				char chLetter = (bIsStarA || bIsStarB || bIsStarC) ? '*' : ' ';
				System.out.printf("%c", chLetter);
			}
			
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = 0; i < nNumLines; ++i) {
			for(int j = 0; j < nNumLines; ++j) {
				boolean bIsStarA = j <= i;
				char chLetter = bIsStarA ? '*' : ' ';
				
				System.out.printf("%c", chLetter);
			}
			
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = nNumLines - 1; i >= 0; --i) {
			for(int j = 0; j < nNumLines; ++j) {
				boolean bIsStarA = j <= i;
				char chLetter = bIsStarA ? '*' : ' ';
				
				System.out.printf("%c", chLetter);
			}
			
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = 0; i < nNumLines; ++i) {
			for(int j = nNumLines - 1; j >= 0; --j) {
				boolean bIsStarA = j <= i;
				char chLetter = bIsStarA ? '*' : ' ';
				
				System.out.printf("%c", chLetter);
			}
			
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = nNumLines - 1; i >= 0; --i) {
			for(int j = nNumLines - 1; j >= 0; --j) {
				boolean bIsStarA = j <= i;
				char chLetter = bIsStarA ? '*' : ' ';
				
				System.out.printf("%c", chLetter);
			}
			
			System.out.println();
		}
		
		System.out.println();
		int nWidth_Max = (nNumLines * 2) - 1;
		
		for(int i = 0; i < nNumLines; ++i) {
			int nCenter = nWidth_Max / 2;
			
			for(int j = 0; j < nWidth_Max; ++j) {
				boolean bIsStarA = j >= nCenter - i;
				boolean bIsStarB = j <= nCenter + i;
				
				char chLetter = (bIsStarA && bIsStarB) ? '*' : ' ';
				System.out.printf("%c", chLetter);
			}
			
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = nNumLines - 1; i >= 0; --i) {
			int nCenter = nWidth_Max / 2;
			
			for(int j = 0; j < nWidth_Max; ++j) {
				boolean bIsStarA = j >= nCenter - i;
				boolean bIsStarB = j <= nCenter + i;
				
				char chLetter = (bIsStarA && bIsStarB) ? '*' : ' ';
				System.out.printf("%c", chLetter);
			}
			
			System.out.println();
		}
	}
}

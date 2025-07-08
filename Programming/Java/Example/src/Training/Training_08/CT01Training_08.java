package Training.Training_08;

/*
 * Java 연습 문제 8
 * - 행맨 게임 제작하기
 * - 정해진 단어 중 랜덤하게 정답에 해당하는 단어를 추출한다
 * - 정답에 해당하는 단어를 이루고 있는 문자 중 일부를 공개한다
 * - 사용자로부터 문자를 입력 받아 해당 문자가 정답 단어 존재 할 경우
 * 문자를 공개한다 (+ 단, 대/소문자 구분 X)
 *
 * Ex)
 * 정답 : Google
 *
 * _ _ _ g _ e
 * 문자 입력 : g
 *
 * G _ _ g _ e
 * 문자 입력 : L
 *
 * G _ _ g l e
 * 문자 입력 : o
 *
 * G o o g l e
 * 프로그램을 종료합니다.
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Training 8
 */
public class CT01Training_08 {
	/** 초기화 */
	public static void start(String[] args) {
		Random oRandom = new Random();
		
		String[] oWords = {
				"Apple",
				"Google",
				"Samsung",
				"Microsoft"
		};
		
		String oAnswer = oWords[oRandom.nextInt(0, oWords.length)];
		System.out.printf("정답 : %s\n\n", oAnswer);
		
		char[] oWord = new char[oAnswer.length()];
		
		for(int i = 0; i < oWord.length; ++i) {
			oWord[i] = '_';
		}
		
		for(int i = 0; i < (int)(oWord.length * 0.3f); ++i) {
			int nIdx = oRandom.nextInt(0, oWord.length);
			oWord[nIdx] = oAnswer.charAt(nIdx);
		}
		
		boolean bIsContinue = true;
		Scanner oScanner = new Scanner(System.in);
		
		while(bIsContinue) {
			for(char chLetter : oWord) {
				System.out.printf("%c ", chLetter);
			}
			
			System.out.print("\n문자 입력 : ");
			char chLetter = oScanner.nextLine().charAt(0);
			
			for(int i = 0; i < oWord.length; ++i) {
				// 정답에 문자가 존재 할 경우
				if(Character.toUpperCase(chLetter) ==
						Character.toUpperCase(oAnswer.charAt(i))) {
					oWord[i] = oAnswer.charAt(i);
				}
			}
			
			bIsContinue = false;
			
			for(char chLetter_Compare : oWord) {
				// _ 일 경우
				if(chLetter_Compare == '_') {
					bIsContinue = true;
					break;
				}
			}
			
			System.out.println();
		}
		
		for(char chLetter : oWord) {
			System.out.printf("%c ", chLetter);
		}
		
		System.out.println("\n프로그램을 종료합니다.");
	}
}

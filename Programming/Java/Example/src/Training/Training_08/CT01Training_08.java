package Training.Training_08;

/*
 * Java 연습 문제 8
 * - 행맨 게임 제작하기
 * - 정해진 단어 중 하나를 정답으로 추출한다
 * - 단어를 이루고 있는 문자 중 일부만 공개한다
 * - 사용자로부터 문자를 입력 받아 문자가 단어에 존재 할 경우 해당 문자를 활성화한다. (+ 단, 대/소문자 구분 X)
 * - 모든 문자가 활성화되면 게임을 종료한다
 *
 * Ex)
 * 정답 : Microsoft
 *
 * _ i _ _ _ s _ _ _
 * 문자 입력 : m
 *
 * M i _ _ _ s _ _ _
 * 문자 입력 : o
 *
 * M i _ _ o s o _ _
 * 문자 입력 : c
 *
 * ...이하 생략
 *
 * M i c r o s o f _
 * 문자 입력 : t
 *
 * M i c r o s o f t
 * 프로그램을 종료합니다.
 */

import java.util.Arrays;
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
		
		char[] oWord = oAnswer.toCharArray();
		Arrays.fill(oWord, '_');
		
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
			
			for(char chLetter_Word : oWord) {
				// _ 문자 일 경우
				if(chLetter_Word == '_') {
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

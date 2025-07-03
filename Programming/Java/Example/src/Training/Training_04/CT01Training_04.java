package Training.Training_04;

/*
 * Java 연습 문제 4
 * - 업/다운 게임 제작하기
 * - 1 ~ 99 사이의 수 중 하나를 랜덤하게 추출한다
 * - 사용자로부터 숫자를 입력 받아 정답 여부를 검사한다
 * - 입력 받은 수가 정답 일 경우 게임을 종료한다
 * - 입력 받은 수가 정답이 아닐 경우 가이드 메세지를 출력하고 다시 수를 입력 받는다
 *
 * Ex)
 * 정답 : 85
 *
 * 정수 입력 : 80
 * 정답은 80 보다 큽니다.
 *
 * 정수 입력 : 90
 * 정답은 90 보다 작습니다.
 *
 * 정수 입력 : 85
 * 프로그램을 종료합니다.
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Training 4
 */
public class CT01Training_04 {
	/** 초기화 */
	public static void start(String[] args) {
		/*
		 * Random 클래스란?
		 * - 난수를 생성하기 위한 다양한 기능을 제공하는 클래스를 의미한다. (+ 즉, Random 클래스를 활용하면
		 * 프로그램이 실행 될 때마다 다른 결과를 출력하도록 명령문을 작성하는 것이 가능하다.)
		 */
		Random oRandom = new Random();
		Scanner oScanner = new Scanner(System.in);
		
		int nAnswer = oRandom.nextInt(1, 100);
		System.out.printf("정답 : %d\n\n", nAnswer);
		
		boolean bIsContinue = true;
		
		do {
			System.out.print("정수 입력 : ");
			int nVal = oScanner.nextInt();
			
			// 정답 일 경우
			if(nVal == nAnswer) {
				bIsContinue = false;
			} else {
				String oMsg = (nVal < nAnswer) ? "큽니다." : "작습니다.";
				System.out.printf("정답은 %d 보다 %s\n\n", nVal, oMsg);
			}
		} while(bIsContinue);
		
		System.out.println("프로그램을 종료합니다.");
	}
}

package Practice.Practice_01;

/*
 * Java 연습 문제 1
 * - 야구 게임 제작하기
 * - 1 ~ 9 사이의 수 중 중복 되지 않은 4 개의 수를 정답으로 추출한다
 * - 사용자로부터 4 개의 수를 입력 받아 스트라이크 or 볼 여부를 검사한다
 * - 입력 받은 수가 정답에 존재하고 위치가 동일 할 경우 스트라이크
 * - 입력 받은 수가 정답에 존재하지만 위치가 다를 경우 볼
 * - 4 스트라이크가 되면 게임을 종료한다
 *
 * Ex)
 * 정답 : 1 5 2 8
 *
 * 정수 (4 개) 입력 : 1 2 5 8
 * 결과 : 2 Strike, 2 Ball
 *
 * 정수 (4 개) 입력 : 1 5 2 8
 * 결과 : 4 Strike, 2 Ball
 *
 * 프로그램을 종료합니다.
 */

import java.util.Random;

/**
 * Practice 1
 */
public class CP01Practice_01 {
	/** 초기화 */
	public static void start(String[] args) {
		Random oRandom = new Random();
		
		int[] oAnswer = new int[4];
		int nNumValues = 0;
		
		while(nNumValues < oAnswer.length) {
			int i = 0;
			int nVal = oRandom.nextInt(1, 10);
			
			for(i = 0; i < nNumValues; ++i) {
				// 값이 존재 할 경우
				if(nVal == oAnswer[i]) {
					break;
				}
			}
			
			// 값 추가가 불가능 할 경우
			if(i < nNumValues) {
				continue;
			}
			
			oAnswer[nNumValues++] = nVal;
		}
	}
}

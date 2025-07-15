package Training.Training_19;

/*
 * Java 연습 문제 19
 * - 디지털 숫자 출력하기
 * - 사용자로부터 정수를 입력 받아 해당 정수를 디지털 숫자로 출력한다
 *
 * Ex)
 * 정수 입력 : 123
 *     * ***** *****
 *     *     *     *
 *     * ***** *****
 *     * *         *
 *     * ***** *****
 */

import java.util.Scanner;

/**
 * Training 19
 */
public class CT01Training_19 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);

		String[] oStrings = {
				"*****     * ***** ***** *   * ***** ***** ***** ***** ***** ",
				"*   *     *     *     * *   * *     *         * *   * *   * ",
				"*   *     * ***** ***** ***** ***** *****     * ***** ***** ",
				"*   *     * *         *     *     * *   *     * *   *     * ",
				"*****     * ***** *****     * ***** *****     * ***** ***** "
		};

		System.out.print("정수 입력 : ");
		String oStr_Digit = oScanner.nextLine();

		for(int i = 0; i < oStrings.length; ++i) {
			for(int j = 0; j < oStr_Digit.length(); ++j) {
				int nVal = oStr_Digit.charAt(j) - '0';
				int nIdx_Start = (nVal * 5) + nVal;

				for(int k = 0; k < 6; ++k) {
					System.out.printf("%c", oStrings[i].charAt(nIdx_Start + k));
				}
			}

			System.out.println();
		}
	}
}

package Training.Training_21;

import java.util.Random;
import java.util.Scanner;

/**
 * Training 21
 */
public class CT01Training_21 {
	/** 초기화 */
	public static void start(String[] args) {
		Random oRandom = new Random();
		Scanner oScanner = new Scanner(System.in);

		CList_Linked oListValues = new CList_Linked();

		for(int i = 0; i < 10; ++i) {
			int nVal = oRandom.nextInt(1, 100);
			oListValues.addVal(nVal);
		}

		System.out.println("=====> 리스트 <=====");
		printValues(oListValues);

		System.out.print("\n정수 입력 (제거) : ");
		int nVal_Remove = oScanner.nextInt();

		oListValues.removeVal(nVal_Remove);

		System.out.println("\n=====> 리스트 - 제거 후 <=====");
		printValues(oListValues);
	}

	/** 값을 출력한다 */
	private static void printValues(CList_Linked a_oListValues) {
		for(int i = 0; i < a_oListValues.getNumValues(); ++i) {
			int nVal = a_oListValues.getVal(i);
			System.out.printf("%d, ", nVal);
		}

		System.out.println();
	}
}

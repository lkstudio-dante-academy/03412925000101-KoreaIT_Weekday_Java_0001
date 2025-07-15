package Training.Training_18;

/*
 * Java 연습 문제 18
 * - 상점 시뮬레이션 구현하기
 * - 상점에는 서로 다른 가격의 물건들이 존재한다
 * - 프로그램 시작 시 사용자로부터 금액을 입력 받는다
 * - 입력 받은 금액에서 물건을 구입 할 수 있다
 * - 상점의 각 물건은 재고가 존재하며 재고가 소진 된 물건은 더이상 구입 불가
 *
 * Ex)
 * 소지 금액 입력 : 1000
 *
 * =====> 메뉴 <=====
 * 1. 물건 A 구입 (가격 : 50, 재고 : 2)
 * 2. 물건 B 구입 (가격 : 250, 재고 : 1)
 * 3. 물건 C 구입 (가격 : 500, 재고 : 3)
 * 4. 종료
 *
 * 선택 (소지 금액 : 1000) : 1
 *
 * Case 1. 물건 구입이 가능 할 경우
 * 물건 A 을(를) 구입했습니다.
 *
 * Case 2. 금액 부족 or 재고 소진 일 경우
 * 물건 A 은(는) 구입이 불가능합니다.
 */

import java.util.Scanner;

/**
 * Training 18
 */
public class CT01Training_18 {
    /** 초기화 */
    public static void start(String[] args) {
        Scanner oScanner = new Scanner(System.in);
        CStore oStore = new CStore();

        setupStore(oStore);

        System.out.print("소지 금액 입력 : ");
        int nAmount = oScanner.nextInt();

        System.out.println();
        final int MENU_EXIT = oStore.getNumStuffs() + 1;

        do {
            printMenu(oStore, nAmount);
            int nMenu = oScanner.nextInt();

            // 종료 일 경우
            if(nMenu == MENU_EXIT) {
                break;
            }

            CStuff oStuff = oStore.getStuff(nMenu - 1);

            // 물건 구입이 불가능 할 경우
            if(oStuff == null) {
                continue;
            }

            boolean bIsValidA = nAmount >= oStuff.m_nPrice;
            boolean bIsValidB = oStuff.m_nNumStuffs >= 1;

            // 물건 구입이 가능 할 경우
            if(bIsValidA && bIsValidB) {
                nAmount -= oStuff.m_nPrice;
                oStore.buyStuff(nMenu - 1);

                System.out.printf("물건 %c 을(를) 구입했습니다.\n", 'A' + nMenu - 1);
            } else {
                System.out.printf("물건 %c 은(는) 구입이 불가능합니다.\n", 'A' + nMenu - 1);
            }

            System.out.println();
        } while(true);

        System.out.println("프로그램을 종료합니다.");
    }

    /** 상점을 설정한다 */
    private static void setupStore(CStore a_oStore) {
        CStuff oStuffA = new CStuff(50, 10);
        CStuff oStuffB = new CStuff(250, 5);
        CStuff oStuffC = new CStuff(500, 3);
        CStuff oStuffD = new CStuff(750, 2);
        CStuff oStuffE = new CStuff(1000, 1);

        a_oStore.addStuff(oStuffA);
        a_oStore.addStuff(oStuffB);
        a_oStore.addStuff(oStuffC);
        a_oStore.addStuff(oStuffD);
        a_oStore.addStuff(oStuffE);
    }

    /** 메뉴를 출력한다 */
    private static void printMenu(CStore a_oStore, int a_nAmount) {
        System.out.println("=====> 메뉴 <=====");

        for(int i = 0; i < a_oStore.getNumStuffs(); ++i) {
            CStuff oStuff = a_oStore.getStuff(i);

            System.out.printf("%d. 물건 %c (가격 : %d, 재고 : %d)\n",
                    i + 1, 'A' + i, oStuff.m_nPrice, oStuff.m_nNumStuffs);
        }

        System.out.printf("%d. 종료\n", a_oStore.getNumStuffs() + 1);
        System.out.printf("\n선택 (소지 금액 : %d) : ", a_nAmount);
    }
}

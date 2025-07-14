package Training.Training_17;

/*
 * Java 연습 문제 17
 * - 콘솔 그림판 제작하기
 * - 도형은 선, 삼각형, 사각형이 존재한다
 * - 각 도형은 색상 정보를 지니고 있으며 색상은 도형을
 * 생성 할 때 랜덤하게 부여된다
 * - 사용자로부터 메뉴를 입력받아 도형을 추가 후 그리는 프로그램 제작하기
 *
 * Ex)
 * =====> 메뉴 <=====
 * 1. 선 추가
 * 2. 삼각형 추가
 * 3. 사각형 추가
 * 4. 모든 도형 그리기
 * 5. 종료
 *
 * 선택 : 1
 * 빨간색 선을 추가했습니다.
 *
 * 선택 : 2
 * 파란색 삼각형을 추가했습니다.
 *
 * 선택 : 4
 * 빨간색 선을 그렸습니다.
 * 파란색 선을 그렸습니다.
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Training 17
 */
public class CT01Training_17 {
    /** 초기화 */
    public static void start(String[] args) {
        Scanner oScanner = new Scanner(System.in);
        CCanvas oCanvas = new CCanvas();

        do {
            printMenu();
            int nMenu = oScanner.nextInt();

            // 종료 일 경우
            if(nMenu == MENU_EXIT) {
                break;
            }

            switch(nMenu) {
                case MENU_ADD_LINE:
                case MENU_ADD_TRIANGLE:
                case MENU_ADD_RECTANGLE:
                    CShape oShape = createShape(nMenu);
                    oCanvas.addShape(oShape);

                    String oColor = oShape.getColor();
                    String oStr_Shape = oShape.getShape();

                    System.out.printf("%s %s 를 추가했습니다.\n", oColor, oStr_Shape);
                    break;

                case MENU_DRAW_SHAPES_ALL:
                    oCanvas.drawShapes_All();
                    break;
            }

            System.out.println();
        } while(true);

        System.out.println("프로그램을 종료합니다.");
    }

    /**
     * 메뉴
     */
    private static final int MENU_ADD_LINE = 1;
    private static final int MENU_ADD_TRIANGLE = 2;
    private static final int MENU_ADD_RECTANGLE = 3;
    private static final int MENU_DRAW_SHAPES_ALL = 4;
    private static final int MENU_EXIT = 5;

    /** 메뉴를 출력한다 */
    private static void printMenu() {
        System.out.println("=====> 메뉴 <=====");
        System.out.println("1. 선 추가");
        System.out.println("2. 삼각형 추가");
        System.out.println("3. 사각형 추가");
        System.out.println("4. 모든 도형 그리기");
        System.out.println("5. 종료");

        System.out.print("\n선택 : ");
    }

    /** 도형을 생성한다 */
    private static CShape createShape(int a_nMenu) {
        Random oRandom = new Random();

        int nColor = oRandom.nextInt(CShape.COLOR_RED,
                CShape.COLOR_BLUE + 1);

        switch(a_nMenu) {
            case MENU_ADD_LINE: return new CLine(nColor);
            case MENU_ADD_TRIANGLE: return new CTriangle(nColor);
            case MENU_ADD_RECTANGLE: return new CRectangle(nColor);
        }

        return null;
    }
}

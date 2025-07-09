package Training.Training_10;

/*
 * Java 연습 문제 10
 * - 미로 탈출하기
 * - 제작 맵을 탈출 할 수 있는 경로를 출력하기
 * - # 기호는 장애물, 공백은 이동 가능을 의미한다
 * - 미로를 탈출할 수 있는 경로가 존재 할 경우 해당 경로를 * 기호로 표기한다
 *
 * Ex)
 * =====> 미로 - 탈출 전 <=====
 * ##S##
 * #   #
 * # # #
 * # # #
 * ###E#
 *
 * =====> 미로 - 탈출 후 <=====
 * ##*##
 * # **#
 * # #*#
 * # #*#
 * ###*#
 */

/**
 * Training 10
 */
public class CT01Training_10 {
    /** 초기화 */
    public static void start(String[] args) {
        char[][] oMap = {
                { '#', '#', 'S', '#', '#' },
                { '#', ' ', ' ', ' ', '#' },
                { '#', ' ', '#', ' ', '#' },
                { '#', ' ', '#', ' ', '#' },
                { '#', '#', '#', 'E', '#' },
        };

        System.out.println("=====> 미로 - 탈출 전 <=====");
        printMap(oMap);

        findPos(oMap, 'S');
        findPath(oMap, m_nPos_FindX, m_nPos_FindY);

        System.out.println("\n=====> 미로 - 탈출 후 <=====");
        printMap(oMap);
    }

    private static int m_nPos_FindX = 0;
    private static int m_nPos_FindY = 0;

    /** 위치를 탐색한다 */
    private static void findPos(char[][] a_oMap, char a_chLetter) {
        for(int i = 0; i < a_oMap.length; ++i) {
            for(int j = 0; j < a_oMap[i].length; ++j) {
                // 문자가 존재 할 경우
                if(a_oMap[i][j] == a_chLetter) {
                    m_nPos_FindX = j;
                    m_nPos_FindY = i;
                }
            }
        }
    }

    /** 경로를 탐색한다 */
    private static boolean findPath(char[][] a_oMap, int a_nPos_X, int a_nPos_Y) {
        boolean bIsValidA = a_nPos_X >= 0 && a_nPos_X < a_oMap.length;
        boolean bIsValidB = a_nPos_Y >= 0 && a_nPos_Y < a_oMap.length;

        // 경로 탐색이 불가능 할 경우
        if(!bIsValidA || !bIsValidB) {
            return false;
        }

        char chLetter = a_oMap[a_nPos_Y][a_nPos_X];

        // 경로 탐색이 불가능 할 경우
        if(chLetter == '#' || chLetter == '*') {
            return false;
        }

        a_oMap[a_nPos_Y][a_nPos_X] = '*';

        // 목적지 일 경우
        if(chLetter == 'E') {
            return true;
        }

        int[] oOffsets_X = {
                0, 0, 1, -1
        };

        int[] oOffsets_Y = {
                1, -1, 0, 0
        };

        for(int i = 0; i < oOffsets_X.length; ++i) {
            int nPos_NextX = a_nPos_X + oOffsets_X[i];
            int nPos_NextY = a_nPos_Y + oOffsets_Y[i];

            // 경로 탐색에 성공했을 경우
            if(findPath(a_oMap, nPos_NextX, nPos_NextY)) {
                return true;
            }
        }

        a_oMap[a_nPos_Y][a_nPos_X] = chLetter;
        return false;
    }

    /** 맵을 출력한다 */
    private static void printMap(char[][] a_oMap) {
        for(int i = 0; i < a_oMap.length; ++i) {
            for(int j = 0; j < a_oMap[i].length; ++j) {
                System.out.printf("%c", a_oMap[i][j]);
            }

            System.out.println();
        }
    }
}

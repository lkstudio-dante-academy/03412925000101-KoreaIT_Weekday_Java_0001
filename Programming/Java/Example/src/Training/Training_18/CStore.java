package Training.Training_18;

/**
 * 물건
 */
class CStuff {
    public int m_nPrice = 0;
    public int m_nNumStuffs = 0;

    /** 생성자 */
    public CStuff(int a_nPrice, int a_nNumStuffs) {
        this.m_nPrice = a_nPrice;
        this.m_nNumStuffs = a_nNumStuffs;
    }
}

/**
 * 상점
 */
public class CStore {
    private int m_nNumStuffs = 0;
    private CStuff[] m_oStuffs = new CStuff[5];

    /** 물건 개수를 반환한다 */
    public int getNumStuffs() {
        return m_nNumStuffs;
    }

    /** 물건을 반환한다 */
    public CStuff getStuff(int a_nIdx) {
        return (a_nIdx >= 0 && a_nIdx < m_nNumStuffs) ?
                m_oStuffs[a_nIdx] : null;
    }

    /** 물건을 추가한다 */
    public void addStuff(CStuff a_oStuff) {
        m_oStuffs[m_nNumStuffs++] = a_oStuff;
    }

    /** 물건을 구입한다 */
    public boolean buyStuff(int a_nIdx) {
        // 물건 구입이 불가능 할 경우
        if(a_nIdx < 0 || a_nIdx > m_nNumStuffs) {
            return false;
        }

        m_oStuffs[a_nIdx].m_nNumStuffs -= 1;
        return true;
    }
}

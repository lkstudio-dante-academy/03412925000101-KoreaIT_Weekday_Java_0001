package Training.Training_16;

/**
 * 회원
 */
public class CMember {
    public String m_oName = "";
    public String m_oPNumber = "";

    /** 정보를 출력한다 */
    public void showInfo() {
        System.out.printf("이름 : %s\n", m_oName);
        System.out.printf("전화 번호 : %s\n", m_oPNumber);
    }
}

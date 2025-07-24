package Training.Training_23;

/**
 * 회원
 */
public class CMember {
	public String m_oName = "";
	public String m_oPNumber = "";

	/** 정보를 반환한다 */
	@Override
	public String toString() {
		return String.format("이름 : %s\n전화 번호 : %s", m_oName, m_oPNumber);
	}
}

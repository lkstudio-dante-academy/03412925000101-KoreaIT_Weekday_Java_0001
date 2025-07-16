package Training.Training_20;

/**
 * 회원
 */
public class CMember {
	public String m_oName = "";
	public String m_oPNumber = "";
	
	/** 생성자 */
	public CMember(String a_oName, String a_oPNumber) {
		this.m_oName = a_oName;
		this.m_oPNumber = a_oPNumber;
	}

	/** 정보를 반환한다 */
	@Override
	public String toString() {
		return String.format("이름 : %s\n전화 번호 : %s", m_oName, m_oPNumber);
	}
}

package Training.Training_20;

/**
 * 회원 관리자
 */
public class CManager_Member {
	private int m_nNumMembers = 0;
	private CMember[] m_oMembers = new CMember[5];

	/** 회원을 추가한다 */
	public void addMember(String a_oName, String a_oPNumber) {
		// 배열이 가득 찼을 경우
		if(m_nNumMembers >= m_oMembers.length) {
			CMember[] oMembers_New = new CMember[m_oMembers.length * 2];

			for(int i = 0; i < m_nNumMembers; ++i) {
				oMembers_New[i] = m_oMembers[i];
			}

			m_oMembers = oMembers_New;
		}

		CMember oMember = new CMember(a_oName, a_oPNumber);
		m_oMembers[m_nNumMembers++] = oMember;
	}

	/** 회원을 제거한다 */
	public void removeMember(String a_oName) {
		int nResult = this.findMember_At(a_oName);

		// 제거가 불가능 할 경우
		if(nResult < 0) {
			return;
		}

		for(int i = nResult; i < m_nNumMembers - 1; ++i) {
			m_oMembers[i] = m_oMembers[i + 1];
		}

		m_nNumMembers -= 1;
	}

	/** 회원을 검색한다 */
	public void searchMember(String a_oName) {
		int nResult = this.findMember_At(a_oName);

		// 검색이 불가능 할 경우
		if(nResult < 0) {
			return;
		}

		System.out.println(m_oMembers[nResult]);
	}

	/** 모든 회원을 출력한다 */
	public void showMembers_All() {
		for(int i = 0; i < m_nNumMembers; ++i) {
			System.out.printf("%s\n\n", m_oMembers[i]);
		}
	}

	/** 회원을 탐색한다 */
	public int findMember_At(String a_oName) {
		for(int i = 0; i < m_nNumMembers; ++i) {
			// 이름이 동일 할 경우
			if(a_oName.equals(m_oMembers[i].m_oName)) {
				return i;
			}
		}

		return -1;
	}
}

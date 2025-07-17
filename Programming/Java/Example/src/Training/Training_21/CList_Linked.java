package Training.Training_21;

/**
 * 연결 리스트
 */
public class CList_Linked {
	/**
	 * 노드
	 */
	private static class CNode {
		public int m_nVal = 0;
		public CNode m_oNode_Next = null;
	}

	private int m_nNumValues = 0;
	private CNode m_oNode_Head = null;

	/** 생성자 */
	public CList_Linked() {
		this.m_oNode_Head = this.createNode(0);
	}

	/** 개수를 반환한다 */
	public int getNumValues() {
		return m_nNumValues;
	}

	/** 값을 반환한다 */
	public int getVal(int a_nIdx) {
		CNode oNode = m_oNode_Head;

		for(int i = 0; i < a_nIdx; ++i) {
			oNode = oNode.m_oNode_Next;
		}

		return oNode.m_oNode_Next.m_nVal;
	}

	/** 값을 추가한다 */
	public void addVal(int a_nVal) {
		CNode oNode_Tail = m_oNode_Head;

		while(oNode_Tail.m_oNode_Next != null) {
			oNode_Tail = oNode_Tail.m_oNode_Next;
		}

		oNode_Tail.m_oNode_Next = this.createNode(a_nVal);
		m_nNumValues += 1;
	}

	/** 값을 제거한다 */
	public void removeVal(int a_nVal) {
		CNode oNode = this.findNode(a_nVal);
		CNode oNode_Remove = oNode.m_oNode_Next;

		oNode.m_oNode_Next = oNode_Remove.m_oNode_Next;
		m_nNumValues -= 1;
	}

	/** 노드를 탐색한다 */
	private CNode findNode(int a_nVal) {
		CNode oNode = m_oNode_Head;

		while(oNode.m_oNode_Next != null &&
				oNode.m_oNode_Next.m_nVal != a_nVal) {
			oNode = oNode.m_oNode_Next;
		}

		return oNode;
	}

	/** 노드를 생성한다 */
	private CNode createNode(int a_nVal) {
		CNode oNode = new CNode();
		oNode.m_nVal = a_nVal;

		return oNode;
	}
}

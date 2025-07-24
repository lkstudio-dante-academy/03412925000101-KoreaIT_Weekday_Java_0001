package Training.Training_23;

/*
 * Java 연습 문제 23
 * - 회원 관리 프로그램 제작하기 (+ 파일 시스템 활용)
 * - 자세한 사항은 연습 문제 16 번 참고
 */

import java.util.Scanner;

/**
 * Training 23
 */
public class CT01Training_23 {
	/** 초기화 */
	public static void start(String[] args) {
		final int MENU_ADD_MEMBER = 1;
		final int MENU_REMOVE_MEMBER = 2;
		final int MENU_SEARCH_MEMBER = 3;
		final int MENU_SHOW_MEMBERS_ALL = 4;
		final int MENU_EXIT = 5;
		
		int nMenu = 0;
		CManager_Member oManager = new CManager_Member();
		
		Scanner oScanner = new Scanner(System.in);
		String oPath_File = "P_T01Training_23_01.txt";
		
		oManager.loadMembers_FromFile(oPath_File);
		
		do {
			printMenu();
			nMenu = oScanner.nextInt();
			
			oScanner.nextLine();
			
			// 종료 일 경우
			if(nMenu == MENU_EXIT) {
				break;
			}
			
			try {
				switch (nMenu) {
					case MENU_ADD_MEMBER:
						addMember(oManager, oScanner);
						break;
					
					case MENU_REMOVE_MEMBER:
						removeMember(oManager, oScanner);
						break;
					
					case MENU_SEARCH_MEMBER:
						searchMember(oManager, oScanner);
						break;
					
					case MENU_SHOW_MEMBERS_ALL:
						showMembers_All(oManager);
						break;
				}
			} catch(Exception oException) {
				System.out.printf("%s\n", oException.getMessage());
			}
			
			System.out.println();
			oManager.saveMembers_ToFile(oPath_File);
		} while(true);
	}
	
	/** 메뉴를 출력한다 */
	private static void printMenu() {
		System.out.println("=====> 메뉴 <=====");
		System.out.println("1. 회원 추가");
		System.out.println("2. 회원 제거");
		System.out.println("3. 회원 검색");
		System.out.println("4. 모든 회원 출력");
		System.out.println("5. 종료");
		
		System.out.print("\n선택 : ");
	}
	
	/** 회원을 추가한다 */
	private static void addMember(CManager_Member a_oManager,
								  Scanner a_oScanner) throws CException_Duplicate {
		System.out.print("이름 입력 : ");
		String oName = a_oScanner.nextLine();
		
		System.out.print("전화 번호 입력 : ");
		String oPNumber = a_oScanner.nextLine();
		
		int nResult = a_oManager.findMember_At(oName);
		
		// 회원이 존재 할 경우
		if(nResult >= 0) {
			throw new CException_Duplicate(oName);
		}
		
		a_oManager.addMember(oName, oPNumber);
		System.out.printf("%s 을(를) 추가했습니다.", oName);
	}
	
	/** 회원을 제거한다 */
	private static void removeMember(CManager_Member a_oManager, Scanner a_oScanner) throws CException_Missing {
		System.out.print("이름 입력 : ");
		String oName = a_oScanner.nextLine();
		
		int nResult = a_oManager.findMember_At(oName);
		
		// 회원이 없을 경우
		if(nResult < 0) {
			throw new CException_Missing(oName);
		}
		
		a_oManager.removeMember(oName);
		System.out.printf("%s 을(를) 제거했습니다.", oName);
	}
	
	/** 회원을 검색한다 */
	private static void searchMember(CManager_Member a_oManager, Scanner a_oScanner) throws CException_Missing {
		System.out.print("이름 입력 : ");
		String oName = a_oScanner.nextLine();
		
		int nResult = a_oManager.findMember_At(oName);
		
		// 회원이 없을 경우
		if(nResult < 0) {
			throw new CException_Missing(oName);
		}
		
		System.out.println("=====> 회원 정보 <=====");
		a_oManager.searchMember(oName);
	}
	
	/** 모든 회원을 출력한다 */
	private static void showMembers_All(CManager_Member a_oManager) {
		System.out.println("=====> 모든 회원 정보 <=====");
		a_oManager.showMembers_All();
	}
}

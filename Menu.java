package controller;

public class Menu {
	public static void mainMenu() {
		System.out.println("1.주간 게임 순위");
		System.out.println("2.월간 게임 순위");
		System.out.println("3.종료");
	}

	public static void menu() {
		System.out.println("1.순위권 PC게임 모두 조회");
		System.out.println("2.조건 조회");
		System.out.println("3.게임데이터수정");
		System.out.println("4.게임데이터추가");
		System.out.println("5.게임데이터삭제");
		System.out.println("6.종료");

	}

	public static void conditionMenu() {
		System.out.println("1.순위로 조회");
		System.out.println("2.이름으로 조회");
		System.out.println("3.가격으로 조회");
		System.out.println("4.제작사로 조회");
		System.out.println("5.배급사로 조회");
		System.out.println("6.장르로 조회");
		System.out.println("7.출시일자로 조회");
		System.out.println("8.플랫폼으로 조회");
	}

	public static void updateMenu() {
		System.out.println("1.순위 수정");
		System.out.println("2.이름 수정");
		System.out.println("3.가격 수정");
		System.out.println("4.제작사 수정");
		System.out.println("5.배급사 수정");
		System.out.println("6.장르 수정");
		System.out.println("7.출시일자 수정");
		System.out.println("8.플랫폼 수정");
	}
}


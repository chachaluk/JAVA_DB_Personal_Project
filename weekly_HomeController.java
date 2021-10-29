package controller;

import java.util.ArrayList;
import java.util.Scanner;

import dto.MemberVO;
import service.weekly_MemberService;

public class weekly_HomeController {
	public static void weekly() {
		while (true) {
			ArrayList<MemberVO> dtos = null;
			weekly_MemberService service = new weekly_MemberService();// service 객체 생성

			int choice = 0;
			Scanner sc = new Scanner(System.in);
			Menu.menu();// 메뉴
			choice = sc.nextInt();// 메뉴 번호 입력
			if (choice == 1) {// 모두조회
				dtos = service.get_weekly_AllMembers();
				for (int i = 0; i < dtos.size(); i++) {
					System.out.printf("%d순위\n", dtos.get(i).getNO());
					System.out.printf("이름: %s\n", dtos.get(i).getNAME());
					System.out.printf("가격: %s\n", dtos.get(i).getPRICE());
					System.out.printf("제작: %s\n", dtos.get(i).getsetPRODUCTION_COMPANY());
					System.out.printf("배급: %s\n", dtos.get(i).getDISTRIBUTOR());
					System.out.printf("장르: %s\n", dtos.get(i).getGENRE());
					System.out.printf("출시일자: %s\n", dtos.get(i).getRELEASE_DATE());
					System.out.printf("플랫폼: %s\n", dtos.get(i).getPLATFORME());
					System.out.print(" \n");
				}
				dtos.removeAll(dtos);// 배열초기화

			} else if (choice == 2) {// 조건조회

				Menu.conditionMenu();
				int select = sc.nextInt();
				switch (select) {

				case 1:
					System.out.print("조회할 게임 순위 입력: ");
					String input_no = sc.next();
					dtos = service.weekly_SearchRanking(input_no);
					break;
				case 2:
					System.out.print("조회할 게임 이름 입력: ");
					String input_name = sc.next();
					dtos = service.weekly_Search("name", input_name);
					break;
				case 3:
					System.out.print("조회할 게임 가격 입력: ");
					String input_price = sc.next();
					dtos = service.weekly_Search("price", input_price);

					break;
				case 4:
					System.out.print("조회할 게임 제작사 입력: ");
					String input_production_company = sc.next();
					dtos = service.weekly_Search("production_company", input_production_company);
					break;
				case 5:
					System.out.print("조회할 게임 배급사 입력: ");
					String input_distributor = sc.next();
					dtos = service.weekly_Search("distributor", input_distributor);
					break;
				case 6:
					System.out.print("조회할 게임 장르 입력: ");
					String input_genre = sc.next();
					dtos = service.weekly_Search("genre", input_genre);
					break;
				case 7:
					System.out.print("조회할 게임 출시일자 입력: ");
					String input_release_date = sc.next();
					dtos = service.weekly_Search("release_date", input_release_date);
					break;
				case 8:
					System.out.print("조회할 게임 플랫폼 입력: ");
					String input_platform = sc.next();
					dtos = service.weekly_Search("platform", input_platform);
					break;
				default:
					System.out.println("잘못입력하셨습니다.");
					break;

				}
				for (int i = 0; i < dtos.size(); i++) {
					System.out.printf("%d순위\n", dtos.get(i).getNO());
					System.out.printf("이름: %s\n", dtos.get(i).getNAME());
					System.out.printf("가격: %s\n", dtos.get(i).getPRICE());
					System.out.printf("제작: %s\n", dtos.get(i).getsetPRODUCTION_COMPANY());
					System.out.printf("배급: %s\n", dtos.get(i).getDISTRIBUTOR());
					System.out.printf("장르: %s\n", dtos.get(i).getGENRE());
					System.out.printf("출시일자: %s\n", dtos.get(i).getRELEASE_DATE());
					System.out.printf("플랫폼: %s\n", dtos.get(i).getPLATFORME());
				}
				dtos.removeAll(dtos);// 배열초기화

			} else if (choice == 3) {// 수정

				Menu.updateMenu();
				int select2 = sc.nextInt();

				switch (select2) {
				case 1:
					System.out.print("수정할 게임 순위 입력: ");
					int no = sc.nextInt();
					System.out.print("순위를 수정할 게임 이름 전체 입력: ");
					String name = sc.next();
					dtos = service.weekly_updateNO(name, no);
				case 2:
					System.out.print("수정할 게임 순위 입력: ");
					no = sc.nextInt();
					System.out.print("게임이름: ");
					String enter_name = sc.next();
					dtos = service.weekly_updateName(no, enter_name);
					break;
				case 3:
					System.out.print("수정할 게임 순위 입력: ");
					no = sc.nextInt();
					System.out.print("가격: ");
					String enter_price = sc.next();
					dtos = service.weekly_updatePrice(no, enter_price);
					break;

				case 4:
					System.out.print("수정할 게임 순위 입력: ");
					no = sc.nextInt();
					System.out.print("제작사: ");
					String enter_production_company = sc.next();
					dtos = service.weekly_updateProduction_company(no, enter_production_company);
					break;

				case 5:
					System.out.print("수정할 게임 순위 입력: ");
					no = sc.nextInt();
					System.out.print("배급사: ");
					String enter_distributor = sc.next();
					dtos = service.weekly_updateDistributor(no, enter_distributor);
					break;

				case 6:
					System.out.print("수정할 게임 순위 입력: ");
					no = sc.nextInt();
					System.out.print("장르: ");
					String enter_genre = sc.next();
					dtos = service.weekly_updateGenre(no, enter_genre);
					break;

				case 7:
					System.out.print("수정할 게임 순위 입력: ");
					no = sc.nextInt();
					System.out.print("출시일자: ");
					String enter_release_date = sc.next();
					dtos = service.weekly_updateRelease_date(no, enter_release_date);
					break;

				case 8:
					System.out.print("수정할 게임 순위 입력: ");
					no = sc.nextInt();
					System.out.print("플랫폼: ");
					String enter_platform = sc.next();
					dtos = service.weekly_updatePlatform(no, enter_platform);
					break;

				}

			} else if (choice == 4) {// 추가
				System.out.print("추가할 게임 정보 입력 \n");
				System.out.print("순위: ");
				int no = sc.nextInt();
				System.out.print("게임이름: ");
				String name = sc.next();
				System.out.print("가격(부분유료화/무료/가격입력): ");
				String price = sc.next();
				System.out.print("제작사: ");
				String production_company = sc.next();
				System.out.print("배급사: ");
				String distributor = sc.next();

				sc.nextLine();// 입력버퍼 해결

				System.out.print("장르: ");
				String genre = sc.next();
				System.out.print("출시일자: ");
				String release_date = sc.next();
				System.out.print("플랫폼: ");
				String platform = sc.next();
				dtos = service.set_weekly_Members(no, name, price, production_company, distributor, genre, release_date,
						platform);
				System.out.print("입력한 게임 정보 추가 완료\n");

			} else if (choice == 5) {// 삭제
				System.out.print("삭제할 게임 이름 전체 입력: ");
				String input_game_name = sc.next();
				dtos = service.weekly_deleteMembers(input_game_name);
				System.out.print("입력한 게임 정보 삭제 완료\n");

			} else if (choice == 6) {// 종료
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}

		}
		

	}
}

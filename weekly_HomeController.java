package controller;

import java.util.ArrayList;
import java.util.Scanner;

import dto.MemberVO;
import service.weekly_MemberService;

public class weekly_HomeController {
	public static void weekly() {
		while (true) {
			ArrayList<MemberVO> dtos = null;
			weekly_MemberService service = new weekly_MemberService();// service ��ü ����

			int choice = 0;
			Scanner sc = new Scanner(System.in);
			Menu.menu();// �޴�
			choice = sc.nextInt();// �޴� ��ȣ �Է�
			if (choice == 1) {// �����ȸ
				dtos = service.get_weekly_AllMembers();
				for (int i = 0; i < dtos.size(); i++) {
					System.out.printf("%d����\n", dtos.get(i).getNO());
					System.out.printf("�̸�: %s\n", dtos.get(i).getNAME());
					System.out.printf("����: %s\n", dtos.get(i).getPRICE());
					System.out.printf("����: %s\n", dtos.get(i).getsetPRODUCTION_COMPANY());
					System.out.printf("���: %s\n", dtos.get(i).getDISTRIBUTOR());
					System.out.printf("�帣: %s\n", dtos.get(i).getGENRE());
					System.out.printf("�������: %s\n", dtos.get(i).getRELEASE_DATE());
					System.out.printf("�÷���: %s\n", dtos.get(i).getPLATFORME());
					System.out.print(" \n");
				}
				dtos.removeAll(dtos);// �迭�ʱ�ȭ

			} else if (choice == 2) {// ������ȸ

				Menu.conditionMenu();
				int select = sc.nextInt();
				switch (select) {

				case 1:
					System.out.print("��ȸ�� ���� ���� �Է�: ");
					String input_no = sc.next();
					dtos = service.weekly_SearchRanking(input_no);
					break;
				case 2:
					System.out.print("��ȸ�� ���� �̸� �Է�: ");
					String input_name = sc.next();
					dtos = service.weekly_Search("name", input_name);
					break;
				case 3:
					System.out.print("��ȸ�� ���� ���� �Է�: ");
					String input_price = sc.next();
					dtos = service.weekly_Search("price", input_price);

					break;
				case 4:
					System.out.print("��ȸ�� ���� ���ۻ� �Է�: ");
					String input_production_company = sc.next();
					dtos = service.weekly_Search("production_company", input_production_company);
					break;
				case 5:
					System.out.print("��ȸ�� ���� ��޻� �Է�: ");
					String input_distributor = sc.next();
					dtos = service.weekly_Search("distributor", input_distributor);
					break;
				case 6:
					System.out.print("��ȸ�� ���� �帣 �Է�: ");
					String input_genre = sc.next();
					dtos = service.weekly_Search("genre", input_genre);
					break;
				case 7:
					System.out.print("��ȸ�� ���� ������� �Է�: ");
					String input_release_date = sc.next();
					dtos = service.weekly_Search("release_date", input_release_date);
					break;
				case 8:
					System.out.print("��ȸ�� ���� �÷��� �Է�: ");
					String input_platform = sc.next();
					dtos = service.weekly_Search("platform", input_platform);
					break;
				default:
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
					break;

				}
				for (int i = 0; i < dtos.size(); i++) {
					System.out.printf("%d����\n", dtos.get(i).getNO());
					System.out.printf("�̸�: %s\n", dtos.get(i).getNAME());
					System.out.printf("����: %s\n", dtos.get(i).getPRICE());
					System.out.printf("����: %s\n", dtos.get(i).getsetPRODUCTION_COMPANY());
					System.out.printf("���: %s\n", dtos.get(i).getDISTRIBUTOR());
					System.out.printf("�帣: %s\n", dtos.get(i).getGENRE());
					System.out.printf("�������: %s\n", dtos.get(i).getRELEASE_DATE());
					System.out.printf("�÷���: %s\n", dtos.get(i).getPLATFORME());
				}
				dtos.removeAll(dtos);// �迭�ʱ�ȭ

			} else if (choice == 3) {// ����

				Menu.updateMenu();
				int select2 = sc.nextInt();

				switch (select2) {
				case 1:
					System.out.print("������ ���� ���� �Է�: ");
					int no = sc.nextInt();
					System.out.print("������ ������ ���� �̸� ��ü �Է�: ");
					String name = sc.next();
					dtos = service.weekly_updateNO(name, no);
				case 2:
					System.out.print("������ ���� ���� �Է�: ");
					no = sc.nextInt();
					System.out.print("�����̸�: ");
					String enter_name = sc.next();
					dtos = service.weekly_updateName(no, enter_name);
					break;
				case 3:
					System.out.print("������ ���� ���� �Է�: ");
					no = sc.nextInt();
					System.out.print("����: ");
					String enter_price = sc.next();
					dtos = service.weekly_updatePrice(no, enter_price);
					break;

				case 4:
					System.out.print("������ ���� ���� �Է�: ");
					no = sc.nextInt();
					System.out.print("���ۻ�: ");
					String enter_production_company = sc.next();
					dtos = service.weekly_updateProduction_company(no, enter_production_company);
					break;

				case 5:
					System.out.print("������ ���� ���� �Է�: ");
					no = sc.nextInt();
					System.out.print("��޻�: ");
					String enter_distributor = sc.next();
					dtos = service.weekly_updateDistributor(no, enter_distributor);
					break;

				case 6:
					System.out.print("������ ���� ���� �Է�: ");
					no = sc.nextInt();
					System.out.print("�帣: ");
					String enter_genre = sc.next();
					dtos = service.weekly_updateGenre(no, enter_genre);
					break;

				case 7:
					System.out.print("������ ���� ���� �Է�: ");
					no = sc.nextInt();
					System.out.print("�������: ");
					String enter_release_date = sc.next();
					dtos = service.weekly_updateRelease_date(no, enter_release_date);
					break;

				case 8:
					System.out.print("������ ���� ���� �Է�: ");
					no = sc.nextInt();
					System.out.print("�÷���: ");
					String enter_platform = sc.next();
					dtos = service.weekly_updatePlatform(no, enter_platform);
					break;

				}

			} else if (choice == 4) {// �߰�
				System.out.print("�߰��� ���� ���� �Է� \n");
				System.out.print("����: ");
				int no = sc.nextInt();
				System.out.print("�����̸�: ");
				String name = sc.next();
				System.out.print("����(�κ�����ȭ/����/�����Է�): ");
				String price = sc.next();
				System.out.print("���ۻ�: ");
				String production_company = sc.next();
				System.out.print("��޻�: ");
				String distributor = sc.next();

				sc.nextLine();// �Է¹��� �ذ�

				System.out.print("�帣: ");
				String genre = sc.next();
				System.out.print("�������: ");
				String release_date = sc.next();
				System.out.print("�÷���: ");
				String platform = sc.next();
				dtos = service.set_weekly_Members(no, name, price, production_company, distributor, genre, release_date,
						platform);
				System.out.print("�Է��� ���� ���� �߰� �Ϸ�\n");

			} else if (choice == 5) {// ����
				System.out.print("������ ���� �̸� ��ü �Է�: ");
				String input_game_name = sc.next();
				dtos = service.weekly_deleteMembers(input_game_name);
				System.out.print("�Է��� ���� ���� ���� �Ϸ�\n");

			} else if (choice == 6) {// ����
				break;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}

		}
		

	}
}

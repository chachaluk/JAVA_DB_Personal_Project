package service;//dao�� ����

import java.util.ArrayList;

import dao.MemberDAO;
import dto.MemberVO;

public class MemberService {//Service�� DB�� DAO�� �����ϰ� �����͸� DTO�� ���޹��� �Ŀ� �����͸� �ʿ信 �°� �����Ͽ� ��ȯ
	
	private MemberDAO dao;
	public MemberService() {
		dao=new MemberDAO();
	}
	public ArrayList<MemberVO> getAllMembers(){
		return dao.getAllMembers();
	}
	public ArrayList<MemberVO> setMembers(int no, String name, String price, String production_company,
			String distributor, String genre, String release_date, String platform){
		return dao.setMembers(no, name, price, production_company, distributor, genre, release_date, platform);
	}
	public ArrayList<MemberVO> Search(String Condition, String input){//��ȸ
		return dao.Search(Condition, input);
	}
	public ArrayList<MemberVO> SearchRanking(String input) {//������ ��ȸ
		return dao.SearchRanking(input);
	}
	public ArrayList<MemberVO> deleteMembers(String input_game_name) {//����
		return dao.deleteMembers(input_game_name);
	}

	public ArrayList<MemberVO> updateNO(String name, int NO){//���� ����
		return dao.updateNO(NO, name);
	}
	public ArrayList<MemberVO> updateName(int no, String enter_name){//�̸� ����
		return dao.updateName(no, enter_name);
	}
	public ArrayList<MemberVO> updatePrice(int no, String enter_price){//���� ����
		return dao.updatePrice(no, enter_price);
	}
	public ArrayList<MemberVO> updateProduction_company(int no, String enter_production_company){//���ۻ� ����
		return dao.updateProcuction_company(no, enter_production_company);
	}
	public ArrayList<MemberVO> updateDistributor(int no, String enter_distributor){//��޻� ����
		return dao.updateDistributor(no, enter_distributor);
	}
	public ArrayList<MemberVO> updateGenre(int no, String enter_genre){//�帣 ����
		return dao.updateGenre(no, enter_genre);
	}
	public ArrayList<MemberVO> updateRelease_date(int no, String enter_release_date){//������� ����
		return dao.updateRelease_date(no, enter_release_date);
	}
	public ArrayList<MemberVO> updatePlatform(int no, String enter_platform){//�÷��� ����
		return dao.updatePlatform(no, enter_platform);
	}
}

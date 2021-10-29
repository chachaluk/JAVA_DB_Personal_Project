package service;

import java.util.ArrayList;

import dao.weekly_MemberDAO;
import dto.MemberVO;

public class weekly_MemberService {
	private weekly_MemberDAO dao;

	public weekly_MemberService() {
		dao=new weekly_MemberDAO();
	}

	public ArrayList<MemberVO> get_weekly_AllMembers() {
		return dao.get_weekly_AllMembers();
	}

	public ArrayList<MemberVO> set_weekly_Members(int no, String name, String price, String production_company,
			String distributor, String genre, String release_date, String platform) {
		return dao.set_weekly_Members(no, name, price, production_company, distributor, genre, release_date, platform);
	}

	public ArrayList<MemberVO> weekly_Search(String Condition, String input) {// 조회
		return dao.weekly_Search(Condition, input);
	}

	public ArrayList<MemberVO> weekly_SearchRanking(String input) {// 순위로 조회
		return dao.weekly_SearchRanking(input);
	}

	public ArrayList<MemberVO> weekly_deleteMembers(String input_game_name) {// 삭제
		return dao.weekly_deleteMembers(input_game_name);
	}

	public ArrayList<MemberVO> weekly_updateNO(String name, int NO) {// 순위 수정
		return dao.weekly_updateNO(NO, name);
	}

	public ArrayList<MemberVO> weekly_updateName(int no, String enter_name) {// 이름 수정
		return dao.weekly_updateName(no, enter_name);
	}

	public ArrayList<MemberVO> weekly_updatePrice(int no, String enter_price) {// 가격 수정
		return dao.weekly_updatePrice(no, enter_price);
	}

	public ArrayList<MemberVO> weekly_updateProduction_company(int no, String enter_production_company) {// 제작사 수정
		return dao.weekly_updateProcuction_company(no, enter_production_company);
	}

	public ArrayList<MemberVO> weekly_updateDistributor(int no, String enter_distributor) {// 배급사 수정
		return dao.weekly_updateDistributor(no, enter_distributor);
	}

	public ArrayList<MemberVO> weekly_updateGenre(int no, String enter_genre) {// 장르 수정
		return dao.weekly_updateGenre(no, enter_genre);
	}

	public ArrayList<MemberVO> weekly_updateRelease_date(int no, String enter_release_date) {// 출시일자 수정
		return dao.weekly_updateRelease_date(no, enter_release_date);
	}

	public ArrayList<MemberVO> weekly_updatePlatform(int no, String enter_platform) {// 플랫폼 수정
		return dao.weekly_updatePlatform(no, enter_platform);
	}
}

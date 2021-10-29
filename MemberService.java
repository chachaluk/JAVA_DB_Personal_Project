package service;//dao를 포함

import java.util.ArrayList;

import dao.MemberDAO;
import dto.MemberVO;

public class MemberService {//Service가 DB에 DAO로 접근하고 데이터를 DTO로 전달받은 후에 데이터를 필요에 맞게 가공하여 반환
	
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
	public ArrayList<MemberVO> Search(String Condition, String input){//조회
		return dao.Search(Condition, input);
	}
	public ArrayList<MemberVO> SearchRanking(String input) {//순위로 조회
		return dao.SearchRanking(input);
	}
	public ArrayList<MemberVO> deleteMembers(String input_game_name) {//삭제
		return dao.deleteMembers(input_game_name);
	}

	public ArrayList<MemberVO> updateNO(String name, int NO){//순위 수정
		return dao.updateNO(NO, name);
	}
	public ArrayList<MemberVO> updateName(int no, String enter_name){//이름 수정
		return dao.updateName(no, enter_name);
	}
	public ArrayList<MemberVO> updatePrice(int no, String enter_price){//가격 수정
		return dao.updatePrice(no, enter_price);
	}
	public ArrayList<MemberVO> updateProduction_company(int no, String enter_production_company){//제작사 수정
		return dao.updateProcuction_company(no, enter_production_company);
	}
	public ArrayList<MemberVO> updateDistributor(int no, String enter_distributor){//배급사 수정
		return dao.updateDistributor(no, enter_distributor);
	}
	public ArrayList<MemberVO> updateGenre(int no, String enter_genre){//장르 수정
		return dao.updateGenre(no, enter_genre);
	}
	public ArrayList<MemberVO> updateRelease_date(int no, String enter_release_date){//출시일자 수정
		return dao.updateRelease_date(no, enter_release_date);
	}
	public ArrayList<MemberVO> updatePlatform(int no, String enter_platform){//플랫폼 수정
		return dao.updatePlatform(no, enter_platform);
	}
}

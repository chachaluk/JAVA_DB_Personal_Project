package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.MemberVO;

public class MemberDAO {//데이터베이스 연동 로직을 가지고있는 객체, 데이터 연결

	private ArrayList<MemberVO> dtos;
	private Connection con;//자바와 db를 연결
	private Statement st;//sql문을 실행하고 생성되는 결과를 반환하는데 사용되는 개체
	private PreparedStatement pstmt;//미리 컴파일된 sql문을 나타내는 개체, sql문이 pstmt에 미리 컴파일되어 저장되면 statement을 여러번 효율적으로 실행할 수 있음
	private ResultSet rs;//데이터베이스 결과 집합을 나타내는 데이터 테이블
	
	public MemberDAO() {
		dtos = new ArrayList<MemberVO>();
		try {
			String user="system";
			String pw="1234";
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,user,pw);
			st=con.createStatement();
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 오류:"+e.getMessage());
		}	
	}

		public ArrayList<MemberVO> getAllMembers() {//전체조회
			String SQL="SELECT * FROM MONTHLY_GAME_RANKINGS order by no asc";
			try {
				rs=st.executeQuery(SQL);
				while(rs.next()) {	
					int no = rs.getInt("no");
					String name = rs.getString("name");
					String price = rs.getString("price");
					String production_company = rs.getString("production_company");
					String distributor = rs.getString("distributor");
					String genre = rs.getString("genre");
					String release_date = rs.getString("release_date");
					String platform = rs.getString("platform");
					MemberVO VO = new MemberVO(no,name,price,production_company,
							distributor,genre,release_date, platform);
					dtos.add(VO);
					//ArrayList에 정보 추가
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return dtos;
		}
		
		
		public ArrayList<MemberVO> SearchRanking(String input) {//순위로 조회
			String SQL = "SELECT*FROM PC_GAME WHERE NO ="+input;
			try {
				rs=st.executeQuery(SQL);
				while(rs.next()) {
					int no = rs.getInt("NO");
					String name = rs.getString("NAME");
					String price = rs.getString("PRICE");
					String production_company = rs.getString("PRODUCTION_COMPANY");
					String distributor = rs.getString("DISTRIBUTOR");
					String genre = rs.getString("GENRE");
					String release_date = rs.getString("RELEASE_DATE");
					String platform = rs.getString("PLATFORM");
					
					MemberVO VO = new MemberVO(no,name,price,production_company,
							distributor,genre,release_date, platform);
					dtos.add(VO);
					
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return dtos;
		}
		
		public ArrayList<MemberVO> Search(String Condition,String input) {//조건조회
			String SQL = "SELECT * FROM PC_GAME where "+Condition+" like '%"+input+"%'" + " order by no asc";
			try {
				rs=st.executeQuery(SQL);
				while(rs.next()) {
					int no = rs.getInt("NO");
					String name = rs.getString("NAME");
					String price = rs.getString("PRICE");
					String production_company = rs.getString("PRODUCTION_COMPANY");
					String distributor = rs.getString("DISTRIBUTOR");
					String genre = rs.getString("GENRE");
					String release_date = rs.getString("RELEASE_DATE");
					String platform = rs.getString("PLATFORM");
					MemberVO VO = new MemberVO(no,name,price,production_company,
							distributor,genre,release_date,platform);
					dtos.add(VO);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return dtos;
		}
		
		
		

		public ArrayList<MemberVO> setMembers(int no, String name, String price, String production_company,
				 String distributor, String genre, String release_date, String platform) {//추가
			String SQL = "Insert INTO PC_GAME(no,name,price,production_company,distributor,genre,release_date, platform) "
					+ "VALUES(?,?,?,?,?,?,?,?)";
			
			try {
				pstmt=con.prepareStatement(SQL);
				pstmt.setInt(1, no);
				pstmt.setString(2, name);
				pstmt.setString(3, price);
				pstmt.setString(4, production_company);
				pstmt.setString(5, distributor);
				pstmt.setString(6, genre);
				pstmt.setString(7, release_date);
				pstmt.setString(8, platform);
				pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return dtos;
		}
		
		
		public ArrayList<MemberVO> deleteMembers(String input_game_name) {//삭제
			String SQL = "delete from PC_GAME where name='"+input_game_name+"'";
			try {
				rs=st.executeQuery(SQL);
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return dtos;
		}
		
		public ArrayList<MemberVO> updateNO(int no, String name){//순위 수정
			String SQL = "UPDATE PC_GAME SET NO=? where name=?";//정확한 이름입력
			try {
				pstmt=con.prepareStatement(SQL);
				pstmt.setInt(1, no);
				pstmt.setString(2,name);
				pstmt.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return dtos;
		}
		public ArrayList<MemberVO> updateName(int no, String enter_name){//이름수정
			String SQL = "UPDATE PC_GAME SET name=? where no=?";
			try {
				pstmt=con.prepareStatement(SQL);
				pstmt.setString(1, enter_name);
				pstmt.setInt(2, no);
				pstmt.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return dtos;
		}
		public ArrayList<MemberVO> updatePrice(int no, String enter_price){//가격수정
			String SQL = "UPDATE PC_GAME SET price=? where no=?";
			try {
				pstmt=con.prepareStatement(SQL);
				pstmt.setString(1, enter_price);
				pstmt.setInt(2, no);
				pstmt.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return dtos;
		}
		public ArrayList<MemberVO> updateProcuction_company(int no, String enter_production_company){//제작사수정
			String SQL = "UPDATE PC_GAME SET production_company=? where no=?";
			try {
				pstmt=con.prepareStatement(SQL);
				pstmt.setString(1, enter_production_company);
				pstmt.setInt(2, no);
				pstmt.executeUpdate();
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return dtos;
		}
		public ArrayList<MemberVO> updateDistributor(int no, String enter_distributor){//배급사수정
			String SQL = "UPDATE PC_GAME SET distributor=? where no=?";
			try {
				pstmt=con.prepareStatement(SQL);
				pstmt.setString(1, enter_distributor);
				pstmt.setInt(2, no);
				pstmt.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return dtos;
		}
		public ArrayList<MemberVO> updateGenre(int no, String enter_genre){//장르수정
			String SQL = "UPDATE PC_GAME SET genre=? where no=?";
			try {
				pstmt=con.prepareStatement(SQL);
				pstmt.setString(1, enter_genre);
				pstmt.setInt(2, no);
				pstmt.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return dtos;
		}
		public ArrayList<MemberVO> updateRelease_date(int no, String enter_release_date){//출시일자수정
			String SQL = "UPDATE PC_GAME SET release_date=? where no=?";
			try {
				pstmt=con.prepareStatement(SQL);
				pstmt.setString(1, enter_release_date);
				pstmt.setInt(2, no);
				pstmt.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return dtos;
		}
		public ArrayList<MemberVO> updatePlatform(int no, String enter_platform){//플랫폼수정
			String SQL = "UPDATE PC_GAME SET platform=? where no=?";
			try {
				pstmt=con.prepareStatement(SQL);
				pstmt.setString(1, enter_platform);
				pstmt.setInt(2, no);
				pstmt.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return dtos;
		}
		
		
}

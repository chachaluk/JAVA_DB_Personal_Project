package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.MemberVO;

public class weekly_MemberDAO {
	private ArrayList<MemberVO> dtos;
	private Connection con;// �ڹٿ� db�� ����
	private Statement st;// sql���� �����ϰ� �����Ǵ� ����� ��ȯ�ϴµ� ���Ǵ� ��ü
	private PreparedStatement pstmt;// �̸� �����ϵ� sql���� ��Ÿ���� ��ü, sql���� pstmt�� �̸� �����ϵǾ� ����Ǹ� statement�� ������ ȿ�������� ������ ��
									// ����
	private ResultSet rs;// �����ͺ��̽� ��� ������ ��Ÿ���� ������ ���̺�

	public weekly_MemberDAO() {
		dtos = new ArrayList<MemberVO>();
		try {
			String user="system";
			String pw="1234";
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,user,pw);
			st=con.createStatement();
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ����:"+e.getMessage());
		}	
	}

	public ArrayList<MemberVO> get_weekly_AllMembers() {// ��ü��ȸ
		String SQL = "SELECT * FROM WEEKLY_GAME_RANKINGS order by no asc";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String price = rs.getString("price");
				String production_company = rs.getString("production_company");
				String distributor = rs.getString("distributor");
				String genre = rs.getString("genre");
				String release_date = rs.getString("release_date");
				String platform = rs.getString("platform");
				MemberVO VO = new MemberVO(no, name, price, production_company, distributor, genre, release_date,
						platform);
				dtos.add(VO);
				// ArrayList�� ���� �߰�
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public ArrayList<MemberVO> weekly_SearchRanking(String input) {// ������ ��ȸ
		String SQL = "SELECT*FROM WEEKLY_GAME_RANKINGS WHERE NO =" + input;
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String price = rs.getString("PRICE");
				String production_company = rs.getString("PRODUCTION_COMPANY");
				String distributor = rs.getString("DISTRIBUTOR");
				String genre = rs.getString("GENRE");
				String release_date = rs.getString("RELEASE_DATE");
				String platform = rs.getString("PLATFORM");

				MemberVO VO = new MemberVO(no, name, price, production_company, distributor, genre, release_date,
						platform);
				dtos.add(VO);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public ArrayList<MemberVO> weekly_Search(String Condition, String input) {// ������ȸ
		String SQL = "SELECT * FROM WEEKLY_GAME_RANKINGS where " + Condition + " like '%" + input + "%'" + " order by no asc";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String price = rs.getString("PRICE");
				String production_company = rs.getString("PRODUCTION_COMPANY");
				String distributor = rs.getString("DISTRIBUTOR");
				String genre = rs.getString("GENRE");
				String release_date = rs.getString("RELEASE_DATE");
				String platform = rs.getString("PLATFORM");
				MemberVO VO = new MemberVO(no, name, price, production_company, distributor, genre, release_date,
						platform);
				dtos.add(VO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public ArrayList<MemberVO> set_weekly_Members(int no, String name, String price, String production_company,
			String distributor, String genre, String release_date, String platform) {// �߰�
		String SQL = "Insert INTO WEEKLY_GAME_RANKINGS(no,name,price,production_company,distributor,genre,release_date, platform) "
				+ "VALUES(?,?,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, no);
			pstmt.setString(2, name);
			pstmt.setString(3, price);
			pstmt.setString(4, production_company);
			pstmt.setString(5, distributor);
			pstmt.setString(6, genre);
			pstmt.setString(7, release_date);
			pstmt.setString(8, platform);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public ArrayList<MemberVO> weekly_deleteMembers(String input_game_name) {// ����
		String SQL = "delete from WEEKLY_GAME_RANKINGS where name='" + input_game_name + "'";
		try {
			rs = st.executeQuery(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public ArrayList<MemberVO> weekly_updateNO(int no, String name) {// ���� ����
		String SQL = "UPDATE WEEKLY_GAME_RANKINGS SET NO=? where name=?";// ��Ȯ�� �̸��Է�
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, no);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;

	}

	public ArrayList<MemberVO> weekly_updateName(int no, String enter_name) {// �̸�����
		String SQL = "UPDATE WEEKLY_GAME_RANKINGS SET name=? where no=?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, enter_name);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;

	}

	public ArrayList<MemberVO> weekly_updatePrice(int no, String enter_price) {// ���ݼ���
		String SQL = "UPDATE WEEKLY_GAME_RANKINGS SET price=? where no=?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, enter_price);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;

	}

	public ArrayList<MemberVO> weekly_updateProcuction_company(int no, String enter_production_company) {// ���ۻ����
		String SQL = "UPDATE WEEKLY_GAME_RANKINGS SET production_company=? where no=?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, enter_production_company);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;

	}

	public ArrayList<MemberVO> weekly_updateDistributor(int no, String enter_distributor) {// ��޻����
		String SQL = "UPDATE WEEKLY_GAME_RANKINGS SET distributor=? where no=?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, enter_distributor);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;

	}

	public ArrayList<MemberVO> weekly_updateGenre(int no, String enter_genre) {// �帣����
		String SQL = "UPDATE WEEKLY_GAME_RANKINGS SET genre=? where no=?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, enter_genre);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;

	}

	public ArrayList<MemberVO> weekly_updateRelease_date(int no, String enter_release_date) {// ������ڼ���
		String SQL = "UPDATE WEEKLY_GAME_RANKINGS SET release_date=? where no=?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, enter_release_date);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;

	}

	public ArrayList<MemberVO> weekly_updatePlatform(int no, String enter_platform) {// �÷�������
		String SQL = "UPDATE WEEKLY_GAME_RANKINGS SET platform=? where no=?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, enter_platform);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;

	}

}

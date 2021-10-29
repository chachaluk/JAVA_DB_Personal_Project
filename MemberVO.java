package dto;//DB에서 받아온 데이터들을 매핑(변환)하기 위한 객체

public class MemberVO {//정보 저장을 위한 클래스, 데이터베이스의 table과 연결됨

	private int no;
	private String name;
	private String price;
	private String production_company;
	private String distributor;
	private String genre;
	private String release_date;
	private String platform;
	
	public MemberVO(int no, String name, String price, String production_company,
			 String distributor, String genre, String release_date, String platform) {
		this.no=no;
		this.name=name;
		this.price=price;
		this.production_company=production_company;
		this.distributor=distributor;
		this.genre=genre;
		this.release_date=release_date;
		this.platform=platform;
	}
	
	public void setNO(int no) {
		this.no=no;
	}
	public int getNO() {
		return no;
	}
	public void setNAME(String name) {
		this.name=name;
	}
	public String getNAME() {
		return name;
	}
	public void setPRICE(String price) {
		this.price=price;
	}
	public String getPRICE() {
		return price;
	}
	public void setPRODUCTION_COMPANY(String production_company) {
		this.production_company=production_company;
	}
	public String getsetPRODUCTION_COMPANY() {
		return production_company;
	}
	public void setDISTRIBUTOR(String distributor) {
		this.distributor=distributor;
	}
	public String getDISTRIBUTOR() {
		return distributor;
	}
	public void setGENRE(String genre) {
		this.genre=genre;
	}
	public String getGENRE() {
		return genre;
	}
	public void setRELEASE_DATE(String release_date) {
		this.release_date=release_date;
	}
	public String getRELEASE_DATE() {
		return release_date;
	}
	public void setPLATFORME(String platform) {
		this.platform=platform;
	}
	public String getPLATFORME() {
		return platform;
	}
	
	
}

package kr.or.ddit.user.model;

import java.sql.Date; //얘로 받으면 날짜만 나오고 다른객체로 받으면 kst~한국시간 어쩌구 나옴

public class UserVO {
	private String name;
	private String userId;
	private String alias;
	private String pass;
	private String addr1;
	private String addr2;
	private String zipcd;
	private Date birth;
	private String path;
	private String filename;
	
	//기본 생성자
	public UserVO() {
		
	}
	
	//인자가 있는 기본 생성자
	public UserVO(String name, String userId, String alias, String pass, String addr1, String addr2, String zipcd,
			Date birth, String path, String filename) {
		super();
		this.name = name;
		this.userId = userId;
		this.alias = alias;
		this.pass = pass;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcd = zipcd;
		this.birth = birth;
		this.path = path;
		this.filename = filename;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getAddr1() {
		return addr1;
	}


	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}


	public String getAddr2() {
		return addr2;
	}


	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}


	public String getZipcd() {
		return zipcd;
	}


	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}


	public Date getBirth() {
		return birth;
	}


	public void setBirth(Date birth) {
		this.birth = birth;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	@Override
	public String toString() {
		return "UserVO [name=" + name + ", userId=" + userId + ", alias=" + alias + ", pass=" + pass + ", addr1="
				+ addr1 + ", addr2=" + addr2 + ", zipcd=" + zipcd + ", birth=" + birth + ", path=" + path
				+ ", filename=" + filename + "]";
	}
	
}

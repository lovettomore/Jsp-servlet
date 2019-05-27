package kr.or.ddit.user.model;

public class UserVO {
	private String name;
	private String userId;
	private String alias;
	
	//인자가 있는 기본 생성자
	public UserVO(String name, String userId, String alias) {
		super();
		this.name = name;
		this.userId = userId;
		this.alias = alias;
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
	
	@Override
	public String toString() {
		return "UserVO [name=" + name + ", userId=" + userId + ", alias=" + alias + "]";
	}
	
	
}

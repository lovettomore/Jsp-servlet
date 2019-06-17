package kr.or.ddit.model;

public class DBVO {
	private String uri;
	private String classname;
	
	public DBVO() {
		
	}
	
	public DBVO(String uri, String classname) {
		super();
		this.uri = uri;
		this.classname = classname;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	@Override
	public String toString() {
		return "DBVO [uri=" + uri + ", classname=" + classname + "]";
	}
	
	
}

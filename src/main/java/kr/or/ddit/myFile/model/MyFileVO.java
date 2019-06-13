package kr.or.ddit.myFile.model;

public class MyFileVO {
	
	private int file_seq;				//파일아이디
	private String file_bd_code;		//파일분류	
	private String file_original_name;	//파일이름 
	private String file_server_name;	//파일서버이름
	private String file_size;			//파일사이즈
	
	
	public MyFileVO() {

	}
	
	public MyFileVO(int file_seq, String file_bd_code, String file_original_name, String file_server_name,
			String file_size) {
		super();
		this.file_seq = file_seq;
		this.file_bd_code = file_bd_code;
		this.file_original_name = file_original_name;
		this.file_server_name = file_server_name;
		this.file_size = file_size;
	}
	
	public MyFileVO(String file_bd_code) {
		this.file_bd_code = file_bd_code;
	}

	public int getFile_seq() {
		return file_seq;
	}
	public void setFile_seq(int file_seq) {
		this.file_seq = file_seq;
	}
	public String getFile_bd_code() {
		return file_bd_code;
	}
	public void setFile_bd_code(String file_bd_code) {
		this.file_bd_code = file_bd_code;
	}
	public String getFile_original_name() {
		return file_original_name;
	}
	public void setFile_original_name(String file_original_name) {
		this.file_original_name = file_original_name;
	}
	public String getFile_server_name() {
		return file_server_name;
	}
	public void setFile_server_name(String file_server_name) {
		this.file_server_name = file_server_name;
	}
	public String getFile_size() {
		return file_size;
	}
	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}

	@Override
	public String toString() {
		return "MyFileVO [file_seq=" + file_seq + ", file_bd_code=" + file_bd_code + ", file_original_name="
				+ file_original_name + ", file_server_name=" + file_server_name + ", file_size=" + file_size + "]";
	}
	
	

}

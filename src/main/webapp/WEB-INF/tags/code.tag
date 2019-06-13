<%@tag import="kr.or.ddit.myFile.model.MyFileVO"%>
<%@tag import="java.util.List"%>
<%@tag import="kr.or.ddit.myFile.service.MyFileService"%>
<%@tag import="kr.or.ddit.myFile.service.IMyFileService"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="code" required="true"%>

<%-- <%@tag import="java.sql.DriverManager"%> --%>
<%-- <%@tag import="java.sql.ResultSet"%> --%>
<%-- <%@tag import="javax.naming.spi.DirStateFactory.Result"%> --%>
<%-- <%@tag import="java.sql.PreparedStatement"%> --%>
<%-- <%@tag import="java.sql.Connection"%> --%>

<%--
	
	String code = (String)jspContext.getAttribute("code");	

	final String driver = "oracle.jdbc.driver.OracleDriver";
	final String url = "jdbc:oracle:thin:@112.220.114.130:1521:xe";
	final String username = "MDMS";
	final String password = "java";
	
	Connection conn = null;
	PreparedStatement sp = null;
	ResultSet rs = null;
	
	
	try{
		
		Class.forName(driver);
		conn = DriverManager.getConnection(url, username, password);
		sp = conn.prepareStatement("SELECT FILE_SEQ, FILE_ORIGINAL_NAME FROM MYFILE WHERE FILE_BD_CODE = ?");
		sp.setString(1, code);
		
		rs = sp.executeQuery();
		
		out.write("<select>");
		while(rs.next()){
			out.write("<option id=" + rs.getString("FILE_SEQ") + ">" + rs.getString("FILE_ORIGINAL_NAME") + "</option>");
		}
		out.write("</select>");
		
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}

--%>

<%

	
	IMyFileService myFileService = new MyFileService();

	String code = (String)jspContext.getAttribute("code");
	List<MyFileVO> myFile = myFileService.myFile(code);
	
	//request.setAttribute("myFile", myFile);
	jspContext.setAttribute("myFile", myFile);
%>

<select>
	<c:forEach items="${myFile}" var="myFile">
		<option>${myFile.file_original_name}</option>
	</c:forEach>
</select>


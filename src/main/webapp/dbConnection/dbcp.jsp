<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
	
//DB작업에 필요한 객체변수 선언

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			BasicDataSource bs = new BasicDataSource();
			bs.setUrl("jdbc:oracle:thin:@112.220.114.130:1521:xe");
			bs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			bs.setUsername("MDMS");
			bs.setPassword("java");
			bs.setInitialSize(20); //초기값 설정
			
			// 2. 접속 ==> Connection객체 생성
			long startTime = System.currentTimeMillis();
			for(int i=0; i<20; i++){
				conn = bs.getConnection(); //connection을 얻고
				conn.close(); //connection을 반환 해줘용
			}
			long endTime = System.currentTimeMillis();
			System.out.println("duration : " + (endTime - startTime));
			
			bs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 사용했던 자원들을 모두 반납한다.
			if(rs!=null) try{ rs.close(); }catch(SQLException e){}
			if(stmt!=null) try{ stmt.close(); }catch(SQLException e){}
			if(conn!=null) try{ conn.close(); }catch(SQLException e){}
		}
		
		//catch (ClassNotFoundException e) { //얘는 왜 에러냐면 class.forname에서 던지는 예외라서 얘는 인쟈 필요 없어옹 
		//	e.printStackTrace();
		//} 

%>
package kr.or.ddit.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		//리소스 위치
		String resource = "kr/or/ddit/config/mybatis/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			//SqlSession sqlSession = sqlSessionFactory.openSession(); 얘를 상단에서 static으로 선언
			//sqlSession 객체를 리턴해주는 작업을 할꼽니당.
			//sqlSession.insert(arg0);
			//sqlSession.delete(arg0);
			//sqlSession.update(arg0);
			//sqlSession.selectList(arg0);
			//sqlSession.selectOne(arg0); //하나만 검색할때 편하겠죠?
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

}

package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.model.DBVO;
import kr.or.ddit.mybatis.MyBatisUtil;

public class DBDao implements IDBDao {

	@Override
	public List<DBVO> dbList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<DBVO> dbList = sqlSession.selectList("db.dbList");
		sqlSession.close();
		return dbList;
	}

}

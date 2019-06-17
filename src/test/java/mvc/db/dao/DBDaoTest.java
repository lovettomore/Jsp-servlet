package mvc.db.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.dao.DBDao;
import kr.or.ddit.dao.IDBDao;
import kr.or.ddit.model.DBVO;

public class DBDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(DBDaoTest.class);
	private IDBDao dbDao;
	
	@Before
	public void setup() {
		dbDao = new DBDao();
	}
	
	
	@Test
	public void dbListTest() {
		/***Given***/
		
		/***When***/
		List<DBVO> dbList = dbDao.dbList();

		/***Then***/
		assertEquals("/main.do", dbList.get(0).getUri());
		logger.debug("dbList", dbList);
	}

}

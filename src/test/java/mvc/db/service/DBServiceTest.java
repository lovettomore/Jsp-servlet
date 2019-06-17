package mvc.db.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.model.DBVO;
import kr.or.ddit.service.DBService;
import kr.or.ddit.service.IDBService;

public class DBServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(DBServiceTest.class);

	private IDBService dbService;
	
	@Before
	public void setup() {
		dbService = new DBService();
		logger.debug("@setup");
	}
	
	@Test
	public void dbListTest() {
		/***Given***/
		
		/***When***/
		List<DBVO> dbList = dbService.dbList();

		/***Then***/
		assertEquals("/main.do", dbList.get(0).getUri());
		logger.debug("dbList", dbList);
	}

}

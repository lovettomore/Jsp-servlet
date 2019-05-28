package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.myFile.dao.IMyFileDao;
import kr.or.ddit.myFile.dao.MyFileDao;
import kr.or.ddit.myFile.model.MyFileVO;
import kr.or.ddit.paging.model.PageVO;

public class MyFileDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MyFileDaoTest.class);
	
	private IMyFileDao myFileDao;
	
	@Before
	public void setup() {
		myFileDao = new MyFileDao();
	}
	
	@Test
	public void myFileListTest() {
		/***Given***/
		
		/***When***/
		List<MyFileVO> myFileList = myFileDao.myFileList();
		
		/***Then***/
		assertEquals(33, myFileList.size());
		logger.debug("myFileList : {}", myFileList);
	}
	
	@Test
	public void myFilePasingListTest() {
		//반환값과 인자값은 반드시 없어야 한다.
		/***Given***/
		PageVO pageVO = new PageVO(1, 5);
		/***When***/
		List<MyFileVO> myFileList = myFileDao.myFilePasingList(pageVO);

		/***Then***/
		assertNotNull(myFileList);
		assertEquals(5, myFileList.size());
		logger.debug("myFileList : {}", myFileList);
	}
	
	@Test
	public void myFileCntTest() {
		/***Given***/
		
		/***When***/
		int myFileCnt = myFileDao.myFileCnt();
		
		/***Then***/
		assertEquals(33, myFileCnt);
	}
	
	
}

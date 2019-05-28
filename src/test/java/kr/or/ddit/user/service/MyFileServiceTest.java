package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.myFile.model.MyFileVO;
import kr.or.ddit.myFile.service.IMyFileService;
import kr.or.ddit.myFile.service.MyFileService;
import kr.or.ddit.paging.model.PageVO;

public class MyFileServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MyFileServiceTest.class);
	
	IMyFileService myFileService;
	
	@Before
	public void setup() {
		myFileService = new MyFileService();
		logger.debug("@setup");
	}
	
	@Test
	public void myFileListTest() {
		/***Given***/
		
		/***When***/
		List<MyFileVO> myFileList = myFileService.myFileList();
		
		/***Then***/
		assertNotNull(myFileList);
		assertEquals(33, myFileList.size());
		logger.debug("myFileList : {}", myFileList);
	}
	
	@Test
	public void myFilePasingListTest() {
		/***Given***/
		PageVO pageVO = new PageVO(1, 5);
		
		/***When***/
		Map<String, Object> resultMap = myFileService.myFilePasingList(pageVO);
		List<MyFileVO> myFileList = (List<MyFileVO>)resultMap.get("myFileList");
		int paginationSize = (int) resultMap.get("paginationSize");
		
		/***Then***/
		assertNotNull(myFileList);
		assertEquals(5, myFileList.size());
		assertEquals(7, paginationSize);
		
	}
	
	@Test
	public void ceilTest() {
		
		/***Given***/
		int myFileCnt = 33;
		int pageSize = 5;
		
		/***When***/
		double paginationSize = Math.ceil(((double)myFileCnt/pageSize));
		logger.debug("paginationSize : {}", paginationSize);

		/***Then***/
		assertEquals(7, (int)paginationSize);
		
	}
	
}

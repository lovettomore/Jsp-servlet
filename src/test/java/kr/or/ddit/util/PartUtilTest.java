package kr.or.ddit.util;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartUtilTest {
	
	private static final Logger logger = LoggerFactory.getLogger(PartUtilTest.class);
	
	@Test
	public void getFileNameTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"profile\"; filename=\"sally.png\"";
		
		/***When***/
		String fileName = PartUtil.getFileName(contentDisposition);

		/***Then***/
		assertEquals("sally.png", fileName);
	}
	
	@Test
	public void uuidTest(){
		/***Given***/
		
		/***When***/
		logger.debug(UUID.randomUUID().toString());

		/***Then***/
	}
	
	@Test
	public void getExtTest() {
		/***Given***/
		String fileName= "brown.png";
		String fileName2 = "brown.picture.png";
		String fileName3 = "brown";
		
		/***When***/
		String ext = PartUtil.geExt(fileName);
		String ext2 = PartUtil.geExt(fileName2);
		String ext3 = PartUtil.geExt(fileName3);
		
		/***Then***/
		assertEquals("png", ext);
		assertEquals("png", ext2);
		assertEquals("", ext3);
	}
	
	@Test
	public void substring() {
		/***Given***/
		String yyyyMM = "201906";
		
		/***When***/
		//String type으로 형변환
		String yyyy = yyyyMM.substring(0,4);
		String mm = yyyyMM.substring(4,6);

		/***Then***/
		assertEquals("2019", yyyy);
		assertEquals("06", mm);
	}

}

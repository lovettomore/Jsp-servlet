package kr.or.ddit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(PartUtil.class);
	/**
	 * 
	* Method 		: getFileName
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param contentDisposition
	* Method 설명 	:
	 * @return 
	 */
	public static String getFileName(String contentDisposition) {
		
		String[] split = contentDisposition.split("; ");
		String subString = "";
		for (String word : split) {
			if(word.startsWith("filename")) {
				subString = word.substring(word.indexOf("\"")+1,word.lastIndexOf("\""));
			}
		}
		return subString;
	}
	
	public static String geExt(String fileName) {
		
		String[] split = fileName.split("\\.");
		String subString = "";
		
		if(split.length == 1) return "";
		else return split [split.length -1];
	}

}

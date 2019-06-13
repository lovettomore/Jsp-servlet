package kr.or.ddit.myFile.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.myFile.model.MyFileVO;
import kr.or.ddit.paging.model.PageVO;

public interface IMyFileService {
	
	/**
	 * 
	* Method 		: myFileList
	* 작성자 			: chewoop
	* 변경이력 		:
	* @return
	* Method 설명 	: 파일 전체 조회
	 */
	List<MyFileVO> myFileList();
	
	/**
	 * 
	* Method 		: myFilePasingList
	* 작성자 			: chewoop
	* 변경이력 		:
	* @return
	* Method 설명 	: 파일 페이징 리스트 조회
	 */
	Map<String, Object> myFilePasingList(PageVO pageVO);
	
	/**
	 * 
	* Method 		: myFile
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param file_bd_code
	* @return
	* Method 설명 	: 파일 코드로 파일리스트 조회
	 */
	List<MyFileVO> myFile(String file_bd_code);
	
	
}

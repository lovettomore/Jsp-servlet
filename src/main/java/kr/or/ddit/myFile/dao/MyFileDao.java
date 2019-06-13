package kr.or.ddit.myFile.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.myFile.model.MyFileVO;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;

public class MyFileDao implements IMyFileDao{

	private static final Logger logger = LoggerFactory.getLogger(MyFileDao.class);
	
	public static void main(String[] args) {
		
		/***Given***/
		IMyFileDao myFileDao = new MyFileDao();
		
		/***When***/
		List<MyFileVO> myFileList = myFileDao.myFileList();

		/***Then***/
		logger.debug("myFileList : {}", myFileList);
	}
	
	/**
	 * 
	* Method 		: myFileList
	* 작성자 			: chewoop
	* 변경이력 		:
	* @return
	* Method 설명 	: 파일 전체 리스트 조회
	 */
	@Override
	public List<MyFileVO> myFileList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<MyFileVO> myFileList = sqlSession.selectList("myFile.myFileList");
		sqlSession.close();
		return myFileList;
	}
	
	/**
	 * 
	* Method 		: myFilePasingList
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param pageVO
	* @return
	* Method 설명 	: 파일 페이징 리스트 조회
	 */
	@Override
	public List<MyFileVO> myFilePasingList(PageVO pageVO) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<MyFileVO> myFileList = sqlSession.selectList("myFile.myFilePasingList", pageVO);
		sqlSession.close();
		return myFileList;
	}
	
	/**
	 * 
	* Method 		: myFileCnt
	* 작성자 			: chewoop
	* 변경이력 		:
	* @return
	* Method 설명 	: 파일 전체 건수 조회
	 */
	@Override
	public int myFileCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int myFileCnt = (Integer)sqlSession.selectOne("myFile.myFileCnt");
		sqlSession.close();
		return myFileCnt;
	}
	
	
	/**
	 * 
	* Method 		: myFile
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param file_bd_code
	* @return
	* Method 설명 	: 파일 코드로 파일리스트 조회
	 */
	@Override
	public List<MyFileVO> myFile(String file_bd_code) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<MyFileVO> myFile = sqlSession.selectList("myFile.myFile", file_bd_code);
		sqlSession.close();
		return myFile;
	}

}

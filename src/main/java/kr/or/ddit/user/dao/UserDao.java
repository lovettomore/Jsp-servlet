package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;

public class UserDao implements IUserDao{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
	//SqlSession sqlSession = MyBatisUtil.getSqlSession(); 얘를 위에다 선언을 하면은 재활용이 안되요. 쓰고나서 버리는 개념이에요. 일 회 용
	
	public static void main(String[] args) {
		
		/***Given***/
		IUserDao userDao = new UserDao();
		
		/***When***/
		List<UserVO> userList =  userDao.userList();
		
		/***Then***/
		logger.debug("userList : {}", userList);
		
		
		
		/***Given***/
		String userId = "sally";
		
		/***When***/
		UserVO userVO = userDao.getUser(userId);
		
		/***Then***/
		logger.debug("userUser : {}", userVO);
		
	}

	
	/**
	 * 
	* Method 		: userList
	* 작성자 			: chewoop
	* 변경이력 		:
	* @return
	* Method 설명 	: 사용자 전체 조회
	 */
	@Override
	public List<UserVO> userList() {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UserVO> userList = sqlSession.selectList("user.userList");
		sqlSession.close();
		return userList;
	}

	
	/**
	 * 
	* Method 		: getUser
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param userId
	* @return
	* Method 설명 	: 사용자 정보 조회
	 */
	@Override
	public UserVO getUser(String userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserVO userVO = sqlSession.selectOne("user.userInfo", userId);
		sqlSession.close();
		return userVO;
	}


	/**
	 * 
	* Method 		: userPagingList
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param 		: pageVO
	* @return		: 
	* Method 설명 	: 사용자 페이징 리스트 조회
	 */
	@Override
	public List<UserVO> userPagingList(PageVO pageVO) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UserVO> userPagingList = sqlSession.selectList("user.userPagingList", pageVO);
		sqlSession.close();
		return userPagingList;
	}

	/**
	 * 
	* Method 		: usersCnt
	* 작성자 			: chewoop
	* 변경이력 		:
	* @return
	* Method 설명 	: 사용자 전체 건수 조회
	 */
	@Override
	public int usersCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int usersCnt = (Integer)sqlSession.selectOne("user.usersCnt");
		sqlSession.close();
		return usersCnt;
	}

	
	/**
	 * 
	* Method 		: insertUser
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param userVO
	* @return
	* Method 설명 	: 사용자 등록
	 */
	@Override
	public int insertUser(UserVO userVO) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int result = sqlSession.insert("user.insertUser", userVO);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	/**
	 * 
	* Method 		: deleteUser
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param userId
	* @return
	* Method 설명 	: 사용자 삭제
	 */
	@Override
	public int deleteUser(String userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int result = sqlSession.delete("user.deleteUser", userId);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}


	/**
	 * 
	* Method 		: updateUser
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param userVO
	* @return
	* Method 설명 	: 사용자 수정
	 */
	@Override
	public int updateUser(UserVO userVO) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int updateCnt = sqlSession.update("user.updateUser", userVO);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

}






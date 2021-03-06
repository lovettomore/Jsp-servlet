package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;

public interface IUserDao {
	
	/**
	 * 
	* Method 		: userList
	* 작성자 			: chewoop
	* 변경이력 		:
	* @return
	* Method 설명 	: 사용자 전체 조회
	*/
	List<UserVO> userList();
	
	/**
	 * 
	* Method 		: getUser
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param userId
	* @return
	* Method 설명 	: 사용자 정보 조회
	 */
	UserVO getUser(String userId);
	
	/**
	 * 
	* Method 		: userPagingList
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param pageVO
	* @return
	* Method 설명 	: 사용자 페이징 리스트 조회
	 */
	List<UserVO> userPagingList(PageVO pageVO);
	
	/**
	 * 
	* Method 		: usersCnt
	* 작성자 			: chewoop
	* 변경이력 		:
	* @return
	* Method 설명 	: 사용자 전체 건수 조회
	 */
	int usersCnt();
	
	/**
	 * 
	* Method 		: insertUser
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param userVO
	* @return
	* Method 설명 	: 사용자 등록
	 */
	int insertUser(UserVO userVO);
	
	
	/**
	 * 
	* Method 		: deleteUser
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param userId
	* @return
	* Method 설명 	: 사용자 삭제
	 */
	int deleteUser(String userId);
	
	
	/**
	 * 
	* Method 		: updateUser
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param userVO
	* @return
	* Method 설명 	: 사용자 수정
	 */
	int updateUser(UserVO userVO);

	/**
	 * 
	* Method 		: userListForPassEncrypt
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param sqlSession
	* @return
	* Method 설명 	: 비밀번호 암호화 적용대상 사용자 전체 조회
	 */
	List<UserVO> userListForPassEncrypt(SqlSession sqlSession);
	
}

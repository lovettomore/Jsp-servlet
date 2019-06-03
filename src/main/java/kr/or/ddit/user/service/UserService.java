package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVO;

public class UserService implements IUserService {

	IUserDao userDao = new UserDao();
	
	/**
	 * 
	* Method 		: userList
	* 작성자 			: chewoop
	* 변경이력 		:
	* @return
	* Method 설명 	: 사용자 전체 리스트 조회
	 */
	@Override
	public List<UserVO> userList() {
		
		//db에서 데이터를 조회했다고 가정 해볼게요.
		List<UserVO> userList = new ArrayList<UserVO>();
		userList = userDao.userList();
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
		
		UserVO vo = null;
		vo = userDao.getUser(userId);
		return vo;
	}
	
	/**
	 * 
	* Method 		: userPagingList
	* 작성자 			: chewoop
	* 변경이력 		:
	* @param pageVO
	* @return
	* Method 설명 	: 사용자 페이징 리스트 조회
	 */
	@Override
	public Map<String, Object> userPagingList(PageVO pageVO) {
		/*
			하나의 메소드에서 두개를 리턴해야되요. 두개의 값을 동시에 넣을 수 있는 객체가 필요해요
			------------------------------------------------------------------
			1. List<UserVO>, userCnt를 필드로 하는 vo
			2. List<Object> resultList = new ArrayList<Object>();
			   resultList.add(userList);
			   resultList.add(userCnt);
			3. Map<String, Object> resultMap = new HashMap<String, Object>();
			   resultMap.put("userList", userList);
			   resultMap.put("userCnt", userCnt);
			   
			------------------------------------------------------------------
			저는 3번째 방법을 추천 드려용 옛썰!
		*/
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userDao.userPagingList(pageVO));
		
		//usersCnt > paginationSize 으로 변경
		int userCnt = userDao.usersCnt();
		
		//pageSize > pageVO.getPageSize();
		int paginationSize = (int)Math.ceil((double)userCnt/pageVO.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
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
	public int insertUser(UserVO userVO) {
		int insertCnt = 0;
		insertCnt = userDao.insertUser(userVO);
		return insertCnt;
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
	public int deleteUser(String userId) {
		int deleteCnt = 0;
		deleteCnt = userDao.deleteUser(userId);
		return deleteCnt;
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
		int updateCnt = 0;
		updateCnt = userDao.updateUser(userVO);
		return updateCnt;
	}


}

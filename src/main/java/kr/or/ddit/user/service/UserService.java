package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.List;

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
	public List<UserVO> userPagingList(PageVO pageVO) {
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
		*/
		List<UserVO> userList = userDao.userPagingList(pageVO);
		int usersCnt = userDao.usersCnt();
		return null;
	}


}

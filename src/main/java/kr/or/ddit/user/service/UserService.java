package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVO;

public class UserService implements IUserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

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
	
	/**
	 * 
	* Method 		: encryptPassAllUser
	* 작성자 			: chewoop
	* 변경이력 		:
	* @return
	* Method 설명 	: 사용자 비밀번호 암호화 일괄 적용 배치
	 */
	
	@Override
	/********************** 사용 하지 마세요. 이미 암호화 적용 되어 있어용 *************************/
	
	public int encryptPassAllUser() { //얘는 클래스를 따로 빼거나 프로젝트를 만들어서 해야되요. 이런거를 실행할 일이 거의 없죠.
		//1. sql 실행에 필요한 sqlSession 객체를 생성
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		//2. 모든 사용자 정보를 조회 (단, 기존 암호화 적용 사용자 제외, brown, lazysunday 제외)
		List<UserVO> userList = userDao.userListForPassEncrypt(sqlSession);
		
		//3. 조회된 사요자의 비밀번호를 암호화 적용후 사용자 업데이트
		int updateCntSum = 0;
		for(UserVO userVO : userList) {
			String encryptPass = KISA_SHA256.encrypt(userVO.getPass());
			userVO.setPass(encryptPass);
			
			int updateCnt = UserDao.updateUserEncryptPass(sqlSession, userVO); //얘가 사용자 비밀번호를 업데이트 해줄거에요
			updateCntSum += updateCnt; //누적된 결과를 더해줌. 몇건이나 처리 했는지 알려고ㅋㅋ
			
			//얘는 비정상
			if(updateCnt != 1){
				sqlSession.rollback();
				break;
			}
		}
		
		//4. sqlSession 객체를 commit, close
		sqlSession.commit();
		sqlSession.close();
		
		return updateCntSum; //몇번이나 리턴했는지 합을 보려고
	}
	
	public static void main(String[] args) {
		IUserService userService = new UserService();
		int updateCnt = userService.encryptPassAllUser();
		logger.debug("updateCnt : {}", updateCnt);
	}


}

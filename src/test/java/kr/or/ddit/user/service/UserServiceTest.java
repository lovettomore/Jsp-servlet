package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;

public class UserServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	private IUserService userService;
	
	@Before
	public void setup() {
		userService = new UserService();
		logger.debug("@setup");
	}
	
	@Test
	public void userListTest() {
		
		/***Given***/

		
		/***When***/
		List<UserVO> userList = userService.userList();

		/***Then***/
		assertEquals("토깽잉", userList.get(0).getAlias());
		assertEquals(105, userList.size());
		logger.debug("userList : {}", userList);
		
	}
	
	@Test
	public void getUserTest() {
		
		/***Given***/
		String userId = "james";
		
		/***When***/
		UserVO userVO = userService.getUser(userId);

		/***Then***/
		assertNotNull(userVO); //not null check
		assertEquals("james", userVO.getUserId());
		logger.debug("userVO : {}", userVO);
	}
	
	
	@Test
	public void userPagingListTest() {
		/***Given***/ //주어진 환경을 이야기 하는거지용?
		PageVO pageVO = new PageVO(1, 10);
		
		/***When***/
		Map<String, Object> resultMap = userService.userPagingList(pageVO);
		List<UserVO> userList = (List<UserVO>) resultMap.get("userList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		/***Then***/
		
		/* pagingList assert */
		assertNotNull(userList);
		assertEquals(10, userList.size());
		
		/* usersCnt assert */
		assertEquals(11, paginationSize);
		
	}
	
	@Test
	public void ceilTset() {
		/***Given***/
		int usersCnt = 105;
		int pageSize = 10;
		
		/***When***/
		double paginationSize = Math.ceil((double)usersCnt/pageSize);
		logger.debug("paginationSize : {}", paginationSize);
		
		/***Then***/
		assertEquals(11, (int)paginationSize);
	}
	
	/**
	 * 
	* Method 		: insertUserTest
	* 작성자 			: chewoop
	* 변경이력 		:
	* Method 설명 	: 사용자 등록 테스트
	 * @throws ParseException 
	 */
	@Test
	public void insertUserTest() throws ParseException {
		/***Given***/
		//사용자 정보를 담고있는 vo객체 준비
		
		SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
		UserVO userVO = new UserVO("user1011", "user", "사용자101", "user1011234", "주소1", "주소2", "34523", spf.parse("2019-05-03"));
		
		/***When***/
		//userDao.insertUser() 를 실행
		int insertCnt = userService.insertUser(userVO);

		/***Then***/
		//inserCnt(1) 이면 성공
		assertEquals(1, insertCnt);
		
		userService.deleteUser(userVO.getUserId());
	}
	
	@Test
	public void updateUserTest() throws ParseException {
		/***Given***/
		SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
		UserVO userVO = new UserVO("user1011", "user", "나는사용자", "user1011234", "대전 서구 탄방동", "탄방역 243-24", "23423", spf.parse("2019-05-24"));
		
		/***When***/
		int updateCnt = userService.updateUser(userVO);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	

}

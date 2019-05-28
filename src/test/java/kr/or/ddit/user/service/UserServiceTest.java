package kr.or.ddit.user.service;

import static org.junit.Assert.*;

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
	
	

}

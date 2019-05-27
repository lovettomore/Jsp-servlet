package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;

public class UserDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	private IUserDao userDao;
	
	/*	
	 	junit 실행 순서
		
		@BeaforeClass가 적용된 메소드가 1회 실행
	
		@Beafore가 적용된 메소드 실행
		@Test가 적용된 메소드 실행
		@After가 적용된 메소드 실행
	
		@AfterClass가 적용된 메소드 1회 실행 
	*/
	
	@BeforeClass
	public static void beforeClass() {
		//이 메소드에서 뭔가 사용을 할려면 멤버도 스테틱이여야 가능 합니다. 그래서 비포클래스와 에프터 클래스의 사용빈도가 떨어집니당.
		logger.debug("@beforeClass");
	}
	@Before
	public void setup() {
		userDao = new UserDao();
		logger.debug("@setup");
	}
	@After
	public void teardown() {
		logger.debug("@teardown");
	}
	@AfterClass
	public static void afterClass() {
		logger.debug("@afterClass");
	}
	
	//test method 우리 눈에는 보이지 않지만 runAs가 있어용
	//테스트가 정상정으로 실행되면 jUnit 탭에 녹색 체크 표시가 떠용. 참잘했어용
	//다른 테스트 프레임워크에서는 테스트 조건을 걸어줄 수 있는 메서드 들이 있어요. 그게바로 assertEquals
	/**
	 * 
	* Method 		: userListTest
	* 작성자 			: chewoop
	* 변경이력 		: 없음
	* Method 설명 	: 사용자 전체 조회 테스트
	 */
	@Test
	public void userListTest() {
		
		/***Given***/

		
		/***When***/
		List<UserVO> userList = userDao.userList();

		/***Then***/
		
		//이게 뭐냐면요 메소드인데요 이녀석은 정의를 한적이 없자나요. f3눌러서 따라가보면은
		//static이거든용? 클래스명.assert해야대자나여? assertEquals를 너무너무 마니 써야대여 그래서 
		//import static org.junit.Assert.*; 얘를 이렇게 선언해주는거에여 그래서 클래스 명없이도 static메서드를 사용할 쑤 있어여 
		//기대값을 4로 바꾸면 x가 뜨죵?  assert구문을 통과를 못한거게용

		assertEquals("cony", userList.get(0).getUserId());
		assertEquals(105, userList.size()); //기대값, 실제값
		logger.debug("userList : {}", userList);
		
	}
	
	@Test
	public void getUserTest() {
		
		/***Given***/
		String userId = "sally";
		
		/***When***/
		UserVO userVO = userDao.getUser(userId);
		
		/***Then***/
		assertEquals("샐리",userVO.getName());
		logger.debug("userVO : {}", userVO);
	}
	
	/*
		사용자 페이징 리스트 조회
		- 고려사항
			1. 몇번째 페이지 조회인지?, 페이징마다 몇건씩 데이터를 보여줄건지 (쿼리 실행 파라미터와 관련)
			2. 정렬에대한 순서가 필요해요. (얘도 파라미터화를 시킬 수 있어요) > 우리는 사용자 아이디 순으로 정렬
		
	*/
	
	//반환값과 인자값이 반드시 없어야 합니당. 규칙이에옹
	/**
	 * 
	* Method 		: userPagingListTest
	* 작성자 			: chewoop
	* 변경이력 		: 
	* Method 설명 	: 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void userPagingListTest() {
		/***Given***/ //주어진 환경을 이야기 하는거지용?
		PageVO pageVO = new PageVO(1, 10);
		
		/***When***/
		List<UserVO> userList = userDao.userPagingList(pageVO);

		/***Then***/
		assertNotNull(userList);
		assertEquals(10, userList.size());
		logger.debug("pageVO : {}", userList);
		
	}
	
	/**
	 * 
	* Method 		: usersCntTest
	* 작성자 			: chewoop
	* 변경이력 		:
	* Method 설명 	: 사용자 전체 건수 조회 테스트
	 */
	@Test
	public void usersCntTest() {
		/***Given***/
		
		/***When***/
		int usersCnt = userDao.usersCnt();
		/***Then***/
		assertEquals(105, usersCnt);
	}

}

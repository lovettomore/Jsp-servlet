Jsp-servlet
===========

![Alt text](https://img.shields.io/github/forks/lovettomore/Jsp-servlet.svg?style=popout&color=brightgreen)
![Alt text](https://img.shields.io/github/stars/lovettomore/Jsp-servlet.svg?style=popout&color=red)
![Alt text](https://img.shields.io/badge/hello-lovettomore-ff69b4.svg)




>Jsp-servlet Class [또굥이의 jsp-servlet]

<br>

:vertical_traffic_light:jsp(java server page)란?
<pre> Java 코드가 들어가 있는 HTML 코드</pre>

서블릿은 **자바 소스코드 속에 HTML코드가 들어가는 형태**인데, JSP는 이와 반대로 HTML 소스코드 속에 자바 소스코드가 
들어가는 구조를 갖는 웹어플리케이션 프로그래밍 기술입니다. HTML속에서 자바코드는 <% 소스코드 %> 또는 <%= 소스코드 =%>형태로 들어갑니다.
자바 소스코드로 작성된 이 부분은 웹 브라우저로 보내는 것이아니라 웹 서버에서 실행되는 부분입니다. 웹 프로그래머가 소스코드를 수정 할 
경우에도 디자인 부분을 제외하고 자바 소스코드만 수정하면 되기에 효율을 높여줍니다. 또한 컴파일과 같은 과정을 할 필요없이 JSP페이지를 
작성하여웹 서버의 디렉토리에 추가만 하면 사용이 가능합니다. 서블릿 규칙은 꽤나 복집하기 때문에 JSP가 나오게 되었는데 
JSP는 WAS(Web Application Server)에 의하여 서블릿 클래스로 변환하여 사용되어 집니다. 

<br>

* 스크립트 언어이기 때문에 자바 기능을 그대로 사용할 수 있다.
* Tomcat(WAS)이 이미 만들어놓은 객체(predefined values)를 사용한다. (request, response, session 등)
* 사용자 정의 태그(custom tags)를 사용하여, 보다 효율적으로 웹 사이트를 구성할 수 있다.<br>
  (JSTL(JSP Standard Tag Library, JSP 표준 태그 라이브러리)사용)
* HTML 코드 안에 Java 코드가 있기 때문에 HTML 코드를 작성하기 쉽다.
* Servlet과 다르게 JSP는 수정된 경우 재배포할 필요 없이 Tomcat(WAS)이 알아서 처리해준다.
* 미리 정의된 객체로, WAS가 제공하는 객체를 의미한다.
  * request: the HttpServletRequest Object
  * response: the HttpServletResponse Object
  * session: the HttpSession Object
  * out: the PrintWriter Object
  * application: the ServletContext Object
  
<br>

:vertical_traffic_light: Servlet(서블릿)
<pre>
  웹프로그래밍에서 클라이언트의 요청을 처리하고 그 결과를 다시 클라이언트에게
  전송하는 Servlet 클래스의 구현 규칙을 지킨 자바 프로그래밍 기술
</pre>

<br>

간단히 말해서, **서블릿이란 자바를 사용하여 웹을 만들기 위해 필요한 기술**입니다. 그런데 좀더 들어가서 설명하자면 
**클라이언트가 어떠한 요청을 하면 그에 대한 결과를 다시 전송**해주어야 하는데, 이러한 역할을 하는 자바 프로그램입니다. 
예를 들어, 어떠한 사용자가 로그인을 하려고 할 때. 사용자는 아이디와 비밀번호를 입력하고, 로그인 버튼을 누릅니다. 
그때 서버는 클라이언트의 아이디와 비밀번호를 확인하고, 다음 페이지를 띄워주어야 하는데, 이러한 역할을 수행하는 
것이 바로 서블릿(Servlet)입니다. 그래서 서블릿은 자바로 구현 된 *CGI라고 흔히 말합니다.

* 클라이언트의 요청에 대해 동적으로 작동하는 웹 어플리케이션 컴포넌트
* html을 사용하여 요청에 응답한다.
* Java Thread를 이용하여 동작한다.
* MVC 패턴에서 Controller로 이용된다.
* HTTP 프로토콜 서비스를 지원하는 javax.servlet.http.HttpServlet 클래스를 상속받는다. UDP보다 속도가 느리다.
* HTML 변경 시 Servlet을 재컴파일해야 하는 단점이 있다.

<br><br>

> CLASS CONTENTS
  
:whale: 2019.05.20
<pre>
- 자율학습 참고자료 / 학생 학습내용정리 방법 안내
- 개발환경 구축하기
- 서버프로그램 구현하기
- 이클립스 개발환경 설정(주석 템플릿)
- 이클립스 개발환경 설정()
- BasicServlet 클래스 생성, servlet mapping 등록(web.xml)
- BasicServlet 클래스 생성, servlet mapping 등록(web.xml)
- NowDateServlet 클래스 생성 , servlet mapping 등록(web.xml)(학생 실습)
- response content-type
- servlet life cycle timesServlet
- request parameter
- timesServlet request Parameter 적용(학생실습)
- jsp탄생 배경
</pre>

:whale: 2019.05.21
<pre>
- maven 프로젝트, 기본 서블릿 생성 실습(학생실습)git
- git 설치 - git 명령어 (git init, git status, git add, git commit, git remote, git push)
- git 충돌시나리오 (gitTest, gitOther)
- git eclipse plugin 사용 방법
- git eclipse clone logback 설정, 사용방법
- logback 설정, 사용방법 jsp 기본 개념 (page 지시어, 스크립틀릿, 표현식, 주석) jsp timesTables 실습(학생실습)
- jsp timesTables 실습(학생실습) jsp factorial 실습(학생실습)
- jsp 내장객체 (HttpServletRequest)
</pre>

:whale: 2019.05.22
<pre>
- 전시간 복습 - helloWord servlet, helloWorld jsp timesTables.jsp 파라미터 적용(학생실습)
- timesTables.jsp 파라미터 적용 코드 리뷰 request paramter 메소드 확인, login.jsp, loginProcess.jsp, bootstrap login 화면 적용
- bootstrap login 화면 적용
- redirect (response.sendRedirect) dispatch (requestDispatcher.forward(request, response)
- login 프로세스 (redirect, dispatch 적용)
- login 프로세스 (redirect, dispatch 적용) main.jsp bootstrap 적용
- jsp 실행원리 (서블릿 변환과정), url mapping 처리, out, application, application 객체를 통한 어플리케이션 내 자원 접근하기 실습
- application 객체를 통한 어플리케이션 내 자원 접근하기 실습
</pre>

:whale: 2019.05.23
<pre>
- 로그인 프로세스 복습(학생 실습)
- 로그인 프로세스 복습 (학생 실습) - 리뷰, jsp scope객체, 속성, jsp scope객체, 속성 실습
- jsp scope객체, 속성 실습
- 두개의 숫자를 파라미터로 받아 합 계산하여 scope에 저장, 출력 (학생실습)
- 두개의 숫자를 파라미터로 받아 곱 계산하여 scope에 저장, 출력 (학생실습)
- 두개의 숫자를 파라미터로 받아 곱 계산하여 scope에 저장, 출력 (학생실습)
- 사용자 리스트 메뉴 실습
- 사용자 리스트 메뉴 실습
- 로그인 정보 session 저장 실습
- 로그인 정보 session 저장 실습(null 처리)
- 로그아웃 처리 실습
- 세션정보 존재시 로그인 화면을 통한 로그인 방지 처리(메인화면 이동)
- 페이지 모듈화(header, left, commonLib)
</pre>

:whale: 2019.05.24
<pre>
- 사용자 리스트 조회 mvc 복습(학생 실습)
- 사용자 리스트 조회 mvc 복습(학생 실습) 사용자 리스트 조회 mvc 반복
- 사용자 페이지 리스트 조회 쿼리 작성 사용자 페이지 리스트 조회 로직, 테스트 코드 작성(service, dao)
- 사용자 페이지 리스트 컨트롤러 로직 작성(테스트 코드 X)
- page, pageSize 파라미터가 없을경우 default value 처리 (page = 1, pageSize = 10)
- page, pageSize 파라미터가 없을경우 default value 처리 (page = 1, pageSize = 10) 
- pagination  처리 (usersCnt -> paginationSize 계산)
- pagination  처리 로직에 따른 userService 로직 개선"
- pagination  처리 (usersCnt -> paginationSize 계산)
- pagination  처리 (pagination 화면 출력, li active class 추가)
- pagination  처리 (pagination 화면 출력, li active class 추가, 이전 페이지, 다음 페이지 가기 버튼)
</pre>

:whale: 2019.05.27
<pre>
- github 연동 설정 (학생실습)
- 웹 프로그래밍 흐름 파악(학생실습-주석달기)
- 에러 페이지 작성(404.html)
- 에러 페이지 작성(404.html->404.jsp)
- 상태유지 - 쿠키 테스트 코드 작성(학생실습)
- 상태유지 - 쿠키 테스트 코드 작성(학생실습)
- 상태유지 - 쿠키 테스트 코드 작성(교사 주도)
- 이클립스 디버깅 사용법
- 쿠키 코드 마이그레이션(자바->자바스크립트)
- remember me cookie 적용(client side)
- remember me cookie 적용(client side)
- remember me cookie 적용(server side)
- jdbc 컨넥션, dbcp 컨넥션
</pre>

:whale: 2019.05.28
<pre>
- github 연동 설정 (학생실습)
- 웹 프로그래밍 흐름 파악(학생실습-주석달기)
- 에러 페이지 작성(404.html)
- 에러 페이지 작성(404.html->404.jsp)
- 상태유지 - 쿠키 테스트 코드 작성(학생실습)
- 상태유지 - 쿠키 테스트 코드 작성(학생실습)
- 상태유지 - 쿠키 테스트 코드 작성(교사 주도)
- 이클립스 디버깅 사용법
- 쿠키 코드 마이그레이션(자바->자바스크립트)
- remember me cookie 적용(client side)
- remember me cookie 적용(client side)
- remember me cookie 적용(server side)
- jdbc 컨넥션, dbcp 컨넥션
</pre>

:whale: 2019.05.29
<pre>
- 쿠키를 사용한 자동 로그인 기능 개발(학생실습)
- 쿠키를 사용한 자동 로그인 기능 개발(학생실습) dbcp connection pool 개선
- dbcp connection pool 개선 jdni connection pool 개발

- 기존페이지 el 적용 (${pageContext.request.contextPath})
- 기존페이지 el 적용 (${pageContext.request.contextPath})
- userList 사용자 데이터 el, jstl 적용
- userPagingList 사용자 데이터 el, jstl 적용
- 테스트 주도 개발 예시(문자열 계산기)
- 테스트 주도 개발 예시(문자열 계산기)
- jstl core set, if
- jstl core if, forEach
</pre>

:whale: 2019.05.30
<pre>
- 사용자 로그인 프로세스 개선(mock 데이터 > db 데이터) 학생실습
- jstl c:chose
- header.jsp 사용자 아이디 표시 스크립틀릿, 표현식 > jstl, el
- header.jsp 사용자 아이디 표시 스크립틀릿, 표현식 > jstl, el
- userPagingList.jsp 페이지네이션 스크립틀릿, 표현식 > jstl, el
- c:forEach  인덱스 반복문

- maven cycle
- maven 배포
- 사용자 생일 컬럼 추가
- 사용자 상세 페이지
- 사용자 상세 페이지 화면 개발
- 사용자 상세 페이지 로직 개발
- 사용자 페이징 리스트 > 상세페이지 이동 확인
- 사용자 페이징 리스트 > 상세페이지 이동 확인
- 사용자 사진 조회 servlet 개발
</pre>

:whale: 2019.05.31
<pre>
- timeTables.jsp jstl, el 전환 > timesTablesJstl.jsp (실습)
- 날짜 사이 간격 평균 구하기 쿼리(실습)
- 주소 검색 api(다음주소)
- 사용자 등록 컨트롤러 개발(userFormController)
- 사용자 등록 쿼리, dao 개발(userDao.insertUser)
- 사용자 등록 개발(dao, service, controller)
- 사용자 수정 개발(dao, service, controller)(실습)
</pre>

:whale: 2019.06.03
<pre>
- 사용자 수정 개발(dao, service, controller) 리뷰
   - 사용자 생일 date 타입 포매팅
      1. 신규 getter
      2. select sql 수정 및 vo 필드 추가
      3. fmt formateDate
      
- 파일업로드
- content-disposition에서 파일명 받아오기(PartUtil)
- UUID를 통한 파일명 중복 피하기
- 파일명에서 파일 확장자 가져오기
- 년월로 업로드 폴더 구분하기
- 사용자 등록 프로필 업로드
- 사용자 수정 프로필 업로드(학생실습)
- noimage 처리

- 암호화
  - 로그인 프로세스 해쉬 암호 적용"
</pre>

:whale: 2019.06.04
<pre>
- 암호화
    - 사용자 업데이트 프로세스 해쉬 암호 적용
- 블록 암호화 알고리즘 테스트(kisa aria)
- 사용자 비밀번호 일괄수정(트랜잭션 개념 적용)
- 데이터 모델링 이론
- 게시판과제 설명
- 데이터 모델링 예시
- smart editor 사용방법 진행
- 게시판 실습 시작
</pre>

:whale: 2019.06.04 ~ 2019.06.12
<pre>
- 게시판 과제 기간
</pre>

:whale: 2019.06.13
<pre>
- jstl 국제화(fmt) - bundle, setBundle, message, param
- jstl 국제화(number) - formatNumber, parseNumber
- jstl 국제화(date) - formatDatae, parseDate
- jstl 국제화(timezone) - timezone, setTimezone
- jstl 국제화(select box 변경을 통한 locale 설정)
- 커스텀 태그 만들기 - logging tag
- 커스텀 태그 만들기 - loopLogging tag
- 커스텀 태그 만들기 - colorLogging tag
- 커스텀 태그 만들기 - rangers.tag
- 커스텀 태그 만들기 - code.tag
- Filter - 개념
- Filter - logging filter
- Filter - requestCount filter
</pre>

:whale: 2019.06.13
<pre>
- selectLocale - 학생실습
- Filter - requestCount filter
- Filter - loginCheck filter
- Filter - loginCheck filter
- request wrapper - DefaultParamWrapper, DefaultParamFilter
- request wrapper - DefaultParamWrapper, DefaultParamFilter
- Listener (session life cycle, session attribute)
- Listener (session attribute, application life cycle, session Binding)
   - pageContext.request.contextPath > cp
- mvc 패턴
- mvc 패턴 - front controller
</pre>

:whale: 2019.06.17
<pre>
- mvc 패턴 - front controller, RequetMapping, ViewResolver
- mvc 패턴 - RequetMapping - db 연동(DbDao)
- git branch (orphan)
- db index
- db 아키텍처, sql 실행원리
</pre>

 <br>
 
> Reference Site <br>

shields: [shields](https://shields.io/)<br>
emoji: [emoji](https://emoji.muan.co/)<br>
servlet: [servlet](https://mangkyu.tistory.com/14)<br>
jsp: [jsp](https://gmlwjd9405.github.io/2018/11/03/jsp.html)<br>
markdown: [markdown](https://gist.github.com/ihoneymon/652be052a0727ad59601)<br>
stackEdit: [stackEdit](https://stackedit.io/editor)




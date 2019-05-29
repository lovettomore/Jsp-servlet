package kr.or.ddit.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*

	문자열 계산기를 만들거에요
	
	ex) String text = "1,5,10,20";
		calculate(text) > 36
	
	1. 문자열 안의숫자를 구분짓는 구분사를 제거한 남은 숫자들을 전부 더한 값을 구한다.
	2. 구분자는 두가지가 가능 하다. "," ":"  >> "1,5:10,20" > 36
	3. 문자열이 공백이거나 null이면 0을 리턴합니다.
	4. 문자열 시작이 "//" 과 "\n"을 통해 커스텀 구분자를 지정할 수 있다. >> //;\n1;5;10;20 > 36
	5. 숫자 구분자는 커스텀 구분자와, 기본 구분자 두가지를 섞어 사용할 수 있다.
	
*/

public class Calculator {
	
	private String seperator = ",|:";
	
	public int calculate(String text) {
		if(isEmptyOrNull(text)) return 0;
		
		//custom seperator연산
		if(text.startsWith("//")) {
			Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
			
			if(m.find()){
				seperator = seperator + "|["+ m.group(1) +"]";
				text = m.group(2);
			}
		}
		
		//default seperator 연산 
		int result = calculateSum(text.split(seperator));
		return result;
	}

	private boolean isEmptyOrNull(String text) {
		return text == null || text.isEmpty();
	}

	private int calculateSum(String[] numberString) {
		int result = 0;
		for (String nuberString : numberString) {
			result += Integer.parseInt(nuberString);
		}
		return result;
	}

}

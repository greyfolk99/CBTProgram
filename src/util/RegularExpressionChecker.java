package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegularExpressionChecker {
	
	public RegularExpressionChecker(){};
	
	Matcher match;	

	public boolean idCheck(String id) {
		boolean chk = false;
		// 영문, 숫자 조합 (5~16 자리)
		String pattern6 = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{5,16}$";
		match = Pattern.compile(pattern6).matcher(id);	
		if(match.find()) {	
			chk = true;
		}
		return chk;
	}
	public boolean pwdCheck(String pwd) {
		boolean chk = false;
		// 영문, 숫자, 특수기호 조합 (7~20 자리)
		String pattern1 = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*?,./\\\\\\\\<>|_-[+]=\\\\`~\\\\(\\\\)\\\\[\\\\]\\\\{\\\\}])[A-Za-z[0-9]!@#$%^&*?,./\\\\\\\\<>|_-[+]=\\\\`~\\\\(\\\\)\\\\[\\\\]\\\\{\\\\}]{7,20}$";
		match = Pattern.compile(pattern1).matcher(pwd);	
		if(match.find()) {	
			chk = true;
		}
		return chk;
	}
	public boolean mobileCheck(String mobile) {
		 boolean chk = false;
		 String pattern ="^01(?:0|1|[6-9])(\\d{3,4})(\\d{4})$"; // 영문,  특수문자숫자,
		 try {
		 match = Pattern.compile(pattern).matcher(mobile);
		 if(match.find()) {//패턴에 맞는지 확인
			  chk = true;
		  }
		 }catch(PatternSyntaxException p) {chk = false;}
		  return chk;
	 }
	 public boolean emailCheck(String email) {
		 boolean chk = false;
		 String pattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"; 
		 match = Pattern.compile(pattern).matcher(email);
		 if(match.find()) {//패턴에 맞는지 확인
			  chk = true;
		  }
		  return chk;
	 }
}

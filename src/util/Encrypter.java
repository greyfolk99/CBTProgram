package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypter {
	public Encrypter(){};
	public String pwdEncrypt(String pwd) {
		MessageDigest md=null;
		try {
			//알고리즘 SHA-256을 사용한 MessageDigest 객체 생성
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(pwd.getBytes());//비밀번호를 암호화 해서 md 저장해 두었다 SHA-256 알고리즘
		pwd = String.format("%064x", new BigInteger(1, md.digest()));
		return pwd;
	}
}

package tech.hongjian.chapter6.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import tech.hongjian.chapter6.entity.User;

/**
 * @author xiahongjian
 * @time 2018-03-27 13:38:43
 *
 */
public class PasswordHelper {
	private RandomNumberGenerator generator = new SecureRandomNumberGenerator();
	private String algorithmName = "md5";

	public void encryptPassword(User user) {
		user.setSalt(generator.nextBytes().toHex());
		String cipher = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), 1)
				.toHex();
		user.setPassword(cipher);
	}
}

package tech.hongjian.chapter6.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

import tech.hongjian.chapter6.entity.User;

/**
 * @author xiahongjian 
 * @time   2018-03-28 10:32:27
 *
 */
public class MyRealm3 implements Realm {
	@Override
    public String getName() {
        return "c"; //realm name 为 “c”
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    	User user = new User("zhang", "123");
        return new SimpleAuthenticationInfo(
                user, //身份 字符串类型
                "123",   //凭据
                getName() //Realm Name
        );
    }
}

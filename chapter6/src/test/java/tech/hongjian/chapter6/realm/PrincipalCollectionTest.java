package tech.hongjian.chapter6.realm;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import tech.hongjian.chapter6.BaseTest;
import tech.hongjian.chapter6.entity.User;

/**
 * @author xiahongjian 
 * @time   2018-03-28 10:37:42
 *
 */
public class PrincipalCollectionTest extends BaseTest {
	@Test
	public void test() {
		login("classpath:shiro-multirealm.ini", "zhang", "123");
		Subject subject = subject();
		
		Object primaryPrincipal1 = subject.getPrincipal();
		PrincipalCollection principalCollection = subject.getPrincipals();
		Object primaryPrincipal2 = principalCollection.getPrimaryPrincipal();
		
		assertEquals(primaryPrincipal1, primaryPrincipal2);
		
		Set<String> realmNames = principalCollection.getRealmNames();
		System.out.println(realmNames);
		
		Set<Object> principals = principalCollection.asSet();
		System.out.println(principals);
		
		Collection<User> users = principalCollection.fromRealm("c");
		System.out.println(users);
	}
}

package tech.hongjian.chapter3.resolver;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.shiro.authz.Permission;

/**
 * @author xiahongjian 
 * @time   2018-03-26 13:25:43
 *
 */
public class BitPermission implements Permission {
	private String resourceIdentify;
	private int permissionBit;
	private String instanceId;
	
	public BitPermission(String permissionString) {
		String[] arr = permissionString.split("\\+");
		if (arr.length > 1) {
			resourceIdentify = arr[1];
		}
		if (StringUtils.isEmpty(resourceIdentify)) {
			resourceIdentify = "*";
		}
		if (arr.length > 2) {
			permissionBit = NumberUtils.toInt(arr[2]);
		}
		if (arr.length > 3) {
			instanceId = arr[3]; 
		}
		if (StringUtils.isEmpty(instanceId)) {
			instanceId = "*";
		}
	}
	
	
	
	@Override
	public boolean implies(Permission p) {
		if (!(p instanceof BitPermission))
			return false;
		BitPermission other = (BitPermission) p;
		if (!("*".equals(resourceIdentify) || resourceIdentify.equals(other.resourceIdentify))) {
			return false;
		}
		if (!(permissionBit == 0 || (permissionBit & other.permissionBit) != 0)) {
			return false;
		}
		if (!("*".equals(instanceId) || instanceId.equals(other.instanceId))) {
			return false;
		}
		return true;
	}

}

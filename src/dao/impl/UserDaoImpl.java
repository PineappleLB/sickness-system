package dao.impl;

import java.util.HashMap;
import java.util.Map;

import dao.UserDao;

/**
 * @author 作者 pineapple 
 * @E-mail: 2443755705@qq.com
 * @version 创建时间：2018年6月25日 下午4:32:37
 * @description 用户dao实现
 */
public class UserDaoImpl implements UserDao {

	@Override
	public Map<String, Object> selectUserByName(String name) {
		Map<String, Object> map = new HashMap<>();
		map.put("username", name);
		map.put("password", "123456");
		return map;
	}

}

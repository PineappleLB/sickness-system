package dao.impl;

import java.util.HashMap;
import java.util.Map;

import dao.AdminDao;

/**
 * @author 作者 pineapple 
 * @E-mail: 2443755705@qq.com
 * @version 创建时间：2018年6月25日 下午9:41:33
 * @description 类说明
 */
public class AdminDaoImpl implements AdminDao {

	@Override
	public Map<String, Object> selectAdminByName(String name) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("password", "123456");
		return map;
	}

}

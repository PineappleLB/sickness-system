package service.impl;

import java.util.Map;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

/**
 * @author 作者 pineapple 
 * @E-mail: 2443755705@qq.com
 * @version 创建时间：2018年6月25日 下午4:33:43
 * @description 用户service实现
 */
public class UserServiceImpl implements UserService {
	
	UserDao dao = new UserDaoImpl();

	@Override
	public Map<String, Object> selectUserByName(String name) {
		return dao.selectUserByName(name);
	}

	@Override
	public int userRegist(String name, String password, String sex, String age, String email, String phone,
			String home_addr, String work_addr) {
		return dao.userRegist(name, password, sex, age, email, phone, home_addr, work_addr);
	}

}

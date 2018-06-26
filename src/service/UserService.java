package service;

import java.util.Map;

/**
 * @author 作者 pineapple 
 * @E-mail: 2443755705@qq.com
 * @version 创建时间：2018年6月25日 下午4:33:19
 * @description 用户service接口
 */
public interface UserService {

	/**
	 * 根据姓名查询用户信息
	 * @return
	 */
	Map<String, Object> selectUserByName(String name);

	int userRegist(String name, String password, String sex, String age, String email, String phone, String home_addr,
			String work_addr);

}

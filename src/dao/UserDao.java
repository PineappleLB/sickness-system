package dao;

import java.util.Map;

/**
 * @author 作者 pineapple 
 * @E-mail: 2443755705@qq.com
 * @version 创建时间：2018年6月25日 下午4:31:55
 * @description 用户dao
 */
public interface UserDao {

	/**
	 * 根据姓名查询用户信息
	 * @param name
	 * @return
	 */
	Map<String, Object> selectUserByName(String name);

}

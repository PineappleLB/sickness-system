package dao;

import java.util.List;
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

	int userRegist(String name, String password, String sex, String age, String email, String phone, String home_addr,
			String work_addr);

	int addUserFadeBack(String user, String fade);

	int selectFadeBackCount();

	int deleteUserFadeback(String[] names);

	List<Map<String, String>> selectFadeBackList();

	int updateFadeListInfo(String name, String fadeback);

}

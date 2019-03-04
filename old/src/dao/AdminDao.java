package dao;

import java.util.Map;

/**
 * @author 作者 pineapple 
 * @E-mail: 2443755705@qq.com
 * @version 创建时间：2018年6月25日 下午9:41:23
 * @description 类说明
 */
public interface AdminDao {

	Map<String, Object> selectAdminByName(String name);

}

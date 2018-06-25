package service.impl;

import java.util.Map;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import service.AdminService;

/**
 * @author 作者 pineapple 
 * @E-mail: 2443755705@qq.com
 * @version 创建时间：2018年6月25日 下午9:40:54
 * @description 类说明
 */
public class AdminServiceImpl implements AdminService {

	AdminDao dao = new AdminDaoImpl();
	
	@Override
	public Map<String, Object> selectAdminByName(String name) {
		
		return dao.selectAdminByName(name);
	}

}

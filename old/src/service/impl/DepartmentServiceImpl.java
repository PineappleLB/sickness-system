package service.impl;

import java.util.List;
import java.util.Map;

import dao.DepartmentDao;
import dao.impl.DepartmentDaoImpl;
import service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDao dao = new  DepartmentDaoImpl();

	@Override
	public List<Map<String, Object>> selectAllDepartmentInfo() {
		return dao.selectAllDepartmentInfo();
	}

	@Override
	public int updateDepartmentInfo(String id, String name, String type, String phone, String address, String email) {
		return dao.updateDepartmentInfo(id, name, type, phone, address, email);
	}

	@Override
	public int addDepartmentInfo(String name, String type, String phone, String address, String email) {
		return dao.addDepartmentInfo(name, type, phone, address, email);
	}

	@Override
	public int delDepartmentInfo(String[] ids) {
		return dao.delDepartmentInfo(ids);
	}

}

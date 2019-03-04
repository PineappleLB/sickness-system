package dao;

import java.util.List;
import java.util.Map;

public interface DepartmentDao {

	List<Map<String, Object>> selectAllDepartmentInfo();

	int updateDepartmentInfo(String id, String name, String type, String phone, String address, String email);

	int addDepartmentInfo(String name, String type, String phone, String address, String email);

	int delDepartmentInfo(String[] ids);

}

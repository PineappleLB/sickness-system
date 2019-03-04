package dao;

import java.util.List;
import java.util.Map;

public interface SickerDao {

	List<Map<String, Object>> selectAllSickerInfo();

	int addSickerInfo(String name, String age, String home_address, String sick, String phone, String work_address,
			String scope);

	int updSickerInfo(String id, String age, String home_address, String sick, String phone, String work_address,
			String scope);

	int delSickerInfo(String[] ids);

	List<Map<String, Object>> selectSickerInfo(String sickType, String scopeType);

	List<Map<String, Object>> selectSickerCount(String sickType, String scopeType);

	List<Map<String, Object>> selectSickerInfoBy(String sel_text, String sel_type);

}

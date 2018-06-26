package service;

import java.util.List;
import java.util.Map;

public interface SickerService {

	List<Map<String, Object>> selectAllSickerInfo();

	int addSickerInfo(String name, String age, String home_address, String sick, String phone, String work_address,
			String scope);

	int updSickerInfo(String name, String age, String home_address, String sick, String phone, String work_address,
			String scope);

	int delSickerInfo(String[] ids);

	List<Map<String, Object>> selectSickerInfo(String sickType, String scopeType);

	List<Map<String, Object>> selectSickerCount(String sickType, String scopeType);

}

package service.impl;

import java.util.List;
import java.util.Map;

import dao.SickerDao;
import dao.impl.SickerDaoImpl;
import service.SickerService;

public class SickerServiceImpl implements SickerService {
	
	private SickerDao dao = new SickerDaoImpl();

	@Override
	public List<Map<String, Object>> selectAllSickerInfo() {
		return dao.selectAllSickerInfo();
	}

	@Override
	public int addSickerInfo(String name, String age, String home_address, String sick, String phone,
			String work_address, String scope) {
		return dao.addSickerInfo(name, age, home_address, sick, phone,
				work_address, scope);
	}

	@Override
	public int updSickerInfo(String id, String age, String home_address, String sick, String phone,
			String work_address, String scope) {
		return dao.updSickerInfo(id, age, home_address, sick, phone,
				work_address, scope);
	}

	@Override
	public int delSickerInfo(String[] ids) {
		return dao.delSickerInfo(ids);
	}

	@Override
	public List<Map<String, Object>> selectSickerInfo(String sickType, String scopeType) {
		return dao.selectSickerInfo(sickType, scopeType);
	}

	@Override
	public List<Map<String, Object>> selectSickerCount(String sickType, String scopeType) {
		return dao.selectSickerCount(sickType, scopeType);
	}

	@Override
	public List<Map<String, Object>> selectSickerInfoById(String sel_text, String sel_type) {
		return dao.selectSickerInfoBy(sel_text, sel_type);
	}

	@Override
	public List<Map<String, Object>> selectSickerInfoByName(String sel_text, String sel_type) {
		return dao.selectSickerInfoBy(sel_text, sel_type);
	}

}

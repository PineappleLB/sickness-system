package service.impl;

import java.util.List;
import java.util.Map;

import dao.SickDao;
import dao.impl.SickDaoImpl;
import service.SickService;

public class SickServiceImpl implements SickService {

	private SickDao dao = new SickDaoImpl();
	
	@Override
	public List<Map<String, Object>> selectAllSickerInfo() {
		// TODO Auto-generated method stub
		return dao.selectAllSickerInfo();
	}

}

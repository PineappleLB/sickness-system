package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.SickerDao;
import util.DatabaseUtil;
import util.Scope;
import util.Sick;

public class SickerDaoImpl implements SickerDao {
	
	private Connection conn = DatabaseUtil.getConnection();

	@Override
	public List<Map<String, Object>> selectAllSickerInfo() {
		return selectSickerInfo("all","all");
	}

	@Override
	public int addSickerInfo(String name, String age, String home_address, String sick, String phone,
			String work_address, String scope) {
		String sql = "insert into t_sicker_info (name,age,home_address,sick,phone,work_address,scope) " + 
				"values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, Integer.parseInt(age));
			ps.setString(3, home_address);
			ps.setString(4, sick);
			ps.setString(5, phone);
			ps.setString(6, work_address);
			ps.setString(7, scope);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int updSickerInfo(String name, String age, String home_address, String sick, String phone,
			String work_address, String scope) {
		String sql = "update t_sicker_info set age=?,home_address=?,sick=?,phone=?,work_address=?,scope=?) " + 
				"where name=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(age));
			ps.setString(2, home_address);
			ps.setString(3, sick);
			ps.setString(4, phone);
			ps.setString(5, work_address);
			ps.setString(6, scope);
			ps.setString(7, name);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int delSickerInfo(String[] ids) {
		String sql = "delete t_sicker_info where id in(";
		for (int i = 0; i < ids.length; i++) {
			if(ids[i] == null || ids[i].equals("")) {
				continue;
			}
			sql += "?,";
		}
		sql = new StringBuilder(sql).reverse().deleteCharAt(0).reverse().append(")").toString();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 0; i < ids.length; i++) {
				if(ids[i] == null || ids[i].equals("")) {
					continue;
				}
				ps.setString(i + 1, ids[i]);
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<Map<String, Object>> selectSickerInfo(String sickType, String scopeType) {
		String sql = "select * from t_sicker_info where 1=1";
		int i = 1;
		if(!sickType.equals("all")) {
			sql += "  and sick=?";
		} 
		if(!scopeType.equals("all")) {
			sql += " and scope=?";
		}
		List<Map<String, Object>> infos = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			if(!sickType.equals("all")) {
				ps.setString(i, sickType);
				i++;
			} 
			if(!scopeType.equals("all")) {
				ps.setString(i, scopeType);
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("id", rs.getInt("id"));
				map.put("name", rs.getString("name"));
				map.put("age", rs.getInt("age"));
				map.put("home_address", rs.getString("home_address"));
				map.put("sick", Sick.getSick(rs.getString("sick")));
				map.put("phone", rs.getString("phone"));
				map.put("work_address", rs.getString("work_address"));
				map.put("scope", Scope.getScope(rs.getString("scope")));
				infos.add(map);
			}
			return infos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Map<String, Object>> selectSickerCount(String sickType, String scopeType) {
		String sql = "select count(1) as count,sick,scope from t_sicker_info where 1=1 ";
		int i = 1;
		if(!sickType.equals("all")) {
			sql += " and sick=?";
		}
		if(!scopeType.equals("all")) {
			sql += " and scope=? ";
		}
		sql += " group by sick,scope";
		List<Map<String, Object>> infos = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			if(!sickType.equals("all")) {
				ps.setString(i, sickType);
				i++;
			} 
			if(!scopeType.equals("all")) {
				ps.setString(i, scopeType);
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("sick", Sick.getSick(rs.getString("sick")));
				map.put("scope", Scope.getScope(rs.getString("scope")));
				map.put("count", rs.getInt("count"));
				infos.add(map);
			}
			return infos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}

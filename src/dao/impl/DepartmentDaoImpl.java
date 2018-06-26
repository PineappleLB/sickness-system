package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DepartmentDao;
import util.DatabaseUtil;

public class DepartmentDaoImpl implements DepartmentDao {
	
	private Connection conn = DatabaseUtil.getConnection();

	@Override
	public List<Map<String, Object>> selectAllDepartmentInfo() {
		List<Map<String, Object>> infos = new ArrayList<>();
		String sql = "select * from t_department_info";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<>();
				m.put("department_id", rs.getInt("department_id"));
				m.put("department_name", rs.getString("department_name"));
				m.put("department_type", rs.getString("department_type"));
				m.put("department_address", rs.getString("department_address"));
				m.put("phone", rs.getString("phone"));
				m.put("email", rs.getString("email"));
				infos.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return infos;
	}

	@Override
	public int updateDepartmentInfo(String id, String name, String type, String phone, String address, String email) {
		
		String sql = "update t_department_info set department_name=?,department_type=?,department_address=?,phone=?,email=? where department_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, type);
			ps.setString(3, address);
			ps.setString(4, phone);
			ps.setString(5, email);
			ps.setString(6, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
	}

	@Override
	public int addDepartmentInfo(String name, String type, String phone, String address, String email) {
		String sql = "insert into t_department_info (department_name,department_type,department_address,phone,email)"
				+ "values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, type);
			ps.setString(3, address);
			ps.setString(4, phone);
			ps.setString(5, email);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int delDepartmentInfo(String[] ids) {
		String sql = "delete t_department_info where department_id in(";
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

}

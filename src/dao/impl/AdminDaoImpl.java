package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import dao.AdminDao;
import util.DatabaseUtil;

/**
 * @author 作者 pineapple 
 * @E-mail: 2443755705@qq.com
 * @version 创建时间：2018年6月25日 下午9:41:33
 * @description 类说明
 */
public class AdminDaoImpl implements AdminDao {

	private Connection conn = DatabaseUtil.getConnection();
	
	@Override
	public Map<String, Object> selectAdminByName(String name) {
		Map<String, Object> map = new HashMap<>();
		String sql = "select * from t_admin where name=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				map.put("id", rs.getString("id"));
				map.put("name", rs.getString("name"));
				map.put("password", rs.getString("password"));
				map.put("power", rs.getInt("power"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

}

package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import dao.UserDao;
import util.DatabaseUtil;

/**
 * @author 作者 pineapple 
 * @E-mail: 2443755705@qq.com
 * @version 创建时间：2018年6月25日 下午4:32:37
 * @description 用户dao实现
 */
public class UserDaoImpl implements UserDao {
	
	private Connection conn = DatabaseUtil.getConnection();

	@Override
	public Map<String, Object> selectUserByName(String name) {
		String sql = "select top 1 * from t_user where username=?";
		Map<String, Object> map = new HashMap<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				map.put("username", rs.getString("username"));
				map.put("password",  rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public int userRegist(String name, String password, String sex, String age, String email, String phone,
			String home_addr, String work_addr) {
		String sql = "insert into t_user (username,password,sex,age,email,phone,home_address,work_address) " + 
				"values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, sex);
			ps.setInt(4, Integer.parseInt(age));
			ps.setString(5, email);
			ps.setString(6, phone);
			ps.setString(7, home_addr);
			ps.setString(8, work_addr);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	
	
}

package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		String sql = "select top 1 * from t_user where username= ? ";
		Map<String, Object> map = new HashMap<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
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

	@Override
	public int addUserFadeBack(String user, String fade) {
		String sql = "insert into t_fadeback(name,fadeback) values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, fade);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int selectFadeBackCount() {
		String sql = "select count(1) as count from t_fadeback";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int result = 0;
			while(rs.next()) {
				result = rs.getInt("count");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int deleteUserFadeback(String[] names) {
		String sql = "delete t_fadeback where id in(";
		for (int i = 0; i < names.length; i++) {
			if(names[i] == null || names[i].equals("")) {
				continue;
			}
			sql += "?,";
		}
		sql = new StringBuilder(sql).reverse().deleteCharAt(0).reverse().append(")").toString();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 0; i < names.length; i++) {
				if(names[i] == null || names[i].equals("")) {
					continue;
				}
				ps.setString(i + 1, names[i]);
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<Map<String, String>> selectFadeBackList() {
		String sql = "select * from t_fadeback";
		List<Map<String, String>> infos = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("id", rs.getInt("id") + "");
				map.put("name", rs.getString("name"));
				map.put("fadeback", rs.getString("fadeback"));
				infos.add(map);
			}
			return infos;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public int updateFadeListInfo(String id, String fadeback) {
		String sql = "update t_fadeback set fadeback=? where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fadeback);
			ps.setString(2, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	
	
}

package com.jd.ebuy.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.jd.ebuy.dao.UserDao;
import com.jd.ebuy.domain.User;
import com.jd.ebuy.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {
	public void userRegist(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {user.getUid(),
				user.getUsername(),
				user.getPassword(),
				user.getName(),
				user.getEmail(),
				user.getTelephone(),
				user.getBirthday(),
				user.getSex(),
				user.getState()
				,user.getCode()};
		qr.update(sql, params);
		
	}
}

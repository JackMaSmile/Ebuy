package com.jd.ebuy.service.impl;

import java.sql.SQLException;

import com.jd.ebuy.dao.UserDao;
import com.jd.ebuy.dao.impl.UserDaoImpl;
import com.jd.ebuy.domain.User;
import com.jd.ebuy.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void userRegist(User user) throws SQLException {
		// TODO Auto-generated method stub
		UserDao userdao = new UserDaoImpl();
		userdao.userRegist(user);
	}

}

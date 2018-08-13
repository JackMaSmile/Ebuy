package com.jd.ebuy.dao;

import java.sql.SQLException;

import com.jd.ebuy.domain.User;

public interface UserDao  {

	void userRegist(User user)throws SQLException;

}

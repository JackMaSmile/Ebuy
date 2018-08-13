package com.jd.ebuy.service;

import java.sql.SQLException;

import com.jd.ebuy.domain.User;

public interface UserService {

	void userRegist(User user) throws SQLException;

}

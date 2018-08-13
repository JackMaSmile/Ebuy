package com.jd.ebuy.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jd.ebuy.domain.User;
import com.jd.ebuy.service.UserService;
import com.jd.ebuy.service.impl.UserServiceImpl;
import com.jd.ebuy.utils.MailUtils;
import com.jd.ebuy.utils.MyBeanUtils;
import com.jd.ebuy.utils.UUIDUtils;
import com.jd.ebuy.web.base.BaseServlet;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	
	public String registUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "/jsp/register.jsp";
	}
	
	
	public String userRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		// 接收表单参数
		User user = new User();
		MyBeanUtils.populate(user, request.getParameterMap());
		user.setUid(UUIDUtils.getId());
		user.setCode(UUIDUtils.getCode());
		//用常规方式遍历map中的值
//		Set<String> keySet = map.keySet();//拿到Map中的key值
//		System.out.println("key===="+keySet);
//		Iterator<String> iterator = keySet.iterator();//拿到key值的迭代器
//		while(iterator.hasNext()) {
//			String str = iterator.next();
//			String[] strings = map.get(str);	
//			for (String string : strings) {
//				System.out.println(string);
//			}
//			System.out.println("");
//		}
//		//用entrySet方式遍历map中的值
//		for (Map.Entry<String, String[]> strs : map.entrySet()) {
//			System.out.println("key===="+strs.getKey());
//			String[] value = strs.getValue();
//			for (String string : value) {
//				System.out.println(string);
//			}
//		}
		// 调用业务层注册功能
		UserService userService = new UserServiceImpl();
		try {
			userService.userRegist(user);
			//注册成功
			
			MailUtils.sendMail(user.getEmail(), user.getCode());
			
			request.setAttribute("msg", "成功");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//注册失败
			request.setAttribute("msg", "失败");
		}
		return "/jsp/info.jsp";
	}
	
}

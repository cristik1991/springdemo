package com.cristik.test;


import com.cristik.business.dao.UserMapper;
import com.cristik.business.entity.svo.User;
import com.cristik.framework.base.Result;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhenghua on 2016/3/9.
 */
public class JunitTest {
	private static BasicDataSource dataSource;
	private static ApplicationContext context;

	@BeforeClass
	public static void init(){
		context = new ClassPathXmlApplicationContext("spring-context.xml");
		dataSource = (BasicDataSource) context.getBean("dataSource");
	}

	@Test
	public void testDataBase() throws SQLException {
		Connection connection = dataSource.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select * from user");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql.toString());
		while(result.next()) {
			System.out.print(result.getObject(1) + "   ");
			System.out.print(result.getObject(2) + "   ");
			System.out.println(result.getObject(3) + "   ");
		}
	}

	@Test
	public void testMapper(){
		UserMapper userDao = (UserMapper) context.getBean("UserMapper");
		System.out.println(userDao.selectByPrimaryKey(new Integer(1)));
	}

	@Test
	public void testResult() {
		Result result = new Result();
		result.put("pageNo",3);
		result.put("pageSize",15);
		List list = new ArrayList<User>();
		for(int i=0;i<5;i++){
			User user = new User();
			user.setId(""+i);
			user.setUserName("张飞");
			user.setPassword("112222");
			list.add(user);
		}
		result.setList(list);

		result.setSuccess(true);
		result.setMsg("测试中");
		result.setUrl("www.baidu.com");

		System.out.println(result.toString());
	}
}


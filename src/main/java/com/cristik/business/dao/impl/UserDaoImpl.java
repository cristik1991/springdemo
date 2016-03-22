package com.cristik.business.dao.impl;

import com.cristik.business.dao.IUserDao;
import com.cristik.business.entity.svo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhenghua on 2016/3/10.
 */
@Repository
public class UserDaoImpl implements IUserDao{
	private static String NAMESPACE="com.cristik.dao.IUserDao.";
	@Autowired private SqlSessionFactory sqlSessionFactory;

	public User selectByPrimaryKey(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne(NAMESPACE+"selectByPrimaryKey",id);
		System.out.println(user);
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> getUserList() {
		return null;
	}

	@Override
	public int deleteUser(int id) {
		return 0;
	}

	@Override
	public int addUser(User user) {
		return 0;
	}

	@Override
	public int updateUser(User user) {
		return 0;
	}
}

package com.cristik.mybatis;

import com.cristik.business.dao.UserMapper;
import com.cristik.business.entity.svo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhenghua on 2016/3/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
@Transactional
public class MybatisTest {
    @Autowired
    UserMapper userDao;

    @Test
    public void testDelete(){
        User user = new User();
        user.setId("1");
        int num =userDao.deleteByPrimaryKey(2);
        System.out.println(num);
    }
}

package com.cristik.mybatis;

import com.cristik.business.dao.UserMapper;
import com.cristik.business.entity.svo.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhenghua on 2016/3/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
@Transactional
public class PageHelperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testPageHelper(){
        PageHelper.startPage(1,10);
        List<User> list = userMapper.selectAll();
        Long total = ((Page<User>) list).getTotal();
        System.out.println(total);
    }


}

package com.cristik.test;

import com.cristik.business.entity.svo.User;
import com.cristik.business.service.UserService;
import com.cristik.framework.exception.BusinessException;
import com.cristik.framework.utils.IdUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhenghua on 2016/3/22.
 */
public class EncryptTest {
    /**
     *
     */
    @Test
    public void testMD5(){
        String key ="我也不知道谁是sb";
        String result = DigestUtils.md5Hex(key.getBytes());
        System.out.println(result);
    }

    public static void main(String[] args) throws BusinessException {
        //启动Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        //获取service组件
        UserService service = (UserService) context.getBean("userService");
        //以普通的方式调用UserService对象的三个方法
        User user = new User();
        user.setId(1);
        service.deleteUser(1);
    }
}

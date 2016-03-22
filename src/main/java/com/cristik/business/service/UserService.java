package com.cristik.business.service;

import com.cristik.business.dao.UserMapper;
import com.cristik.business.entity.svo.User;
import com.cristik.framework.base.Result;
import com.cristik.framework.base.SessionHelper;
import com.cristik.framework.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;


/**
 * Created by zhenghua on 2016/3/10.
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getUserById(String id) {
        User user = new User();
        user.setId(id);
        user = userMapper.selectOne(user);
        return user;
    }

    public List<User> getUserList() {
        List<User> list = userMapper.selectAll();
        return list;
    }

    public void getUserByPage() {
        PageHelper.startPage(1, 10);
        List<User> list = userMapper.selectAll();
    }

    /**
     * 新增用户
     * @param user
     * @return
     * @throws BusinessException
     */
    public boolean insert(User user) throws BusinessException {
        user.setStatus(1);
        user.setEnable("Y");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        //用户名密码加密
        String password = user.getPassword();
        if(StringUtils.isNotBlank(password)){
            String pwd =  DigestUtils.md5Hex(password.toLowerCase().getBytes());
            user.setPassword(pwd);
        }else{
            throw new BusinessException("密码为空");
        }
        int id = userMapper.insert(user);
        if (id == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean login(User user) throws BusinessException {
        boolean flag = false;
        if(StringUtils.isNotBlank(user.getUserName())){
            if(StringUtils.isNotBlank(user.getPassword())){
                user.setPassword(DigestUtils.md5Hex(user.getPassword().getBytes()));
                List<User> list = userMapper.select(user);
                if(list.size()==1){
                    User loginUser = list.get(0);
                    loginUser.setPassword("");
                    SessionHelper.put(loginUser);
                    flag = true;
                }else{
                    throw new BusinessException("用户名密码不存在");
                }
            }else{
                throw new BusinessException("密码为空");
            }
        }else{
            throw new BusinessException("登陆用户名为空");
        }
        return flag;
    }

    public boolean deleteUser(String id) {
        Integer num = userMapper.deleteByPrimaryKey(id);
        boolean flag = false;
        if (num.intValue() == 1) {
            flag = true;
        }
        return flag;
    }

    public boolean updateUser(User user) {
        int num = userMapper.updateByPrimaryKey(user);
        boolean flag = false;
        if (num == 1) {
            flag = true;
        }
        return flag;
    }

}

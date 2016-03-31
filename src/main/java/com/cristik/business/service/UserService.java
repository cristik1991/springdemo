package com.cristik.business.service;

import com.cristik.business.dao.UserMapper;
import com.cristik.business.entity.svo.User;
import com.cristik.framework.base.SessionHelper;
import com.cristik.framework.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * Created by zhenghua on 2016/3/10.
 */
@Service
@Transactional
public class UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 根据主键查用户
     * @param id
     * @return
     */
    public User getUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user = userMapper.selectOne(user);
        return user;
    }

    /**
     * 查找所有用户列表
     * @return
     */
    public List<User> getUserList() {
        List<User> list = userMapper.selectAll();
        return list;
    }

    /**
     * 分页查询用户信息
     */
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
        if(checkUserName(user.getUserName())){
            throw new BusinessException("用户已被注册");
        }
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
            SessionHelper.putUser(user);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 用户登录
     * @param user
     * @return
     * @throws BusinessException
     */
    public boolean login(User user) throws BusinessException {
        boolean flag = false;
        if(StringUtils.isNotBlank(user.getUserName())){
            if(StringUtils.isNotBlank(user.getPassword())){
                user.setPassword(DigestUtils.md5Hex(user.getPassword().getBytes()));
                List<User> list = userMapper.select(user);
                if(list.size()==1){
                    User loginUser = list.get(0);
                    loginUser.setPassword("");
                    SessionHelper.putUser(loginUser);
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

    /**
     * 用户退出
     * @return
     */
    public boolean logout(){
        SessionHelper.remove();
        return true;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    public boolean deleteUser(Integer id) {
        Integer num = userMapper.deleteByPrimaryKey(id);
        boolean flag = false;
        if (num.intValue() == 1) {
            flag = true;
        }
        return flag;
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    public boolean updateUser(User user) {
        int num = userMapper.updateByPrimaryKeySelective(user);
        boolean flag = false;
        if (num == 1) {
            flag = true;
        }
        return flag;
    }

    public boolean checkUserName(String userName){
        User user = new User();
        user.setUserName(userName);
        List<User> list = userMapper.select(user);
        if(list.size()>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkEmail(String email){
        User user = new User();
        user.setEmail(email);
        List<User> list = userMapper.select(user);
        if(list.size()>0){
            return true;
        }else{
            return false;
        }
    }

}

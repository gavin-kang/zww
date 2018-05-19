package com.flyer.zww.user.service.impl;

import cn.hutool.core.util.NumberUtil;
import com.flyer.zww.user.dao.IUserDAO;
import com.flyer.zww.user.model.User;
import com.flyer.zww.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @Description:
 * @Author: kangqing
 * @date: 2018/5/12 15:22
 * @version:1.0
 *
 *
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<User> list() {
        return userDAO.list();
    }

    @Override
    public long insert(User user) {
        return userDAO.insert(user);
    }

    @Override
    public User findById(String id) {
        if(NumberUtil.isLong(id)){
            return userDAO.findById(Long.parseLong(id));
        }
        throw new RuntimeException("user id 不是一个long类型数字:" + id);

    }

    @Override
    public int update(User user) {
        return userDAO.update(user);
    }


}

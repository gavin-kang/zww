package com.flyer.zww.user.dao;

import com.flyer.com.flyer.platform.dao.IBaseDAO;
import com.flyer.zww.user.model.User;

import java.util.List;

/***
 * @Description:
 * @Author: kangqing
 * @date: 2018/5/12 15:17
 * @version:1.0
 *
 *
 */

public interface IUserDAO extends IBaseDAO {

    List<User> list();

    long insert(User user);


    User findById(long l);

    int update(User user);
}

package com.flyer.zww.user.service;

import com.flyer.zww.user.model.User;

import java.util.List;

/***
 * @Description:
 * @Author: kangqing
 * @date: 2018/5/12 15:21
 * @version:1.0
 *
 *
 */

public interface IUserService {

    List<User> list();

    long insert(User user);

    User findById(String id);

    int update(User user);
}

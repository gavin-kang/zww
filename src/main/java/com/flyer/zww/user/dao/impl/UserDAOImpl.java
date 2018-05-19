package com.flyer.zww.user.dao.impl;

import com.flyer.zww.user.dao.IUserDAO;
import com.flyer.zww.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * @Description:
 * @Author: kangqing
 * @date: 2018/5/12 15:23
 * @version:1.0
 *
 *
 */
@Repository
public class UserDAOImpl implements IUserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> list() {

        return jdbcTemplate.query(getSQL(LIST),new BeanPropertyRowMapper(User.class));
    }

    @Override
    public long insert(User user) {
        long id = -1;
        int rows = jdbcTemplate.update(getSQL(INSERT),new Object[]{
                    user.getUserName(),user.getPassWord(),user.getEmail(),user.getBackgroundPicture(),
                    user.getProfilePicture(),user.getIntroduction(),user.getValidataCode()});
        if(rows == 1){
            id = jdbcTemplate.queryForObject(SELECT_LAST_ID,Long.class);
        }
        user.setId(id);
        return id;
    }



    @Override
    public User findById(long l) {
        List<User> users = jdbcTemplate.query(getSQL(FIND_BY_ID),new Object[]{l},new BeanPropertyRowMapper(User.class));
        if(users == null || users.size() == 0){
            return null;
        }else{
            return users.get(0);
        }
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update(getSQL(UPDATE),new Object[]{
                user.getUserName(),user.getPassWord(),user.getEmail(),user.getBackgroundPicture(),
                user.getProfilePicture(),user.getIntroduction(),user.getValidataCode(),user.getId()});
    }

    @Override
    public String getSQL(String key) {
        String sql = "";
        if(LIST.equals(key)){
            sql = " SELECT * FROM USER ";
        }else if(INSERT.equals(key)){
            sql = " INSERT INTO USER(USER_NAME,PASS_WORD,EMAIL,BACKGROUND_PICTURE,PROFILE_PICTURE,INTRODUCTION,VALIDATA_CODE,CREATE_TIME,LAST_MODIFY_TIME)VALUES(?,?,?,?,?,?,?,UNIX_TIMESTAMP(now()),UNIX_TIMESTAMP(now())) ";
        }else if(FIND_BY_ID.equals(key)){
            sql = " SELECT * FROM USER WHERE ID = ? ";
        }else if(UPDATE.equals(key)){
            sql = " UPDATE USER SET USER_NAME = ? ,PASS_WORD = ?,EMAIL = ?,BACKGROUND_PICTURE = ?,PROFILE_PICTURE = ?,INTRODUCTION = ? ,VALIDATA_CODE = ? ,LAST_MODIFY_TIME = UNIX_TIMESTAMP(now()) WHERE ID = ? ";
        }else{
            throw new RuntimeException("未知SQL:" + key);
        }
        return sql;
    }
}

package com.flyer.com.flyer.platform.dao;

/***
 * @Description:
 * @Author: kangqing
 * @date: 2018/5/12 15:35
 * @version:1.0
 *
 *
 */
public interface IBaseDAO {
    String LIST         = "LIST";
    String INSERT       = "INSERT";
    String UPDATE       = "UPDATE";
    String DELETE       = "DELETE";
    String FIND_BY_ID   = "FIND_BY_ID";
    String SELECT_LAST_ID = " SELECT LAST_INSERT_ID() ";

    String getSQL(String key);
}

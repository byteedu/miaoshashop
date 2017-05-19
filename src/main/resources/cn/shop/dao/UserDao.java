package cn.shop.dao;

import org.apache.ibatis.annotations.Param;

import cn.shop.entity.User;

public interface UserDao {
	
	int insert(User record);
	
    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectLogin(@Param("username") String username, @Param("password")String password);
}
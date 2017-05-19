package cn.shop.dao;

import cn.shop.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    Admin selectLogin(@Param("userName") String userName, @Param("userPw") String userPw);
    int updatePasswordByUsername(@Param("userName")String userName,@Param("userPwNew")String userPwNew);
}
package com.meyou.dao;

import com.meyou.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lipeng on 2018/05/06.
 */
public interface UserDao {

    int add(UserEntity userEntity);

    UserEntity selectByUserId(@Param(value = "userId") String userId);

    UserEntity selectByEmail(String email);
}

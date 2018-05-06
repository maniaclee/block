package com.meyou.config;

import com.meyou.dao.UserDao;
import com.meyou.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by yangyibo on 17/1/18.
 */
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    UserDao userDao;

    public UserDetails loadUserByUsername(String username) {
        UserEntity user = userDao.selectByEmail(username);
        if (user != null) {
            return new User(user.getEmail(), user.getPassword(), null);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

}
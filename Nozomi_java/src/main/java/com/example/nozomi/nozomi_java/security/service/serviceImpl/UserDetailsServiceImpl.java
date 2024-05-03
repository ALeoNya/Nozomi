package com.example.nozomi.nozomi_java.security.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.nozomi.nozomi_java.mapper.RoleResourceMapper;
import com.example.nozomi.nozomi_java.mapper.UserAuthMapper;
import com.example.nozomi.nozomi_java.pojo.DTO.UserDetailsDTO;
import com.example.nozomi.nozomi_java.pojo.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *  一个接口方法, 用于通过用户名获取用户数据.
 *  返回 UserDetails 对象, 表示用户的核心信息 (用户名, 用户密码, 权限等信息).
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserAuthMapper userAuthMapper;
    @Autowired
    RoleResourceMapper roleResourceMapper;

    /**
     * 找到用户记录，UserDetailsService会将用户的详细信息封装成一个UserDetails对象。
     * 这个对象通常包含了用户的用户名、密码、角色、权限等关键信息。
     * 这个UserDetails对象随后会被用于验证用户提交的密码是否正确(authenticationManager)，以及确定用户被授予了哪些权限。
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户信息
        LambdaQueryWrapper<UserAuth> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserAuth::getUsername,username);  //LambdaQueryWrapper是查询语句
        UserAuth user = userAuthMapper.selectOne(wrapper);
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名或密码错误");
        }
//        System.out.println("根据名字查询到数据库中的用户凭证为: "+ user);  // 查询成功打印
//        List<String> permissionKeyList = roleResourceMapper.listPermsByUserId(user.getId());
        //
        List<String> list = new ArrayList<>(Arrays.asList("/user/login"));
        //封装成UserDetails对象返回给AuthtenticationManager
        return new UserDetailsDTO(user,list);
    }
}

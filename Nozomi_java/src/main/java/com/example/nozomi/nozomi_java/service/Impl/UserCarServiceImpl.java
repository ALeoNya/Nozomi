package com.example.nozomi.nozomi_java.service.Impl;

import com.example.nozomi.nozomi_java.mapper.UserCarMapper;
import com.example.nozomi.nozomi_java.pojo.Car;
import com.example.nozomi.nozomi_java.service.UserCarService;

import javax.annotation.Resource;
import java.util.List;

public class UserCarServiceImpl implements UserCarService {
    @Resource
    private UserCarMapper userCarMapper;
    @Override
    public List<Integer> getCarIdByUserId(int userId) {
        return userCarMapper.getCarIdByUserId(userId);
    }
}

package com.example.nozomi.nozomi_java.service.Impl;

import com.example.nozomi.nozomi_java.mapper.UserCarMapper;
import com.example.nozomi.nozomi_java.pojo.Car;
import com.example.nozomi.nozomi_java.pojo.UserCar;
import com.example.nozomi.nozomi_java.service.UserCarService;

import javax.annotation.Resource;
import java.util.List;

public class UserCarServiceImpl implements UserCarService {
    @Resource
    private UserCarMapper userCarMapper;

    @Override
    public boolean addUserCar(UserCar userCar) {
        return false;
    }

    @Override
    public List<Integer> getCarIdByUserId(int userId) {
        return userCarMapper.getCarIdByUserId(userId);
    }

    @Override
    public boolean changeSaleTypeByCarId(UserCar userCar) {
        try {
            userCarMapper.changeSaleTypeByCarId(userCar);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    @Override
    public boolean passMerchantStatus(int carId) {
        try {
            userCarMapper.passMerchantStatus(carId);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    @Override
    public boolean cancelMerchantStatus(int carId) {
        try {
        userCarMapper.cancelMerchantStatus(carId);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}

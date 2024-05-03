package com.example.nozomi.nozomi_java.service.Impl;

import com.example.nozomi.nozomi_java.mapper.CarInfoMapper;
import com.example.nozomi.nozomi_java.pojo.CarInfo;
import com.example.nozomi.nozomi_java.service.CarInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("CarInfoService")
public class CarInfoServiceImpl implements CarInfoService {
    @Resource
    private CarInfoMapper carInfoMapper;

    @Override
    public boolean addCarInfoById(CarInfo carInfo) {
        try {
            return true;
        } catch (RuntimeException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean deleteCarInfoById(int infoId) {
        try {
            return true;
        } catch (RuntimeException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public CarInfo getCarInfoById(int infoId) {
        try {
            return carInfoMapper.selectById(infoId);
        } catch (RuntimeException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public boolean updateCarInfo(CarInfo carInfo) {
//        try {
        System.out.println(carInfo);
            carInfoMapper.updateById(carInfo);
            return true;
//        } catch (RuntimeException e) {
//            System.out.println(e);
//            return false;
//        }
    }
}
